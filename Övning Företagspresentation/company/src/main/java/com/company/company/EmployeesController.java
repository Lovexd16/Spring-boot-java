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
public class EmployeesController {

    private static final List<Employees> employeeItems = new ArrayList<>();
    static {
        employeeItems.add(new Employees("Love", 1));
        employeeItems.add(new Employees("Lasse", 2));
    }
    
    @GetMapping("/employees")
    String getEmployees(Model employeeModel) {
        employeeModel.addAttribute("employeeItems", employeeItems);
        employeeModel.addAttribute("newEmployee", new Employees(null, 0));
        return "employees";
    }

    @PostMapping("/new-employee")
    String newEmployee(@RequestParam("employeeName") String employeeName) {
        System.out.println("post mapping funkar" + employeeName);
        employeeItems.add(new Employees(employeeName, employeeItems.size() + 1));
        return "redirect:/employees";
    }

    @GetMapping("/remove-employeeItem/{employeeItemId}")
    String removeProductItem(@PathVariable int employeeItemId) {
        System.out.println("Du tog bort anställd med id: " + employeeItemId);
        employeeItems.removeIf(employeeItem -> employeeItem.getEmployeeId() == employeeItemId);
        return "redirect:/employees";
    }
}
