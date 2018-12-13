package com.demo.apiversioncontrol.controller.v1;

import com.demo.apiversioncontrol.annotation.ApiVersion;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@ApiVersion(1)
@RestController
@RequestMapping("{version}/hello")
public class Hello1Controller {
    @RequestMapping("/world")
    public String helloWorld(){
        System.out.println("版本是1的接口");
        return "hello,world .version is 1";
    }
}

