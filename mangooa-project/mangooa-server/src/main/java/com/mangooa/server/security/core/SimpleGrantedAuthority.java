package com.mangooa.server.security.core;

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
	 * 权限名称。
	 */
	private String authority;

	/**
	 * 权限备注。
	 */
	private String remark;
}
