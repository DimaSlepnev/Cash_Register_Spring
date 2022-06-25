package org.example.controllers;

import org.example.dto.BillDTO;
import org.example.model.Bill;
import org.example.secvices.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
public class ConfirmBillController {

    @Autowired
    BillService billService;

    @GetMapping("/confirmBill")
    public String goToConfirmationPage(Model model, @RequestParam("idConfirm") int id){
        Bill bill = billService.findBillById(id);
        model.addAttribute("bill", bill);
        return "confirmBill";
    }

    @PostMapping("/confirmBill")
    public String confirmBill(Model model, @RequestParam("id") int id, @RequestParam("confirmation") String confirmation){
        if(confirmation.equals("yes")){
            Bill bill = billService.findBillById(id);
            bill.setConfirmation(true);
            billService.save(bill);
        }
        return "redirect:/showAllBills/1?sortField=billId&sortDirection=ASC";
    }
}
