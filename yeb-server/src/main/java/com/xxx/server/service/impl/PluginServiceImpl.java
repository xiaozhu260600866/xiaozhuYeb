package com.xxx.server.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.xxx.server.mapper.PluginMapper;
import com.xxx.server.pojo.Plugin;
import com.xxx.server.service.IPluginService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zhoubin
 * @since 2021-05-01
 */
@Service
public class PluginServiceImpl extends ServiceImpl<PluginMapper, Plugin> implements IPluginService {

}
