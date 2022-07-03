package org.example.controllers;

import org.example.dto.WarehouseDTO;
import org.example.model.Warehouse;
import org.example.secvices.WarehouseService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.ui.Model;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
class CreateProductControllerTest {

    @Autowired
    CreateProductController createProductController;
    @MockBean
    WarehouseService warehouseService;

    @Test
    void createProduct() {
        CreateProductController createProductController = new CreateProductController();
        String template = createProductController.createProduct();
        assertEquals("createProduct", template);
    }

    @Test
    void addProduct() {
        WarehouseDTO warehouseDTO = new WarehouseDTO("product",10);
        Model model = mock(Model.class);
        Warehouse warehouse = mock(Warehouse.class);
        warehouseService = mock(WarehouseService.class);
        doReturn(warehouse).when(warehouseService).findByProduct("product");
        createProductController = mock(CreateProductController.class);
        createProductController.addProduct(model,warehouseDTO);
        verify(createProductController,times(1)).addProduct(model,warehouseDTO);
    }
}