package com.yun.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yun.common.QueryPageParam;
import com.yun.common.Result;
import com.yun.entity.WorkArea;
import com.yun.service.StaffService;
import com.yun.service.WorkAreaService;
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
@RequestMapping("/workarea")
public class WorkAreaController {
    @Resource
    @Autowired
    private WorkAreaService workAreaService;
    @Autowired
    private StaffService staffService;
    @GetMapping("/list")
    public List<WorkArea> list(){
        return workAreaService.list();
    }

    //    @PostMapping("/save")
    //    public Result save(@RequestBody Goods goods){
    //        return goodsService.save(goods)?Result.suc():Result.fail();
    //    }

    //新增
    @PostMapping("/addWorkArea")
    public Result save(@RequestBody WorkArea workarea){
        return workAreaService.save(workarea)?Result.suc(workarea):Result.fail();
    }
    //修改
    @PostMapping("/edit")
    public Result mod(@RequestBody WorkArea workarea){
        boolean deptUpdated = workAreaService.updateById(workarea);
        if (deptUpdated) {
            // 如果部门信息更新成功，则触发更新员工信息
            staffService.updateWorkArea(workarea.getWName(), workarea.getWId());
            return Result.suc(workarea);
        } else {
            return Result.fail("更新部门信息失败");
        }
    }
    //删除
    @GetMapping("/del")
    public Result delete(@RequestParam Integer id){
        System.out.println("删除操作");
        return workAreaService.removeById(id)?Result.suc(id):Result.fail();
    }
    //批量删除
    @PostMapping("/batchDelete")
//    public Result batchDelete(@RequestBody List<Integer> ids) {
    public Result batchDelete(@RequestBody Object ids) {
        System.out.println("批量删除操作");
        JSONObject json = (JSONObject) JSON.toJSON(ids);
        List<Integer> ids1 = (List<Integer>) json.get("ids");
        return workAreaService.removeByIds(ids1) ? Result.suc(ids1) : Result.fail();
    }



    //查询
    @PostMapping("/getWorkArea")
    public Result listPage(@RequestBody QueryPageParam query){
        HashMap param = query.getParam();
        String name = (String)param.get("name");
        String wstatus = (String) param.get("wstatus");

        Page<WorkArea> page = new Page();
        page.setCurrent(query.getPageNum());
        page.setSize(query.getPageSize());

        LambdaQueryWrapper<WorkArea> lambdaQueryWrapper = new LambdaQueryWrapper();
        if(StringUtils.isNotBlank(name) && !"null".equals(name)){
            lambdaQueryWrapper.like(WorkArea::getWName,name);
        }
        if (StringUtils.isNotBlank(wstatus) && !"null".equals(wstatus)) {
            lambdaQueryWrapper.like(WorkArea::getWStatus, wstatus);
        }


        IPage result = workAreaService.pageCC(page,lambdaQueryWrapper);
        return Result.suc(result.getRecords(),result.getTotal());
    }
}

