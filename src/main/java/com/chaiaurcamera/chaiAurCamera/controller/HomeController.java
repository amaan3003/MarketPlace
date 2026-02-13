package com.chaiaurcamera.chaiAurCamera.controller;
import com.chaiaurcamera.chaiAurCamera.model.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {


    @GetMapping("/")
    @ResponseBody
    public String home(){
        return "Server ki ma kaa...";
    }


    @GetMapping("/home")
    public String homepage(){
        return "index";
    }

}

