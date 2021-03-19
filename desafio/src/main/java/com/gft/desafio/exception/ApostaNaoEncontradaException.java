package com.gft.desafio.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND)  //404
public class ApostaNaoEncontradaException extends RuntimeException {

	private static final long serialVersionUID = 5434807991087135658L;
    
	public ApostaNaoEncontradaException() {
        super();
    }
	
	public ApostaNaoEncontradaException(String message) {
        super(message);
    }
    
    public ApostaNaoEncontradaException(String message, Throwable cause) {
        super(message, cause);
    }
}
