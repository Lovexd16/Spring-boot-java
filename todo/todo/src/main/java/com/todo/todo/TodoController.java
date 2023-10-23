package com.todo.todo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TodoController {
    
    private static final List<Todo> todoItems = new ArrayList<>();
    /* static {
        todoItems.add(new Todo("Skriv ut listan", 1));
        todoItems.add(new Todo("Lägga till nytt", 2));
        todoItems.add(new Todo("Ta bort från listan", 3));
        todoItems.add(new Todo("Färdig och gå hem", 4));
    } */


    @GetMapping("/todo")
    String getTodo(Model model) {
        model.addAttribute("todoItems", todoItems);
        model.addAttribute("newTodo", new Todo(null, 0));
        return "todo";
    }

    @PostMapping("/new-item")
    String newItem(@RequestParam("name") String name) {
        System.out.println("PostMapping " + name);
        todoItems.add(new Todo(name, todoItems.size() + 1));
        return "redirect:/todo";
    }

    @GetMapping("/remove-item/{itemId}")
    String removeItem(@PathVariable int itemId) {
        System.out.println("RemoveItem " + itemId);
        todoItems.removeIf(item -> item.getId() == itemId);
        return "redirect:/todo";
    }

}
