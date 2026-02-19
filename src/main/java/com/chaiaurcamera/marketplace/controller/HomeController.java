package com.chaiaurcamera.marketplace.controller;


import com.chaiaurcamera.marketplace.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;

@Controller
public class HomeController {

    @Autowired
    private ProductService productService;


    @GetMapping("/")
    public String home(Model model){
        model.addAttribute("prods", productService.getAllProducts());
        return "index";
    }




}

