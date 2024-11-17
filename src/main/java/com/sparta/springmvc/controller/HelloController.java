package com.sparta.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

// 경로는 중복 가능하지만 메서드까지는 중복 불가능함!!!
@Controller
@RequestMapping("/api") // api 중복 문제 해결 -> /api로 시작되는 요청을 클래스에 적용(Method path에)
public class HelloController {
    @GetMapping("/hello")
    @ResponseBody // 순수 문자열 반환
    public String hello() {
        return "Hello World";
    }

    @GetMapping("/get")
    @ResponseBody
    public String get(){
        return "Get Method 요청";
    }

    @PostMapping("/post")
    @ResponseBody
    public String post(){
        return "POST Method 요청";
    }

    @PutMapping("/put")
    @ResponseBody
    public String put() {
        return "Put Method 요청";
    }

    @DeleteMapping("/delete")
    @ResponseBody
    public String delete() {
        return "Delete Method 요청";
    }
}
