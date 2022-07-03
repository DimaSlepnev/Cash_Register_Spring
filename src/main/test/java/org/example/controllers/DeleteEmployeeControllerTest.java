package org.example.controllers;

import org.example.model.Employee;
import org.example.secvices.EmployeeService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.ui.Model;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
class DeleteEmployeeControllerTest {

    @Spy
    @InjectMocks
    DeleteEmployeeController deleteEmployeeController;

    @Mock
    EmployeeService employeeService;

    @Test
    void goToDeleteEmployeePage() {
        Employee employee = mock(Employee.class);
        doReturn(employee).when(employeeService).findEmployeeById(0);
        Model model = mock(Model.class);
        String template = deleteEmployeeController.goToDeleteEmployeePage(model,0,1,"name","ASC");
        verify(model,times(4)).addAttribute(any(),any());
        assertEquals("deleteEmployee", template);
    }

    @Test
    void deleteEmployee() {
        doNothing().when(employeeService).deleteEmployeeById(0);
        Model model = mock(Model.class);
        String template = deleteEmployeeController.deleteEmployee(model,0,1,"name","ASC");
        verify(employeeService,times(1)).deleteEmployeeById(0);
        assertNotNull(template);
    }
}