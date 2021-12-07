package com.intellisense.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.intellisense.service.exception.TestException;

import org.springframework.http.HttpStatus;

@ControllerAdvice
public class TestExceptionHandler {


	@ResponseBody
	    @ExceptionHandler(TestException.class)
	    @ResponseStatus(HttpStatus.BAD_REQUEST)
	    public String NotFoundHandler(TestException ex) {
	        return ex.getMessage();
	    }

}
