package com.unittesting.unittestwithmockito.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @GetMapping(path = "/hello-world")
    public  String helloWorld(){
        return "Hello World";
    }
}
