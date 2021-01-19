package com.javaboy.boot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Chen
 * @description
 * @date 2021/1/19
 */
@RestController
public class HelloController {
    @RequestMapping("/hello")
    public String handle01() {
        return "Hello SpringBoot2";
    }
}