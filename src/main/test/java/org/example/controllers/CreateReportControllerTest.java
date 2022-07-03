package org.example.controllers;

import org.example.model.Bill;
import org.example.secvices.BillService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.ui.Model;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CreateReportControllerTest {
    @Spy
    @InjectMocks
    CreateReportController createReportController;

    @Mock
    BillService billService;

    @Test
    void goToCreateReportPage() {
        CreateReportController createReportController = new CreateReportController();
        String template = createReportController.goToCreateReportPage();
        assertEquals("createReport", template);
    }
}