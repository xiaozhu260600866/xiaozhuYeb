package com.xxx.server.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xxx.server.pojo.Menu;
import com.xxx.server.pojo.MenuRole;
import com.xxx.server.pojo.RespBean;
import com.xxx.server.pojo.Role;
import com.xxx.server.service.IMenuRoleService;
import com.xxx.server.service.IMenuService;
import com.xxx.server.service.IRoleService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("system/basic/permission")
public class PermissionController {
    @Autowired
    private IRoleService roleService;

    @Autowired
    private IMenuService menuService;

    @Autowired
    private IMenuRoleService menuRoleService;

    @ApiOperation("获取所有角色")
    @GetMapping("/")
    public List<Role> getLists(){
        return roleService.list();
    }
    @ApiOperation("增加角色")
    @PostMapping("/")
    public RespBean addRole(@RequestBody  Role role){
        if(!role.getName().startsWith("ROLE_")){
            role.setName("ROLE_"+role.getName());
        }
        if(roleService.save(role)){
            return RespBean.success("添加成功");
        }else{
            return RespBean.error("添加失败");
        }
    }

    @ApiOperation("修改角色")
    @PutMapping("/")
    public  RespBean editRole(@RequestBody Role role){

        if(roleService.updateById(role)){
            return RespBean.success("修改成功");
        }else{
            return RespBean.error("修改失败");
        }
    }

    @ApiOperation("删除角色")
    @DeleteMapping("/{rid}")
    public RespBean delRole(@PathVariable  Integer rid){
        if(roleService.removeById(rid)){
            return RespBean.success("删除成功");
        }
        return RespBean.error("删除失败");

    }

    @ApiOperation("取全部菜单")
    @GetMapping("/menus")
    public  List<Menu> getMenus(){
        return menuService.getAllMenus();
    }

    @ApiOperation("根据角色id查询菜单id")
    @GetMapping("/mid/{rid}")
    public List<Integer> getMenusByRoldId(@PathVariable Integer rid){
        List<Integer> rids = menuRoleService.list(new QueryWrapper<MenuRole>().
                eq("rid", rid)).stream().
                map(MenuRole::getMid).collect(Collectors.toList());
        return rids;
    }

    @ApiOperation("更新菜单")
    @PutMapping("/menu")
    public RespBean updateMenu(Integer rid, Integer[] mids){
        return menuRoleService.updateMenuRole(rid,mids);
        //return null;
    }


}
