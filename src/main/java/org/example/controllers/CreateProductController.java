package org.example.controllers;

import org.example.dto.WarehouseDTO;
import org.example.model.Bill;
import org.example.model.Employee;
import org.example.model.Warehouse;
import org.example.secvices.WarehouseService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class CreateProductController {

    @Autowired
    private WarehouseService warehouseService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("/createProduct")
    public String createProduct() {
        return "createProduct";
    }

    @PostMapping("/createProduct")
    public void addProduct(Model model, @Valid WarehouseDTO warehouseDTO) {
        Employee employee = (Employee) model.getAttribute("employee");
        if (!warehouseService.productExistByName(warehouseDTO.getProduct())) {
            Warehouse warehouse = modelMapper.map(warehouseDTO,Warehouse.class);
            warehouse.setEmployee(employee);
            warehouseService.save(warehouse);
        }
        else {
            Warehouse warehouse = warehouseService.findByProduct(warehouseDTO.getProduct());
            warehouse.setAmount(warehouse.getAmount() + warehouseDTO.getAmount());
            warehouseService.save(warehouse);
        }
    }
}
