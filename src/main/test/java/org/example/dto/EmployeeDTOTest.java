package org.example.dto;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class EmployeeDTOTest {

    @Test
    public void EmployeeDTOTest(){
        EmployeeDTO employeeDTO = new EmployeeDTO("name","surname","login","pass");

        assertEquals(employeeDTO.getFirstName(),"name");

        assertEquals(employeeDTO.getSecondName(),"surname");

        assertEquals(employeeDTO.getLogin(), "login");

        assertEquals(employeeDTO.getPass(), "pass");
    }

}