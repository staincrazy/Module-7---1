package org.epam.piatrenka.unit6.core;

public class CustomException extends RuntimeException {

	private static final long serialVersionUID = -7373541973487504842L;

	public CustomException(String message) {
		super(message);

	}

	public CustomException(String message, Throwable cause) {
		super(message, cause);
	}

}
