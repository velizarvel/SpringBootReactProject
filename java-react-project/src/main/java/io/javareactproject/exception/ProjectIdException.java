package io.javareactproject.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus (HttpStatus.BAD_REQUEST)
public class ProjectIdException extends RuntimeException {

	private static final long serialVersionUID = 2434386943346850795L;

	public ProjectIdException (String message) {
		super(message);
	}

}
