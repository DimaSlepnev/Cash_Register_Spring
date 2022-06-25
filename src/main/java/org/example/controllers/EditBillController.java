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

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller

public class EditBillController {

    @Autowired
    BillService billService;

    @Autowired
    WarehouseService warehouseService;

    @GetMapping("/editBill")
    public String goToEditBillPage(Model model, @RequestParam("idEdit") int id) {
        Bill bill = billService.findBillById(id);
        model.addAttribute("bill", bill);
        return "editBill";
    }

    @PostMapping("/editBill")
    public String editBill(Model model,
                           @RequestParam("id") int id,
                           @RequestParam("amountWas") int amountWas,
                           @RequestParam("amount") int amount,
                           @RequestParam("price") int price,
                           HttpServletRequest req) {
        Bill bill = billService.findBillById(id);
        Warehouse warehouse = warehouseService.findByProduct(bill.getBody());
        int tempAmount = amount;
        if (amount > amountWas) {
            tempAmount = amount - amountWas;
            if (tempAmount <= warehouse.getAmount()) {
                warehouse.setAmount(warehouse.getAmount() - tempAmount);
                warehouseService.save(warehouse);
                bill.setAmount(amount);
                bill.setPrice(price);
                billService.save(bill);
            }else{
                req.setAttribute("createBillError", 0);
                model.addAttribute("bill", bill);
                return "editBill";
            }
        } else {
            tempAmount = amountWas - amount;
            warehouse.setAmount(warehouse.getAmount() + tempAmount);
            warehouseService.save(warehouse);
            bill.setAmount(amount);
            bill.setPrice(price);
            billService.save(bill);
        }
        return "redirect:/showAllBills/1?sortField=billId&sortDirection=ASC";
    }
}
