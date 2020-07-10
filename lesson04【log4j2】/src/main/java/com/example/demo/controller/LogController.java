package com.example.demo.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pub")
@Log4j2
public class LogController {

    @GetMapping("/getLog")
    public String getLog(){
        log.debug("This is debug message");
        log.info("this is an info message");
        log.warn("this is a warn message");
        log.error("this is an error message");
        return "Log ....";
    }
}
