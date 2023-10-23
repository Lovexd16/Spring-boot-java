package com.thymeleaf.thymeleaf;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class Home {

    @GetMapping("/home")
    String getHome(Model model) {
        model.addAttribute("framework", "Thymeleaf!");
        return "home";
    }

    
}
