package com.xxx.server.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

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
@TableName("t_mail_log")
@ApiModel(value="MailLog对象", description="")
public class MailLog implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "消息id")
    @TableField("msg_id")
    private String msgId;

    @ApiModelProperty(value = "接收员id")
    private Integer eid;

    @ApiModelProperty(value = "状态")
    private Integer status;

    @TableField("route_key")
    private String routeKey;

    private String exchange;

    private Integer count;

    @TableField("try_time")
    private LocalDateTime tryTime;

    @TableField("create_time")
    private LocalDateTime createTime;

    @TableId("update_time")
    private LocalDateTime updateTime;


}
