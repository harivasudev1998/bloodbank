package com.cognizant.onlinebloodbank.exception;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(value=HttpStatus.BAD_REQUEST,reason="Active Slot")
public class AlreadyslotException extends Exception{


	

}
