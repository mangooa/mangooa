package com.mangooa.platform.tenant;

import com.mangooa.common.service.ServiceException;

/**
 * 租户名称已存在异常。
 *
 * @author Weimin Gao
 * @since 1.0.0
 **/
public class TenantNameExistsException extends ServiceException {

	private static final long serialVersionUID = -5904068133515585776L;

	/**
	 * 构造函数。
	 *
	 * @param name 租户名称。
	 */
	TenantNameExistsException(String name) {
		super(name);
	}
}
