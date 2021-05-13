package com.xxx.server.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * <p>
 * 
 * </p>
 *
 * @author zhoubin
 * @since 2021-05-01
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_oplog")
@ApiModel(value="Oplog对象", description="")
public class Oplog implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    @TableField("add_date")
    private LocalDate addDate;

    private String operate;

    private Integer adminid;


}
