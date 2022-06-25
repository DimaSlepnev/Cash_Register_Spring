package org.example.controllers;


import org.example.model.Bill;
import org.example.secvices.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/createReport")
public class CreateReportController {

    @Autowired
    BillService billService;

    @GetMapping("")
    public String goToCreateReportPage() {
        return "createReport";
    }

    @PostMapping("/xReport")
    public String xReport(Model model) {
        int xReport = 0;
        List<Bill> bills = billService.findAll();
        for (Bill bill: bills) {
            if(bill.isConfirmation()){
                xReport+=bill.getPrice();
            }
        }
        model.addAttribute("xReport",xReport);
        return "xReportPopUp";
    }

    @PostMapping("/zReport")
    public String zReport(Model model){
        int zReport = 0;
        List<Bill> bills = billService.findAll();
        for (Bill bill: bills) {
            if(bill.isConfirmation()){
                zReport+=bill.getPrice();
                billService.deleteBillById(bill.getBillId());
            }
        }
        model.addAttribute("zReport",zReport);
        return "zReportPopUp";
    }
}
