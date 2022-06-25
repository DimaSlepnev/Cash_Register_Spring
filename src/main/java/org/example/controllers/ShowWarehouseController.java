package org.example.controllers;

import org.example.model.Warehouse;
import org.example.secvices.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ShowWarehouseController {
    @Autowired
    WarehouseService warehouseService;

    @GetMapping("/showWarehouse/{pageNumber}")
    public String showWarehouse(Model model, @PathVariable("pageNumber") int currentPage,
                                @RequestParam("sortField") String sortField,
                                @RequestParam("sortDirection") String sortDirection) {
        Page<Warehouse> page = warehouseService.findAll(currentPage, sortField, sortDirection);
        int totalPages = page.getTotalPages();
        long totalWarehouse = page.getTotalElements();
        List<Warehouse> warehouseList = page.getContent();
        model.addAttribute("currentPage", currentPage);
        model.addAttribute("warehouse", warehouseList);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("totalWarehouse", totalWarehouse);
        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDirection", sortDirection);
        return "showWarehouse";
    }
}
