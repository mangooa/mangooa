package com.mangooa.server.uaaa.security.core;

import com.mangooa.common.security.core.GrantedAuthority;
import lombok.Getter;

/**
 * 权限接口实现类。
 *
 * @author Weimin Gao
 * @since 1.0.0
 **/
@Getter
public class SimpleGrantedAuthority implements GrantedAuthority {

	private static final long serialVersionUID = -4400096800224312184L;

	/**
	 * 权限代码。
	 */
	private String authority;

	/**
	 * 权限描述。
	 */
	private String description;
}
