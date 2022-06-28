package org.example.controllers;

import org.example.dto.EmployeeDTO;
import org.example.model.Position;
import org.example.secvices.LoginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
public class AddNewEmployeeController {

    @Autowired
    private LoginService loginService;

    private static Logger logger = LoggerFactory.getLogger(AddNewEmployeeController.class);

    @GetMapping("/registration")
    public String registration(){
        logger.info("Go to add new employee page");
        return "registration";
    }

    @PostMapping("/registration")
    public String addEmployee(@Valid EmployeeDTO employeeDTO, @RequestParam("position") Position position, Model model){
        if(!loginService.registration(employeeDTO, position)){
            model.addAttribute("message", "Employee already exists!");
        }
        return "registration";
    }
}
