package com.xxx.server.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

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
@TableName("t_menu")
@ApiModel(value="Menu对象", description="")
public class Menu implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private String url;

    private String path;

    private String component;

    private String name;

    @TableField("icon_cls")
    private String iconCls;

    @TableField("keep_alive")
    private Boolean keepAlive;

    @TableField("require_auth")
    private Boolean requireAuth;

    @TableField("parent_id")
    private Integer parentId;

    private Boolean enabled;

    @ApiModelProperty("子菜单")
    @TableField(exist = false)
    private List<Menu> children;

    @ApiModelProperty("角色列表")
    @TableField(exist = false)
    private  List<Role> roles;


}
