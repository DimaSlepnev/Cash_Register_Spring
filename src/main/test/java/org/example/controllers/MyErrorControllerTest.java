package org.example.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class MyErrorControllerTest {

    @Test
    void handleError() {
        MyErrorController myErrorController = new MyErrorController();
        HttpServletRequest request = mock(HttpServletRequest.class);
        request.setAttribute(RequestDispatcher.ERROR_STATUS_CODE, HttpStatus.INTERNAL_SERVER_ERROR.value());
        myErrorController = spy(MyErrorController.class);
        String template = myErrorController.handleError(request);
        verify(myErrorController, times(1)).handleError(request);
        assertEquals("error/500", template);
    }
}