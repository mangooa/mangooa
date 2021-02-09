package com.mangooa.platform.manage.profile;

import com.mangooa.common.service.ServiceException;

/**
 * 平台配置文件不存在异常。
 *
 * @author Weimin Gao
 * @since 1.0.0
 **/
public class PlatformProfileNotExistException extends ServiceException {

	private static final long serialVersionUID = 864480314569877114L;

	PlatformProfileNotExistException() {
		super();
	}
}
