package com.theCaffeine.mes.comm.main.web;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class TestController {

    @RequestMapping("/")
    public String main(){
        return "layout/index";
    }
	
}
