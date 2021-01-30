package com.mangooa.common.data;

import java.io.Serializable;

/**
 * 操作权限接口。
 *
 * @author Weimin Gao
 * @since 1.0.0
 **/
public interface OperationAuthority extends Serializable {

	/**
	 * 返回操作权限代码，例如：SAVE。
	 *
	 * @return 操作权限代码。
	 */
	String getCode();

	/**
	 * 返回操作权限名称，例如：保存。
	 *
	 * @return 操作权限名称
	 */
	String getName();
}
