package com.assignment.restaurant.app.exception;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@ExtendWith(MockitoExtension.class)
public class CustomExceptionHandlerTest {

    @Autowired
    private CustomExceptionHandler customExceptionHandler;


    @BeforeEach
    public void setuup(){
        customExceptionHandler = new CustomExceptionHandler();
    }

    @Mock
    private NotFoundException notFoundException;


    @Test
    public void test_NotFoundException(){
        List<Error> errors = new ArrayList<>();
        Error error= new Error("code" , "message", UUID.randomUUID().toString());
        errors.add(error);
        ResponseEntity<Error> entity = customExceptionHandler.handleNotFoundException(notFoundException);
        Assertions.assertEquals(HttpStatus.NOT_FOUND.value(),404);
    }

}
