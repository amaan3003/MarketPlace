package com.chaiaurcamera.marketplace.controller;

import com.chaiaurcamera.marketplace.model.Product;
import com.chaiaurcamera.marketplace.repo.ProductRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ProductController {

    private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping("/testsave")
    @ResponseBody
    public String testSave() {
        Product p = new Product();
        p.setName("Canon 1300D");
        p.setPrice(255.00);
        p.setDescription("5 year old Canon 1300D in good condition!");
        productRepository.save(p);

        return "Success! Product saved in H2 Database";
    }

    @GetMapping("/products")
    @ResponseBody
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    @GetMapping("/marketplace")
    public String showMarketplace(Model model) {
        List<Product> allProducts = productRepository.findAll();
        model.addAttribute("prods", allProducts);
        return "index";
    }

    @PostMapping("/add-product")
    public String addProduct(Product product) {

        productRepository.save(product);

        return "redirect:/marketplace";
    }


    @GetMapping("/delete-product/{id}")
    public String deleteProduct(@PathVariable Long id) {
        productRepository.deleteById(id);
        return "redirect:/marketplace";
    }


}
