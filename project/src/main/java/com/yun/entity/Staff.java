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
@ApiModel(value="Staff对象", description="")
public class Staff implements Serializable {

    private static final long serialVersionUID=1L;

        @TableId(value = "s_id", type = IdType.AUTO)
        private Integer sId;

        private String sName;

        private String sSex;

        private Integer sAge;

        private Integer dId;

        private String dName;

        private Integer wId;

        private String wName;

        private String sStatus;
        private String sDegrees;
        private String sPost;


}
