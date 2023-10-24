package com.company.company;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IntroductionController {
    
    @GetMapping("/introduction")
    String getIntroduction() {
        return "introduction";
    }
}
