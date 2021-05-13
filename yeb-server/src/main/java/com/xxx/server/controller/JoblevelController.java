package com.xxx.server.controller;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xxx.server.pojo.Joblevel;
import com.xxx.server.pojo.RespBean;
import com.xxx.server.service.IJoblevelService;
import io.swagger.annotations.ApiOperation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zhoubin
 * @since 2021-05-01
 */
@RestController
@RequestMapping("/system/basic/joblevel")
public class JoblevelController {
    @Autowired
    private  IJoblevelService joblevelService;
    @ApiOperation("取全部积称")
    @GetMapping("/")
    public Map getLists(){
        //设置分页条件，Parameters:pageNum 页码pageSize 每页显示数量count 是否进行count查询
        PageHelper.startPage(2, 3, true);
        List<Joblevel> list = joblevelService.list();
        PageInfo<Joblevel> pageInfo = new PageInfo<Joblevel>(list);
        Map lists = RespBean.getLists(pageInfo, list);
        return lists;
    }

    @ApiOperation("添加积称")
    @PostMapping("/")
    public RespBean add(@RequestBody Joblevel joblevel){
        joblevel.setCreateDate(LocalDateTime.now());
        boolean save = joblevelService.save(joblevel);
        if(save){
            return RespBean.success("添加成功");
        }
        return RespBean.error("添加失败");
    }

    @ApiOperation("修改积称")
    @PutMapping("/")
    public  RespBean edit(@RequestBody Joblevel joblevel ){
        if(joblevelService.updateById(joblevel)){
            return RespBean.success("更新成功");
        }else{
            return RespBean.error("更新失败");
        }
    }
    @ApiOperation("删除积称")
    @DeleteMapping("/{id}")
    public RespBean del(@PathVariable("id") Integer id){
        boolean b = joblevelService.removeById(id);
        if(b){
            return RespBean.success("删除成功");
        }else{
            return RespBean.success("删除fail");
        }
    }
    @ApiOperation("按ids删除积称")
    @DeleteMapping("/")
    public RespBean delByIds(Integer[] ids){
        boolean b = joblevelService.removeByIds(Arrays.asList(ids));
        if(b){
            return RespBean.success("删除成功");
        }else{
            return RespBean.success("删除fail");
        }
    }


}
