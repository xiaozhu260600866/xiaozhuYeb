package com.xxx.server.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.xxx.server.config.security.component.JwtTokenUtil;
import com.xxx.server.mapper.AdminMapper;
import com.xxx.server.mapper.RoleMapper;
import com.xxx.server.pojo.Admin;
import com.xxx.server.pojo.RespBean;
import com.xxx.server.pojo.Role;
import com.xxx.server.service.IAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zhoubin
 * @since 2021-05-01
 */
@Service
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin> implements IAdminService {
    @Autowired
    private  AdminMapper adminMapper;

    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private  PasswordEncoder passwordEncoder;
    @Value("${jwt.tokenHead}")
    private  String tokenHead;
    @Override
    public RespBean login(String username, String password, String code, HttpServletRequest request) {
        System.out.println("username"+username);
        System.out.println("password"+password);
        System.out.println("code"+code);

        String encode = passwordEncoder.encode("123");
        System.out.println("endcode"+encode);
        UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        System.out.println(userDetails);
        if(null == userDetails ||passwordEncoder.matches(password,userDetails.getPassword()) ){
            return RespBean.error("密码错误");
        }
        if(!userDetails.isEnabled()){
            return RespBean.error("帐号被禁用");
        }

        String token = jwtTokenUtil.generateToken(userDetails);
        UsernamePasswordAuthenticationToken authentication =
                new UsernamePasswordAuthenticationToken(userDetails, null,
                        userDetails.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authentication);

        Map<String,String> tokenMap = new HashMap<>();
        tokenMap.put("token",token);
        tokenMap.put("tokenHead",tokenHead);

        return RespBean.success("登录成功",tokenMap);
    }

    @Override
    public Admin getAdminByUserName(String username) {
        return adminMapper.selectOne(new QueryWrapper<Admin>().eq("username",username).eq("enabled",true));
    }

    @Override
    public List<Role> getRoles(Integer adminId) {
        return roleMapper.getRoles(adminId);
    }


}
