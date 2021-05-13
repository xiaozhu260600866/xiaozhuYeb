package com.xxx.server.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
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
 * @author zhoubin
 * @since 2021-05-01
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_sys_msg")
@ApiModel(value="SysMsg对象", description="")
public class SysMsg implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private Integer mid;

    private Integer type;

    private Integer adminid;

    private Integer state;
    @TableField(exist = false)
    private  SysMsgContent sysMsgContent;


}
