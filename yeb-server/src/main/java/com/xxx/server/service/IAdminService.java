package com.xxx.server.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xxx.server.pojo.Admin;
import com.xxx.server.pojo.Menu;
import com.xxx.server.pojo.RespBean;
import com.xxx.server.pojo.Role;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zhoubin
 * @since 2021-05-01
 */
public interface IAdminService extends IService<Admin> {

    RespBean login(String username,
                   String password,
                   String code,
                   HttpServletRequest request);

    Admin getAdminByUserName(String username);

    List<Role> getRoles(Integer adminId);


}
