package com.codetest.exception;

@SuppressWarnings("serial")
public class ProtocolException extends Exception {
	public ProtocolException(String errorMessage) {
		super(errorMessage);
	}
}
