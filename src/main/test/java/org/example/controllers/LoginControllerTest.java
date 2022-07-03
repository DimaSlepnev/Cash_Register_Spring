package org.example.controllers;

import org.example.secvices.EmployeeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class LoginControllerTest {

    @Autowired
    LoginController loginController;


    @Test
    void goToMain() {
        String template = loginController.goToMain();
        assertEquals("main", template);
    }
}