package org.example.secvices;

import org.example.model.Warehouse;
import org.example.repository.WarehouseRepository;
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
class WarehouseServiceTest {

    @Autowired
    WarehouseService warehouseService;

    @MockBean
    WarehouseRepository warehouseRepository;

    @Test
    void findByProduct() {
        String product = "product";
        Warehouse warehouse = new Warehouse();
        warehouse.setProduct(product);
        doReturn(warehouse).when(warehouseRepository).findWarehouseByProduct(product);
        Warehouse warehouse1 = warehouseService.findByProduct(product);
        verify(warehouseRepository,times(1)).findWarehouseByProduct(product);

    }

    @Test
    void productExistByName() {
        String product = "product";
        doReturn(false).when(warehouseRepository).existsWarehouseByProduct(product);
        assertFalse(warehouseService.productExistByName(product));
        verify(warehouseRepository,times(1)).existsWarehouseByProduct(product);
    }

    @Test
    void save() {
        Warehouse warehouse = new Warehouse();
        warehouseRepository.save(warehouse);
        verify(warehouseRepository,times(1)).save(warehouse);
    }

    @Test
    void findAll() {
        List<Warehouse> warehouse = new ArrayList();
        doReturn(warehouse).when(warehouseRepository).findAll();
        Iterable<Warehouse> warehouseList = warehouseRepository.findAll();
        verify(warehouseRepository,times(1)).findAll();

    }

    @Test
    void findProductById() {
        Warehouse warehouse= new Warehouse();
        doReturn(warehouse).when(warehouseRepository).findWarehouseByProductId(0);
        Warehouse warehouse1 = warehouseService.findProductById(0);
        verify(warehouseRepository,times(1)).findWarehouseByProductId(0);
    }

    @Test
    void deleteById() {
        doNothing().when(warehouseRepository).deleteById((long) 0);
        warehouseRepository.deleteById((long)0);
        verify(warehouseRepository,times(1)).deleteById((long) 0);

    }
}