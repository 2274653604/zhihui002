package com.yun.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yun.common.QueryPageParam;
import com.yun.common.Result;
import com.yun.dao.DeptMapper;
import com.yun.entity.Dept;
import com.yun.service.DeptService;
import com.yun.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author cc
 * @since 2024-05-03
 */
@RestController
@RequestMapping("/dept")
public class DeptController {
    @Resource
    @Autowired
    private DeptService deptService;
    @Autowired
    private DeptMapper deptMapper;
    @Autowired
    private StaffService staffService;
    @GetMapping("/list")
    public List<Dept> list(){
        return deptService.list();
    }
    @GetMapping("/getList")
    public List<Dept> countSum(){
        return deptMapper.getList();
    }

    //    @PostMapping("/save")
    //    public Result save(@RequestBody Goods goods){
    //        return goodsService.save(goods)?Result.suc():Result.fail();
    //    }

    //新增
    @PostMapping("/addDept")
    public Result save(@RequestBody Dept dept){
        return deptService.save(dept)?Result.suc(dept):Result.fail();
    }

    //    //修改
//    @PostMapping("/edit")
//    public Result mod(@RequestBody Dept dept){
//        return deptService.updateById(dept)?Result.suc(dept):Result.fail();
//    }
    @PostMapping("/edit")
    public Result mod(@RequestBody Dept dept){
        boolean deptUpdated = deptService.updateById(dept);
        if (deptUpdated) {
            // 如果部门信息更新成功，则触发更新员工信息
            staffService.updateStaffDepartment(dept.getDName(), dept.getDId());
            return Result.suc(dept);
        } else {
            return Result.fail("更新部门信息失败");
        }
    }



    //删除
    @GetMapping("/del")
    public Result delete(@RequestParam Integer id){
        System.out.println("删除操作");
        return deptService.removeById(id)?Result.suc(id):Result.fail();
    }
    //批量删除
    @PostMapping("/batchDelete")
//    public Result batchDelete(@RequestBody List<Integer> ids) {
    public Result batchDelete(@RequestBody Object ids) {
        System.out.println("批量删除操作");
        JSONObject json = (JSONObject) JSON.toJSON(ids);
        List<Integer> ids1 = (List<Integer>) json.get("ids");
        return deptService.removeByIds(ids1) ? Result.suc(ids1) : Result.fail();
    }



    //查询
    @PostMapping("/getDept")
    public Result listPage(@RequestBody QueryPageParam query){
        HashMap param = query.getParam();
        String name = (String)param.get("name");

        Page<Dept> page = new Page();
        page.setCurrent(query.getPageNum());
        page.setSize(query.getPageSize());

        LambdaQueryWrapper<Dept> lambdaQueryWrapper = new LambdaQueryWrapper();
        if(StringUtils.isNotBlank(name) && !"null".equals(name)){
            lambdaQueryWrapper.like(Dept::getDName,name);
        }


        IPage result = deptService.pageCC(page,lambdaQueryWrapper);
        return Result.suc(result.getRecords(),result.getTotal());
    }
}

