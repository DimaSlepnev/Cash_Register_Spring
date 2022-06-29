package org.example.model;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@SpringBootTest
public class WarehouseTest {

    @Test
    public void WarehouseTest() {
        Employee employee = mock(Employee.class);
        int eHash = employee.hashCode();
        Warehouse warehouse = spy(Warehouse.class);
        warehouse.setProductId(0);
        verify(warehouse, times(1)).setProductId(0);
        assertEquals(0, warehouse.getProductId());
        verify(warehouse, times(1)).getProductId();

        warehouse.setProduct("product");
        verify(warehouse, times(1)).setProduct("product");
        assertEquals("product", warehouse.getProduct());
        verify(warehouse, times(1)).getProduct();

        warehouse.setAmount(10);
        verify(warehouse, times(1)).setAmount(10);
        assertEquals(10, warehouse.getAmount());
        verify(warehouse, times(1)).getAmount();

        warehouse.setEmployee(employee);
        verify(warehouse, times(1)).setEmployee(employee);
        assertEquals(employee, warehouse.getEmployee());
        verify(warehouse, times(1)).getEmployee();

        assertEquals("Warehouse{productId=0, product='product', amount=10, employee=Mock for Employee, hashCode: " + eHash + "}", warehouse.toString());
    }
}