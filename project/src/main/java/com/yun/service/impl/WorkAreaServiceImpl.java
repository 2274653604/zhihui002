package com.yun.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yun.dao.WorkAreaMapper;
import com.yun.entity.WorkArea;
import com.yun.service.WorkAreaService;
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
public class WorkAreaServiceImpl extends ServiceImpl<WorkAreaMapper, WorkArea> implements WorkAreaService {
    @Resource
    private WorkAreaMapper workAreaMapper;
    @Override
    public IPage pageCC(IPage<WorkArea> page, Wrapper wrapper) {
        return workAreaMapper.pageCC(page,wrapper);
    }


}
