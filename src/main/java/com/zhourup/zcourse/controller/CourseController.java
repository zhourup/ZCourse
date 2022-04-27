package com.zhourup.zcourse.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhourup
 * @date 2022/4/27 22:48
 */
@RestController
public class CourseController {

    @GetMapping("app/login")
    public String login(){
        return "success";
    }
}
