package com.lgk.myspringboot.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author liangguangkai
 * @date 2022/9/14 ${Time}
 * @version 1.0
 */   
@ApiModel(value="com-lgk-myspringboot-entity-Man")
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "man")
public class Man implements Serializable {
    @TableId(value = "id", type = IdType.AUTO)
//    @TableField(value = "id")
    @ApiModelProperty(value="")
    private Integer id;

    @TableField(value = "name")
    @ApiModelProperty(value="")
    private String name;

    @TableField(value = "money")
    @ApiModelProperty(value="")
    private Integer money;
}