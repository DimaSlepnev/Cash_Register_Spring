package org.example.controllers;

import org.example.model.Bill;
import org.example.model.Warehouse;
import org.example.secvices.BillService;
import org.example.secvices.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DeleteBillController {

    @Autowired
    BillService billService;

    @Autowired
    WarehouseService warehouseService;

    @GetMapping("/deleteBill")
    public String goToDeleteBillPage(Model model, @RequestParam("idDelete") int id,
                                     @RequestParam("pageNumber") int pageNumber,
                                     @RequestParam("sortField") String sortField,
                                     @RequestParam("sortDirection") String sortDirection) {
        Bill bill = billService.findBillById(id);
        model.addAttribute("bill", bill);
        model.addAttribute("pageNumber", pageNumber);
        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDirection", sortDirection);
        return "deleteBill";
    }

    @PostMapping("/deleteBill")
    public String deleteBill(Model model,
                             @RequestParam("id") int id,
                             @RequestParam("amount") int amount,
                             @RequestParam("pageNumber") int pageNumber,
                             @RequestParam("sortField") String sortField,
                             @RequestParam("sortDirection") String sortDirection) {
        Bill bill = billService.findBillById(id);
        Warehouse warehouse = warehouseService.findByProduct(bill.getBody());
        warehouse.setAmount(warehouse.getAmount() + bill.getAmount());
        warehouseService.save(warehouse);
        billService.deleteBillById(id);
        return "redirect:/showAllBills?pageNumber=" + pageNumber + "&sortField=" + sortField + "&sortDirection=" + sortDirection;
    }
}
