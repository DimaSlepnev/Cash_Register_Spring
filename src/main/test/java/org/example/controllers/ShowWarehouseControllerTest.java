package org.example.controllers;

import org.example.model.Warehouse;
import org.example.secvices.WarehouseService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.ui.Model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
@SpringBootTest
class ShowWarehouseControllerTest {

    @Spy
    @InjectMocks
    ShowWarehouseController showWarehouseController;

    @Mock
    WarehouseService warehouseService;

    @Test
    void showWarehouse() {
        Page<Warehouse> warehouse = mock(Page.class);
        doReturn(warehouse).when(warehouseService).findAll(1, "name", "ASC");
        Model model = mock(Model.class);
        String template = showWarehouseController.showWarehouse(model, 1, "name", "ASC");
        verify(model, times(6)).addAttribute(any(), any());
        assertEquals("showWarehouse", template);
    }
}