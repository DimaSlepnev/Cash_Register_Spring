package org.example.controllers;

import org.example.model.Employee;
import org.example.repository.EmployeeRepository;
import org.example.secvices.EmployeeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.ui.Model;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
public class DeleteEmployeeControllerTest {

    @Autowired
    private DeleteEmployeeController deleteEmployeeController;

    @MockBean
    EmployeeService employeeService;

    @MockBean
    EmployeeRepository employeeRepository;

    @Test
    public void goToDeleteEmployeePage() {
       /* assertThat(deleteEmployeeController).isNotNull();*/
       /* Model model = mock(Model.class);
        Employee employee = new Employee();
        employee.setEmployeeId(1);
        *//*doReturn(employee).when(employeeRepository).findEmployeeByEmployeeId(1);*//*
        String template = deleteEmployeeController.goToDeleteEmployeePage(model, 1,1,"Id","ASC");
        assertEquals(template,"deleteEmployee");*/
    }

    @Test
    public void deleteEmployee() {
    }
}