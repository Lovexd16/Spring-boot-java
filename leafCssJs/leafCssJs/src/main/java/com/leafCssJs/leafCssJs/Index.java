package com.leafCssJs.leafCssJs;

import org.springframework.web.bind.annotation.GetMapping;

public class Index {
    
    @GetMapping("/")
    public String getIndex() {
        return "index";
    }
}
