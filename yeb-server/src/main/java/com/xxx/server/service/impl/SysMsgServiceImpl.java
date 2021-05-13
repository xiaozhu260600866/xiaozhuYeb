package com.xxx.server.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.xxx.server.mapper.SysMsgMapper;
import com.xxx.server.pojo.SysMsg;
import com.xxx.server.service.ISysMsgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zhoubin
 * @since 2021-05-01
 */
@Service
public class SysMsgServiceImpl extends ServiceImpl<SysMsgMapper, SysMsg> implements ISysMsgService {
    @Autowired
    private  SysMsgMapper sysMsgMapper;
    @Override
    public List<SysMsg> getAll() {
        return sysMsgMapper.getAll();
    }
}
