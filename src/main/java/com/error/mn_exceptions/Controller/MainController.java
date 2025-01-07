package com.error.mn_exceptions.Controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
public class MainController {

    @GetMapping("/init")
    public String init(){
        int i = 100/0;
        System.out.println(i);
        return null;
    }
}
