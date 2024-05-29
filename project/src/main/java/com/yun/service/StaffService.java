package com.yun.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yun.entity.Staff;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author cc
 * @since 2024-05-03
 */


public interface StaffService extends IService<Staff> {
    IPage pageCC(IPage<Staff> page, Wrapper wrapper);

    public void updateStaffDepartment(String departmentName, Integer departmentId);
    public void updateWorkArea(String WorkAreaName, Integer WorkAreaId);
}
