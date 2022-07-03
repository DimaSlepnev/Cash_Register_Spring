package org.example.model;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collections;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@SpringBootTest
public class EmployeeTest {

    @Test
    public void EmployeeTest() {
        Warehouse warehouse = mock(Warehouse.class);
        int wHash = warehouse.hashCode();
        Employee employee = spy(Employee.class);
        employee.setEmployeeId(0);
        verify(employee, times(1)).setEmployeeId(0);
        assertEquals(0, employee.getEmployeeId());
        verify(employee, times(1)).getEmployeeId();

        employee.setFirstName("name");
        verify(employee, times(1)).setFirstName("name");
        assertEquals("name", employee.getFirstName());
        verify(employee, times(1)).getFirstName();

        employee.setSecondName("surname");
        verify(employee, times(1)).setSecondName("surname");
        assertEquals("surname", employee.getSecondName());
        verify(employee, times(1)).getSecondName();

        employee.setPosition(any());
        verify(employee, times(1)).setPosition(any());

        employee.setLogin("login");
        verify(employee, times(1)).setLogin("login");
        assertEquals("login", employee.getUsername());
        verify(employee, times(1)).getUsername();

        employee.setPass("pass");
        verify(employee, times(1)).setPass("pass");
        assertEquals("pass", employee.getPassword());
        verify(employee, times(1)).getPassword();

        employee.setWarehouse(warehouse);
        verify(employee, times(1)).setWarehouse(warehouse);
        assertEquals(warehouse, employee.getWarehouse());
        verify(employee, times(1)).getWarehouse();

        assertEquals("Employee{employeeId=0, firstName='name', secondName='surname', position=null, login='login', pass='pass', warehouse=Mock for Warehouse, hashCode: " + wHash + "}", employee.toString());
    }

}