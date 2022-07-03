package org.example.controllers;

import org.example.model.Employee;
import org.example.model.Position;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MyControllerAdviceTest {

    @Test
    void positionsModel() {
        MyControllerAdvice myControllerAdvice = new MyControllerAdvice();
        Position[] positions = myControllerAdvice.positionsModel();
        assertArrayEquals(positions, Position.values());
    }
}