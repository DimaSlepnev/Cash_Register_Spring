package org.example.model;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@SpringBootTest
public class BillTest {

    @Test
    public void BillTest() {
        Warehouse warehouse = mock(Warehouse.class);
        int wHash = warehouse.hashCode();
        Bill bill = spy(Bill.class);
        bill.setBillId(0);
        verify(bill, times(1)).setBillId(0);
        assertEquals(0, bill.getBillId());
        verify(bill, times(1)).getBillId();

        bill.setProduct(warehouse);
        verify(bill, times(1)).setProduct(warehouse);
        assertEquals(warehouse, bill.getProduct());
        verify(bill, times(1)).getProduct();

        bill.setBody("body");
        verify(bill, times(1)).setBody("body");
        assertEquals("body", bill.getBody());
        verify(bill, times(1)).getBody();

        bill.setAmount(10);
        verify(bill, times(1)).setAmount(10);
        assertEquals(10, bill.getAmount());
        verify(bill, times(1)).getAmount();

        bill.setPrice(50);
        verify(bill, times(1)).setPrice(50);
        assertEquals(50, bill.getPrice());
        verify(bill, times(1)).getPrice();

        bill.setConfirmation(false);
        verify(bill, times(1)).setConfirmation(false);
        assertFalse(bill.isConfirmation());
        verify(bill, times(1)).isConfirmation();

        assertEquals("Bill{billId=0, product=Mock for Warehouse, hashCode: " + wHash + ", body='body', amount=10, price=50, confirmation=false}", bill.toString());
    }
}