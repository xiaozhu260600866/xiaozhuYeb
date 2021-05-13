package com.xxx.server.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xxx.server.pojo.SysMsg;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zhoubin
 * @since 2021-05-01
 */
public interface ISysMsgService extends IService<SysMsg> {

    List<SysMsg> getAll();
}
