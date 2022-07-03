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
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.ui.Model;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
class ShowAllBillsControllerTest {

    @Spy
    @InjectMocks
    ShowAllBillsController showAllBillsController;

    @Mock
    BillService billService;

    @Test
    void showAllBills() {
        Page<Bill> bills = mock(Page.class);
        doReturn(bills).when(billService).findAll(1, "name", "ASC");
        Model model = mock(Model.class);
        String template = showAllBillsController.showAllBills(model, 1, "name", "ASC");
        verify(model, times(6)).addAttribute(any(), any());
        assertEquals("showAllBills", template);
    }
}