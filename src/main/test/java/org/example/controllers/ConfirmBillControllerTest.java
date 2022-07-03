package org.example.controllers;

import org.example.model.Bill;
import org.example.secvices.BillService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.exceptions.base.MockitoException;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.ui.Model;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
class ConfirmBillControllerTest {

    @Spy
    @InjectMocks
    private ConfirmBillController confirmBillController;

    @Mock
    private BillService billService;


    @Test
    void goToConfirmationPage() {
        Bill bill = mock(Bill.class);
        when(billService.findBillById(0)).thenReturn(bill);
        Model model = mock(Model.class);
        String template = confirmBillController.goToConfirmationPage(model,0,1,"name","ASC");
        verify(model,times(4)).addAttribute(any(),any());
        assertEquals("confirmBill", template);
    }

    @Test
    void confirmBill() {
        Bill bill = mock(Bill.class);
        doReturn(bill).when(billService).findBillById(0);
        Model model = mock(Model.class);
        String template = confirmBillController.confirmBill(model,0,"yes",1,"name","ASC");
        assertNotNull(template);
    }
}