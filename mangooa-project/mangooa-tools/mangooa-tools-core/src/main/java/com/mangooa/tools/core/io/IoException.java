package com.mangooa.tools.core.io;

import java.io.IOException;

/**
 * IO运行时异常。
 *
 * @author Weimin Gao
 * @since 1.0.0
 **/
public class IoException extends RuntimeException {

	private static final long serialVersionUID = -889093481829154538L;

	public IoException(IOException cause) {
		super(cause);
	}
}
