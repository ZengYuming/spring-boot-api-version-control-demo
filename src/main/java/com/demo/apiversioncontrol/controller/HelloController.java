package com.demo.apiversioncontrol.controller;

import com.demo.apiversioncontrol.annotation.ApiVersion;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("hello")
public class HelloController {
    @RequestMapping("/world")
    public String helloWorld(){
        System.out.println("无版本的接口");
        return "hello,world .version is none";
    }
}