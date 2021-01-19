package com.mangooa.common.security.core;

/**
 * 权限接口。
 *
 * @author Weimin Gao
 * @since 1.0.0
 **/
public interface GrantedAuthority extends org.springframework.security.core.GrantedAuthority {

	/**
	 * 获取权限备注。
	 *
	 * @return 权限备注。
	 */
	String getRemark();

}
