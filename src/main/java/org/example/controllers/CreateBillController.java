package org.example.controllers;

import org.example.dto.BillDTO;
import org.example.model.Bill;
import org.example.model.Warehouse;
import org.example.secvices.BillService;
import org.example.secvices.WarehouseService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Optional;

@Controller
public class CreateBillController {

    @Autowired
    BillService billService;

    @Autowired
    WarehouseService warehouseService;

    @Autowired
    ModelMapper modelMapper;

    @GetMapping("/createBill")
    public String goToCreateBillView() {
        return "createBill";
    }

    @PostMapping("/createBill")
    public void createBill(Model model, @Valid BillDTO billDTO, HttpServletRequest req) {
        Bill bill = modelMapper.map(billDTO, Bill.class);
        try {
            Integer productId = Integer.parseInt(bill.getBody());
            Warehouse warehouse = warehouseService.findProductById(productId);
            if (warehouse != null && bill.getAmount() <= warehouse.getAmount()) {
                bill.setBody(warehouse.getProduct());
                bill.setProduct(warehouse);
                bill.setConfirmation(false);
                warehouse.setAmount(warehouse.getAmount() - bill.getAmount());
                warehouseService.save(warehouse);
                billService.save(bill);
            } else {
                req.setAttribute("createBillError", 0);
            }
        } catch (Exception e) {
            Warehouse warehouse = warehouseService.findByProduct(bill.getBody());
            if (warehouse != null && bill.getAmount() <= warehouse.getAmount()) {
                bill.setProduct(warehouse);
                bill.setConfirmation(false);
                warehouse.setAmount(warehouse.getAmount() - bill.getAmount());
                warehouseService.save(warehouse);
                billService.save(bill);
            } else {
                req.setAttribute("createBillError", 0);
            }
        }
    }
}
