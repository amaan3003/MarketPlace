package com.chaiaurcamera.marketplace.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MarketplaceController {


    @GetMapping("/")
    public String home(){
        return "index";
    }

    @GetMapping("/sell")
    public String sellForm(){
        return "sell";
    }

    @GetMapping("/buy")
    public String catalogue(){
        return "catalogue";
    }

}

