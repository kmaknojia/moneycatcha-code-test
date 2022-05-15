package com.moneycatcha.exception;


public class IncorrectMatchCharacterException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private static final String message =  "Incorrect matching character (exactly one matching character required)";

    public IncorrectMatchCharacterException() {
        super(message);
    }

}