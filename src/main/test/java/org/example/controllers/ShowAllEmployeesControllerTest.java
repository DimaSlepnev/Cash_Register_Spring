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
import org.springframework.data.domain.Page;
import org.springframework.ui.Model;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
class ShowAllEmployeesControllerTest {

    @Spy
    @InjectMocks
    ShowAllEmployeesController showAllEmployeesController;

    @Mock
    EmployeeService employeeService;

    @Test
    void showAllEmployees() {
        Page<Employee> employees = mock(Page.class);
        doReturn(employees).when(employeeService).findAllEmployees(1, "name", "ASC");
        Model model = mock(Model.class);
        String template = showAllEmployeesController.showAllEmployees(model, 1, "name", "ASC");
        verify(model, times(6)).addAttribute(any(), any());
        assertEquals("showAllEmployees", template);
    }
}