package com.xxx.server.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/employee/basic/hello")
    public String authText(){
        return "employee/basic/hello";
    }
    @GetMapping("/employee/advanced/hello")
    public String authTex2(){
        return "employee/advanced/hello";
    }

}
