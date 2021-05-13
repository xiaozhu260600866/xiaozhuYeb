package com.xxx.server.pojo;

import com.github.pagehelper.PageInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

/**
 * 通用返回结果对象
 *
 * @author zhoubin
 * @since 1.0.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RespBean {
    private long code;
    private String message;
    private Object obj;

    /**
     * 成功返回结果
     *
     * @param message
     */
    public static RespBean success(String message) {
        return new RespBean(200, message, null);
    }
    /**
     * 成功返回结果
     *
     * @param obj
     * @param message
     */
    public static RespBean success(String message, Object obj) {
        return new RespBean(200, message, obj);
    }
    /**
     * 失败返回结果
     *
     * @param message
     */
    public static RespBean error(String message) {
        return new RespBean(500, message, null);
    }
    /**
     * 失败返回结果
     * @param message
     * @param obj
     * @return
     */
    public static RespBean error(String message,Object obj) {
        return new RespBean(500, message, obj);

    }
    public  static Map getLists(PageInfo pageInfo ,Object obj){
        Map<String,Object> result = new HashMap<String,Object>();
        result.put("data",obj);
        result.put("total",pageInfo.getTotal());
        result.put("last_page",pageInfo.getPages());
        result.put("current_page",pageInfo.getPageNum());
        return result;


    }
}
