package org.example.controllers;

import org.example.model.Employee;
import org.example.model.Position;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

@ControllerAdvice
public class MyControllerAdvice {
    @ModelAttribute("positions")
    public Position[] positionsModel() {
        return Position.values();
    }

    @ModelAttribute("employee")
    public Employee userModel() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return (Employee) authentication.getPrincipal();
    }
}
