package com.yun.dao;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.yun.entity.Dept;
import org.apache.ibatis.annotations.Param;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author cc
 * @since 2024-05-03
 */
@Mapper
public interface DeptMapper extends BaseMapper<Dept> {
    IPage pageCC(IPage<Dept> page, @Param(Constants.WRAPPER) Wrapper wrapper);

    List<Dept> getList();
}
