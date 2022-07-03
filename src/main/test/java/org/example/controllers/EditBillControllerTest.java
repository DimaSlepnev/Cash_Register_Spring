package org.example.controllers;

import org.example.model.Bill;
import org.example.secvices.BillService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.ui.Model;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
class EditBillControllerTest {

    @Spy
    @InjectMocks
    EditBillController editBillController;

    @Mock
    BillService billService;

    @Test
    void goToEditBillPage() {
        Bill bill = mock(Bill.class);
        when(billService.findBillById(0)).thenReturn(bill);
        Model model = mock(Model.class);
        String template = editBillController.goToEditBillPage(model,0,1,"name","ASC");
        verify(model,times(4)).addAttribute(any(),any());
        assertEquals("editBill",template);
    }


}