package com.yun.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yun.common.QueryPageParam;
import com.yun.common.Result;
import com.yun.dao.StaffMapper;
import com.yun.entity.Staff;
import com.yun.service.DeptService;
import com.yun.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author cc
 * @since 2024-05-03
 */
@RestController
@RequestMapping("/staff")
public class StaffController {

    @Resource
    @Autowired
    private StaffService staffService;
    @Autowired
    private StaffMapper staffMapper;
    @Autowired
    private DeptService deptService;
    @GetMapping("/list")
    public List<Staff> list(){
        return staffService.list();
    }
    @GetMapping("/countSum")
    public int countSum(){
        return staffMapper.selectSum();
    }
    @GetMapping("/countAge")
    public List<Map<String,String>> countAge(){
        return staffMapper.selectAge();
    }
    @GetMapping("/countDegrees")
    public List<Map<String,String>> countDegrees(){
        return staffMapper.selectDegrees();
    }
    @GetMapping("/countPost")
    public List<Map<String,String>> countPost(){
        return staffMapper.selectPost();
    }
    //    @PostMapping("/save")
    //    public Result save(@RequestBody Goods goods){
    //        return goodsService.save(goods)?Result.suc():Result.fail();
    //    }


    //新增
    @PostMapping("/addStaff")
    public Result save(@RequestBody Staff staff){
        return staffService.save(staff)?Result.suc(staff):Result.fail();
    }
    //修改
    @PostMapping("/edit")
    public Result mod(@RequestBody Staff staff) {
        return staffService.updateById(staff)?Result.suc(staff):Result.fail();
    }
    //删除
    @GetMapping("/del")
    public Result delete(@RequestParam Integer id){
        System.out.println("删除操作");
        return staffService.removeById(id)?Result.suc(id):Result.fail();
    }
    //批量删除
    @PostMapping("/batchDelete")
//    public Result batchDelete(@RequestBody List<Integer> ids) {
    public Result batchDelete(@RequestBody Object ids) {
        System.out.println("批量删除操作");
        JSONObject json = (JSONObject) JSON.toJSON(ids);
        List<Integer> ids1 = (List<Integer>) json.get("ids");
        return staffService.removeByIds(ids1) ? Result.suc(ids1) : Result.fail();
    }

    @GetMapping("/countSex")
    public List<Map<String,String>> countSex(){
        return staffMapper.selectSex();
    }



    //查询
    @PostMapping("/getStaff")
    public Result listPage(@RequestBody QueryPageParam query){
//        HashMap param = query.getParam();
        HashMap param = query.getParam();
        String name = (String)param.get("name");
        String dName = (String) param.get("dname");
        String wName = (String) param.get("wname");
        String sstatus = (String) param.get("sstatus");

        Page<Staff> page = new Page<>();
        page.setCurrent(query.getPageNum());
        page.setSize(query.getPageSize());

        LambdaQueryWrapper<Staff> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        if(StringUtils.isNotBlank(name) && !"null".equals(name)){
            lambdaQueryWrapper.like(Staff::getSName,name);
        }
        if (StringUtils.isNotBlank(dName) && !"null".equals(dName)) {
            lambdaQueryWrapper.like(Staff::getDName, dName);
        }
        if (StringUtils.isNotBlank(wName) && !"null".equals(wName)) {
            lambdaQueryWrapper.like(Staff::getWName, wName);
        }
        if (StringUtils.isNotBlank(sstatus) && !"null".equals(sstatus)) {
            lambdaQueryWrapper.like(Staff::getSStatus, sstatus);
        }

        IPage result = staffService.pageCC(page,lambdaQueryWrapper);
        return Result.suc(result.getRecords(),result.getTotal());


    }


}

