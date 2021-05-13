package com.xxx.server.controller;


import com.xxx.server.pojo.RespBean;
import com.xxx.server.pojo.SysMsg;
import com.xxx.server.service.ISysMsgService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zhoubin
 * @since 2021-05-01
 */
@RestController
@RequestMapping("/msg")
public class SysMsgController {
    @Autowired
    private  ISysMsgService sysMsgService;
    @ApiOperation("日志类")
    @GetMapping("/all")
    public RespBean msgAll(){
        List<SysMsg> all = sysMsgService.getAll();
        return RespBean.success("成功",all);
    }


}
