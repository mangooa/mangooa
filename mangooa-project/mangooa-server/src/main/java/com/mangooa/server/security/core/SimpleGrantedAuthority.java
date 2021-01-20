package com.mangooa.server.security.core;

import com.mangooa.common.domain.Permission;

import lombok.Getter;
import lombok.Setter;

/**
 * 权限接口实现类。
 *
 * @author Weimin Gao
 * @since 1.0.0
 **/
@Getter
@Setter
public class SimpleGrantedAuthority implements Permission, org.springframework.security.core.GrantedAuthority {

	private static final long serialVersionUID = -4400096800224312184L;

	/**
	 * 权限名称。
	 */
	private String name;

	@Override
	public String getAuthority() {
		return name;
	}
}
