package com.yun.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yun.dao.DeptMapper;
import com.yun.entity.Dept;
import com.yun.service.DeptService;
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
public class DeptServiceImpl extends ServiceImpl<DeptMapper, Dept> implements DeptService {
    @Resource
    private DeptMapper deptMapper;
    @Override
    public IPage pageCC(IPage<Dept> page, Wrapper wrapper) {
        return deptMapper.pageCC(page,wrapper);
    }



}
