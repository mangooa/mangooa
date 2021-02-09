package com.mangooa.common.service;

/**
 * @author Weimin Gao
 * @since 1.0.0
 **/
public class ServiceException extends RuntimeException {

	private static final long serialVersionUID = -7064297494000023380L;

	public ServiceException() {
		super();
	}

	public ServiceException(String message) {
		super(message);
	}
}
