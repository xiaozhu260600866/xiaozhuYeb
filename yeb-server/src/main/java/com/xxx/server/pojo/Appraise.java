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
@TableName("t_appraise")
@ApiModel(value="Appraise对象", description="")
public class Appraise implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private Integer eid;

    @TableField("app_date")
    private LocalDate appDate;

    @TableField("app_result")
    private String appResult;

    @TableField("app_content")
    private String appContent;

    private String remark;


}
