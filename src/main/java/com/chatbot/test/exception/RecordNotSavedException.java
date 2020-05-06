package com.chatbot.test.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * This is the class for Record not saved Exception
 * @author SURAJ
 *
 */
@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class RecordNotSavedException extends Exception {

private static final long serialVersionUID = 1L;
	
	public RecordNotSavedException(String message) {
		super(message);
	}
}
