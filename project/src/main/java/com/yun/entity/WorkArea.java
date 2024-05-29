package com.yun.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author cc
 * @since 2024-05-03
 */
@Data
  @EqualsAndHashCode(callSuper = false)
  @Accessors(chain = true)
@ApiModel(value="WorkArea对象", description="")
public class WorkArea implements Serializable {

    private static final long serialVersionUID=1L;

      @TableId(value = "w_id", type = IdType.AUTO)
      private Integer wId;

    private String wName;

    private Integer sAdminId;
    private String sAdminname;

    private String wStatus;
    private Integer wNum;


}
