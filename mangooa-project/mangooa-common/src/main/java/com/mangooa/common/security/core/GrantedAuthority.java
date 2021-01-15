package com.mangooa.common.security.core;

/**
 * 权限接口。
 *
 * @author Weimin Gao
 * @since 1.0.0
 **/
public interface GrantedAuthority extends org.springframework.security.core.GrantedAuthority {

	/**
	 * 获取权限代码。
	 *
	 * @return 权限代码。
	 */
	default String getCode() {
		return getAuthority();
	}

	/**
	 * 获取权限描述。
	 *
	 * @return 权限描述。
	 */
	String getDescription();


}
