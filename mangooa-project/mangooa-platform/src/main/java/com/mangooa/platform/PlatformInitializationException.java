package com.mangooa.platform;

/**
 * 平台初始化异常类。
 *
 * @author Weimin Gao
 * @since 1.0.0
 **/
public class PlatformInitializationException extends RuntimeException {

	private static final long serialVersionUID = 6701763678164120580L;

	public PlatformInitializationException(String message) {
		super(message);
	}
}
