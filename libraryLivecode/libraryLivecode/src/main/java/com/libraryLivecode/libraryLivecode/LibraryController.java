package com.libraryLivecode.libraryLivecode;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LibraryController {
    
    @GetMapping("/")
    String getStart(Model model) {
        model.addAttribute("books", LibraryLivecodeApplication.library.books);
        return "start";
    }

}
