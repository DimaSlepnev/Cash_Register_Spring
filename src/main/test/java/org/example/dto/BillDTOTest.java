package org.example.dto;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
class BillDTOTest {

    @Test
    public void BillDTOTest(){
        BillDTO billDTO = new BillDTO("body",10,20);
        assertEquals(billDTO.getBody(),"body");

        assertEquals(billDTO.getAmount(),10);

        assertEquals(billDTO.getPrice(),20);
    }

}