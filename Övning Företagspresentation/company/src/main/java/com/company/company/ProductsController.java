package com.company.company;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProductsController {

    private static final List<Products> productItems = new ArrayList<>();
    static {
        productItems.add(new Products("Kanelbulle", 1));
        productItems.add(new Products("Chokladboll", 2));
        productItems.add(new Products("Princesstårta", 3));
        productItems.add(new Products("Lussekatt", 4));
    }
    
    @GetMapping("/products")
    String getProducts(Model productModel) {
        productModel.addAttribute("productItems", productItems);
        productModel.addAttribute("newProduct", new Products(null, 0));
        return "products";
    }

    @PostMapping("/new-product")
    String newProduct(@RequestParam("productName") String productName) {
        System.out.println("PostMapping " + productName);
        productItems.add(new Products(productName, productItems.size() + 1));
        return "redirect:/products";
    }

    @GetMapping("/remove-productItem/{productItemId}")
    String removeProductItem(@PathVariable int productItemId) {
        System.out.println("Du tog bort produkten med id: " + productItemId);
        productItems.removeIf(productItem -> productItem.getProductId() == productItemId);
        return "redirect:/products";
    }
}
