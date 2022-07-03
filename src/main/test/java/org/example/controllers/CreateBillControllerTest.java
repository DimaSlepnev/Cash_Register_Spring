package org.example.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;

class CreateBillControllerTest {


    @Test
    void goToCreateBillView() {
        CreateBillController createBillController = new CreateBillController();
        String template = createBillController.goToCreateBillView();
        assertEquals("createBill", template);
    }
}