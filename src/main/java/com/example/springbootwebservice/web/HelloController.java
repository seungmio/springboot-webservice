package com.example.springbootwebservice.web;

import com.example.springbootwebservice.web.dto.HelloResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    @GetMapping("/hello/dto")
    //외부에서 name 이란 이름으로 넘긴 파라미터를 메소드 파라미터 String name 에 저장하게 된다.
    public HelloResponseDto helloDto(@RequestParam("name") String name, //외부에서 API로 넘긴 파라미터를 가져오는 이노테이션
                                     @RequestParam("amount") int amount) {
        return new HelloResponseDto(name, amount);
    }
}
