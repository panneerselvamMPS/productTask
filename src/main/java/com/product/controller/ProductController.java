package com.product.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.product.entity.Product;
import com.product.service.ProductService;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/")
    public String home(){
        return "home";
    }
    
    @PostMapping("/addProduct")
    public String redirectAddPage(){
        return "product";
    }

    @PostMapping("/addPage")
    public String addFeedBack(@ModelAttribute Product product){
    	productService.saveProduct(product);
        return "redirect:/all";
    }
    
    @GetMapping("/all")
    public String allProducts(Model model){
    	model.addAttribute("products", productService.allProducts());
        return "allProducts";
    }


}
