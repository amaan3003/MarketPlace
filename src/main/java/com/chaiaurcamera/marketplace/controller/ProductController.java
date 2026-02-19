package com.chaiaurcamera.marketplace.controller;

import com.chaiaurcamera.marketplace.model.Product;
import com.chaiaurcamera.marketplace.repo.ProductRepository;
import com.chaiaurcamera.marketplace.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.UUID;

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

    @Autowired
    private ProductService productService;

    @PostMapping("/items/add")
    public String handleFileUpload(@ModelAttribute Product product,
                                   @RequestParam("imageFile") MultipartFile file,
                                   Model model) {

        if (file.isEmpty()) {
            model.addAttribute("error", "Oye! Camera ki photo toh daal pehle.");
            return "sell";
        }

        try {
            // Path logic
            String uploadDirectory = "src/main/resources/static/images/";

            // Folder check: Agar images folder nahi hai toh bana do (Safety first!)
            Path uploadPath = Paths.get(uploadDirectory);
            if (!Files.exists(uploadPath)) {
                Files.createDirectories(uploadPath);
            }

            String originalFilename = file.getOriginalFilename();
            String uniqueFileName = UUID.randomUUID().toString() + "_" + originalFilename;
            Path path = uploadPath.resolve(uniqueFileName);

            // File save logic
            Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);

            // Item URL set logic
            product.setImageUrl("/images/" + uniqueFileName);

            // Database save
            productService.saveProduct(product);

        } catch (IOException e) {
            e.printStackTrace();
            return "error";
        }

        return "redirect:/buy";
    }


}
