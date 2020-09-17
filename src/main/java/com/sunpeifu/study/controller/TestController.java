package com.sunpeifu.study.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 作者:  daike
 * 日期:  2020/9/17
 * 描述:
 */
@RestController
public class TestController {

    @GetMapping("test")
    public String test() {
        return "success";
    }
}
