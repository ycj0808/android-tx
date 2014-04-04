package com.android.chat.exception;

public class ChatException extends Exception {
	private static final long serialVersionUID = 1L;

	public ChatException(String message) {
		super(message);
	}

	public ChatException(String message, Throwable cause) {
		super(message, cause);
	}
}
