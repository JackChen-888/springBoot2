package com.javaboy.boot.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Chen
 * @description
 * @date 2021/1/19
 */
@Slf4j
@RestController
public class HelloController {
    @RequestMapping("/hello")
    public String handle01() {
        log.info("请求进来了");
        return "Hello SSS";
    }
}