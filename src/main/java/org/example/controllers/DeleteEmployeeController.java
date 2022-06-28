package org.example.controllers;

import org.example.model.Employee;
import org.example.secvices.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DeleteEmployeeController {


    @Autowired
    EmployeeService employeeService;

    @GetMapping("/deleteEmployee")
    public String goToDeleteEmployeePage(Model model, @RequestParam("employeeIdDelete") int id,
                                         @RequestParam("pageNumber") int pageNumber,
                                         @RequestParam("sortField") String sortField,
                                         @RequestParam("sortDirection") String sortDirection) {
        Employee employee = employeeService.findEmployeeById(id);
        model.addAttribute("employee", employee);
        model.addAttribute("pageNumber", pageNumber);
        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDirection", sortDirection);
        return "deleteEmployee";
    }

    @PostMapping("/deleteEmployee")
    public String deleteEmployee(Model model, @RequestParam("id") int id,
                                 @RequestParam("pageNumber") int pageNumber,
                                 @RequestParam("sortField") String sortField,
                                 @RequestParam("sortDirection") String sortDirection) {
        employeeService.deleteEmployeeById(id);
        return "redirect:/showAllEmployees?pageNumber=" + pageNumber + "&sortField=" + sortField + "&sortDirection=" + sortDirection;
    }
}
