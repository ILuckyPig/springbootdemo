package com.lu.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
    @RequestMapping("/myerror")
    public String error() throws Exception {
        throw new Exception("发生错误");
    }

    @RequestMapping("/hello")
    public String hello(@RequestParam String name) {
        return "Hello " + name;
    }
}
