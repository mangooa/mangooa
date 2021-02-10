package com.mangooa.tools.core.io.file;

import com.mangooa.tools.core.io.IoException;

import java.io.IOException;

/**
 * @author Weimin Gao
 * @since 1.0.0
 **/
public class IoFileNotFoundException extends IoException {

	private static final long serialVersionUID = -3519835206748476926L;

	public IoFileNotFoundException(IOException cause) {
		super(cause);
	}
}
