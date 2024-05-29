package com.yun.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yun.dao.StaffMapper;
import com.yun.entity.Staff;
import com.yun.service.StaffService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author cc
 * @since 2024-05-03
 */
@Service
public class StaffServiceImpl extends ServiceImpl<StaffMapper, Staff> implements StaffService {

    @Resource
    private StaffMapper staffMapper;
    @Override
    public IPage pageCC(IPage<Staff> page, Wrapper wrapper) {
        return staffMapper.pageCC(page,wrapper);
    }

    // 更新员工表中的部门名称
    public void updateStaffDepartment(String departmentName, Integer departmentId) {
        staffMapper.updateDepartmentNameByDepartmentId(departmentName, departmentId);
    }

    public void updateWorkArea(String WorkAreaName, Integer WorkAreaId) {
        staffMapper.updateWorkAreaNameByWorkAreaId(WorkAreaName, WorkAreaId);
    }
}
