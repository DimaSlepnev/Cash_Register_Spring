package org.example.controllers;

import org.example.model.Bill;
import org.example.model.Employee;
import org.example.secvices.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ShowAllBillsController {

    @Autowired
    BillService billService;

    @GetMapping("/showAllBills")
    public String showAllBills(Model model, @RequestParam("pageNumber") int currentPage,
                               @RequestParam("sortField") String sortField,
                               @RequestParam("sortDirection") String sortDirection) {
        Page<Bill> page = billService.findAll(currentPage, sortField, sortDirection);
        int totalPages = page.getTotalPages();
        long totalBills = page.getTotalElements();
        List<Bill> bills = page.getContent();
        model.addAttribute("bills", bills);
        model.addAttribute("currentPage", currentPage);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("totalBills", totalBills);
        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDirection", sortDirection);
        return "showAllBills";
    }
}
