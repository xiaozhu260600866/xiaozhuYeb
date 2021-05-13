package com.xxx.server.controller;


import com.xxx.server.pojo.Position;
import com.xxx.server.pojo.RespBean;
import com.xxx.server.service.IPositionService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Arrays;
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
@RequestMapping("/system/basic/pos")
public class PositionController {
    @Autowired
    private IPositionService positionService;
    @ApiOperation("获取所有职位信息")
    @GetMapping("/")
    public List<Position> getLists(){
        return positionService.list();
    }
    @ApiOperation("添加职位你信息")
    @PostMapping("/")
    public RespBean add(@RequestBody Position position){
        position.setCreateDate(LocalDateTime.now());
        if(positionService.save(position)){
             return RespBean.success("添加成功");
        }else{
            return RespBean.error("添加失败");
        }
    }
    @ApiOperation("修改职位你信息")
    @PutMapping ("/")
    public RespBean edit(@RequestBody Position position){
        position.setCreateDate(LocalDateTime.now());
        if(positionService.updateById(position)){
            return RespBean.success("修改成功");
        }else{
            return RespBean.error("修改失败");
        }
    }

    @ApiOperation("删除职位信息")
    @DeleteMapping("/{id}")
    public RespBean del(@PathVariable  Integer id){
        if(positionService.removeById(id)){
            return RespBean.success("删除成功");
        }else{
            return RespBean.error("删除失败");
        }
    }
    @ApiOperation("批量删除职位信息")
    @DeleteMapping("/")
    public RespBean delAll(Integer[] ids){
        if(positionService.removeByIds(Arrays.asList(ids))){
            return RespBean.success("删除成功");
        }
        return RespBean.error("删除失败");
    }



}
