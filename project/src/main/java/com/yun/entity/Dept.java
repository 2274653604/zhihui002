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
@ApiModel(value="Dept对象", description="")
public class Dept implements Serializable {

    private static final long serialVersionUID=1L;

      @TableId(value = "d_id", type = IdType.AUTO)
      private Integer dId;

    private String dName;

    private Integer sAdminId;
    private String sAdminname;
    private Integer dNum;


}
