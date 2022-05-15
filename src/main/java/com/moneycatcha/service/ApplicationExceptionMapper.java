package com.moneycatcha.service;


import java.io.PrintWriter;
import java.io.Serializable;
import java.io.StringWriter;
import java.sql.Timestamp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.moneycatcha.exception.IncorrectMatchCharacterException;


@ControllerAdvice
public class ApplicationExceptionMapper {

	private static final Logger LOGGER = LoggerFactory.getLogger(ApplicationExceptionMapper.class);

	@ExceptionHandler(value = { IncorrectMatchCharacterException.class })
	protected ResponseEntity<GeneralError> handleIncorrectMatchCharacterException(Exception ex, WebRequest request) {
		logExceptionStackTrace(ex);
		return new ResponseEntity<GeneralError>(new GeneralError(ex.getMessage()),
				HttpStatus.BAD_REQUEST);
	}
	
	
	
	@ExceptionHandler(value = { Throwable.class })
	protected ResponseEntity<GeneralError> handleConflict(Exception ex, WebRequest request) {
		logExceptionStackTrace(ex);
		return new ResponseEntity<GeneralError>(new GeneralError(ex.getMessage()),
				HttpStatus.INTERNAL_SERVER_ERROR);
	}

	private void logExceptionStackTrace(Exception ex) {
		StringWriter errors = new StringWriter();
		ex.printStackTrace(new PrintWriter(errors));
		LOGGER.error("stacktrace={}", errors.toString());
	}

	private static class GeneralError implements Serializable {

		private static final long serialVersionUID = 1L;

		private Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		private String debugMessage;

		public GeneralError(String debugMessage) {
			this.debugMessage = debugMessage;
		}

		public Timestamp getTimestamp() {
			return timestamp;
		}

		public String getDebugMessage() {
			return debugMessage;
		}

	}


}