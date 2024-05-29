package com.yun.dao;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.yun.entity.Staff;
import org.apache.ibatis.annotations.Param;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author cc
 * @since 2024-05-03
 */
@Mapper
public interface StaffMapper extends BaseMapper<Staff> {


    IPage pageCC(IPage<Staff> page, @Param(Constants.WRAPPER) Wrapper wrapper);


    // 更新员工表中的部门名称
    void updateDepartmentNameByDepartmentId(@Param("dName") String departmentName, @Param("dId") Integer departmentId);


    void updateWorkAreaNameByWorkAreaId(@Param("wName") String WorkAreaName, @Param("wId") Integer WorkAreaId);

    List<Map<String, String>> selectAge();
    List<Map<String,String>> selectSex();
    List<Map<String,String>> selectPost();
    List<Map<String,String>> selectDegrees();
    int selectSum();

}
