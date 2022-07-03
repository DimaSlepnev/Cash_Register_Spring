package org.example.controllers;

import org.example.model.Bill;
import org.example.model.Warehouse;
import org.example.secvices.BillService;
import org.example.secvices.WarehouseService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.ui.Model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
class DeleteBillControllerTest {

    @Spy
    @InjectMocks
    private DeleteBillController deleteBillController;

    @Mock
    private BillService billService;

    @Mock
    private WarehouseService warehouseService;

    @Test
    void goToDeleteBillPage() {
        Bill bill = mock(Bill.class);
        when(billService.findBillById(0)).thenReturn(bill);
        Model model = mock(Model.class);
        String template = deleteBillController.goToDeleteBillPage(model,0,1,"name","ASC");
        verify(model,times(4)).addAttribute(any(),any());
        assertEquals("deleteBill",template);
    }

    @Test
    void deleteBill() {
        Bill bill = new Bill();
        bill.setBillId(0);
        bill.setBody("body");
        when(billService.findBillById(0)).thenReturn(bill);
        doNothing().when(billService).deleteBillById(0);
        Warehouse warehouse = new Warehouse();
        doReturn(warehouse).when(warehouseService).findByProduct(any());
        doNothing().when(warehouseService).save(warehouse);
        Model model = mock(Model.class);
        String template = deleteBillController.deleteBill(model,0,5,1,"name","ASC");
        assertNotNull(template);
    }
}