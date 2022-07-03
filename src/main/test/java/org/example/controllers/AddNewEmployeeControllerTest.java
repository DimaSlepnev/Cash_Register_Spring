package org.example.controllers;

import org.example.dto.EmployeeDTO;
import org.example.model.Position;
import org.example.repository.EmployeeRepository;
import org.example.secvices.LoginService;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.ui.Model;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;


@SpringBootTest
public class AddNewEmployeeControllerTest {

    @MockBean
    LoginService loginService;

    @Autowired
    AddNewEmployeeController newEmployeeController;


    @Test
    public void registration() {
        AddNewEmployeeController newEmployeeController = new AddNewEmployeeController();
        String template = newEmployeeController.registration();
        assertEquals("registration", template);
    }

    @Test
    public void addEmployee() {
        newEmployeeController = new AddNewEmployeeController();
        newEmployeeController = spy(AddNewEmployeeController.class);
        EmployeeDTO employeeDTO = new EmployeeDTO("Name", "Surname", "login", "pass");
        Position position = Position.cashier;
        Model model = mock(Model.class);
        loginService = mock(LoginService.class);
        doReturn(true).when(loginService).registration(employeeDTO, position);
        loginService.registration(employeeDTO,position);
        verify(loginService,times(1)).registration(employeeDTO,position);
    }
}