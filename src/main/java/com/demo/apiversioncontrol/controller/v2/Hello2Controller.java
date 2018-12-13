package com.demo.apiversioncontrol.controller.v2;

import com.demo.apiversioncontrol.annotation.ApiVersion;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@ApiVersion(2)
@RestController
@RequestMapping("{version}/hello")
public class Hello2Controller {
    @RequestMapping("/world")
    public String helloWorld() {
        System.out.println("版本是2的接口");
        return "hello,world .version is 2";
    }
}