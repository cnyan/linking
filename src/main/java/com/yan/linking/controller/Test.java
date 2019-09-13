package com.yan.linking.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class Test {


    @RequestMapping("/")
    public String hello() {
        return "hello,test";
    }

}
