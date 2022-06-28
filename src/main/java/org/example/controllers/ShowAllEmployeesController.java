package org.example.controllers;

import org.example.model.Employee;
import org.example.secvices.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ShowAllEmployeesController {
    @Autowired
    EmployeeService employeeService;

    @GetMapping("/showAllEmployees")
    public String showAllEmployees(Model model, @RequestParam("pageNumber") int currentPage,
                                   @RequestParam("sortField") String sortField,
                                   @RequestParam("sortDirection") String sortDirection) {
        Page<Employee> page = employeeService.findAllEmployees(currentPage, sortField, sortDirection);
        int totalPages = page.getTotalPages();
        long totalEmployees = page.getTotalElements();
        List<Employee> employees = page.getContent();
        model.addAttribute("currentPage", currentPage);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("totalEmployees", totalEmployees);
        model.addAttribute("employees", employees);
        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDirection", sortDirection);
        return "showAllEmployees";
    }
}
