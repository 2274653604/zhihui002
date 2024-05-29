package com.yun.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yun.entity.WorkArea;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author cc
 * @since 2024-05-03
 */
public interface WorkAreaService extends IService<WorkArea> {
    IPage pageCC(IPage<WorkArea> page, Wrapper wrapper);
}
