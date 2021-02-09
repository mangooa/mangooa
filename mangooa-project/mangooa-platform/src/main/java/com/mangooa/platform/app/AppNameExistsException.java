package com.mangooa.platform.app;

import com.mangooa.common.service.ServiceException;

/**
 * 应用名称已存在异常。
 *
 * @author Weimin Gao
 * @since 1.0.0
 **/
public class AppNameExistsException extends ServiceException {

	private static final long serialVersionUID = 3406520804990458586L;

	/**
	 * 构造函数。
	 *
	 * @param name 应用名称。
	 */
	AppNameExistsException(String name) {
		super(name);
	}
}
