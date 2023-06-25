package com.assignment.restaurant.app.exception;

import org.junit.jupiter.api.Test;
import org.meanbean.test.BeanTester;

public class ErrorTest {

    @Test
    public void testErrorModels(){
        BeanTester beanTester = new BeanTester();
        beanTester.testBean(Error.class);
    }
}
