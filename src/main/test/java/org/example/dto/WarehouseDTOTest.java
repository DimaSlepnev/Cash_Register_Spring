package org.example.dto;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class WarehouseDTOTest {

    @Test
    public void WarehouseDTOTest(){
        WarehouseDTO warehouseDTO = new WarehouseDTO("product",10);

        assertEquals(warehouseDTO.getProduct(),"product");

        assertEquals(warehouseDTO.getAmount(),10);
    }

}