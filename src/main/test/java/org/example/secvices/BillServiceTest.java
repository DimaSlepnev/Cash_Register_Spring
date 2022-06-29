package org.example.secvices;

import org.example.model.Bill;
import org.example.repository.BillRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class BillServiceTest {

    @Autowired
    BillService billService;

    @MockBean
    BillRepository billRepository;

    @Test
    void findAll() {
       List<Bill> bills = new ArrayList();
       doReturn(bills).when(billRepository).findAll();
       List<Bill> billList = billService.findAll();
       verify(billRepository,times(1)).findAll();
    }

    @Test
    void findBillById() {
        Bill bill = new Bill();
        doReturn(bill).when(billRepository).findBillById(0);
        Bill bill1 = billRepository.findBillById(0);
        verify(billRepository,times(1)).findBillById(0);
    }

    @Test
    void deleteBillById() {
        doNothing().when(billRepository).deleteBillByBillId(0);
        billRepository.deleteBillByBillId(0);
        verify(billRepository,times(1)).deleteBillByBillId(0);
    }

    @Test
    void save() {
        Bill bill = new Bill();
        billRepository.save(bill);
        verify(billRepository,times(1)).save(bill);
    }
}