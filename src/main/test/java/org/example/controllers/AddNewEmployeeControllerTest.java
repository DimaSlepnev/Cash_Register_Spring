package org.example.controllers;

import org.example.dto.EmployeeDTO;
import org.example.model.Position;
import org.example.repository.EmployeeRepository;
import org.example.secvices.LoginService;
import org.junit.Before;
import org.junit.Test;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.ui.Model;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

@SpringBootTest
public class AddNewEmployeeControllerTest {

    @MockBean
    LoginService loginService;


    AddNewEmployeeController newEmployeeController;

    @Before
    public void before() {
        newEmployeeController = new AddNewEmployeeController();
        newEmployeeController = spy(AddNewEmployeeController.class);
    }

    @Test
    public void registration() {
        String template = newEmployeeController.registration();
        verify(newEmployeeController, times(1)).registration();
        assertEquals(template, "registration");
    }

    @Test
    public void addEmployee() {
        EmployeeDTO employeeDTO = new EmployeeDTO("Name", "Surname", "login", "pass");
        Position position = Position.cashier;
        Model model = mock(Model.class);
        loginService = mock(LoginService.class);
        doReturn(true).when(loginService).registration(employeeDTO, position);
    }
}