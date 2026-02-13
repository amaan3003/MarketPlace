package com.chaiaurcamera.chaiAurCamera.controller;
import com.chaiaurcamera.chaiAurCamera.model.Product;
import com.chaiaurcamera.chaiAurCamera.repo.ProductRepository;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {




    private final ProductRepository productRepository;


    public TestController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }



    @GetMapping("/testsave")
    @ResponseBody
    public String testSave() {
        Product p = new Product();
        p.setName("Dublin Rain Jacket");
        p.setPrice(45.50);
        p.setDescription("Waterproof jacket for Dublin weather");
        productRepository.save(p);

        return "Success! Product saved in H2 Database. Go check the console!";
    }


}