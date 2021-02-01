package com.mangooa.security.core.userdetails;

import lombok.Getter;
import lombok.Setter;

import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

/**
 * @author Weimin Gao
 * @since 1.0.0
 **/
@Getter
@Setter
public class UserDetails implements com.mangooa.common.spring.security.core.userdetails.UserDetails {

	private static final long serialVersionUID = -7202223911909422962L;

	/**
	 * 用户登录租户的名称。
	 */
	private String tenant;

	/**
	 * 用户的账号。
	 */
	private String account;

	/**
	 * 用户帐户是否没有过期，真（true)表示没有过期。
	 */
	private boolean accountNonExpired;

	/**
	 * 用户账号是否没有锁定，真（true)表示没有锁定。
	 */
	private boolean accountNonLocked;

	/**
	 * 用户登录名。
	 */
	private String username;

	/**
	 * 用户登录密码。
	 */
	private String password;

	/**
	 * 用户姓名。
	 */
	private String name;

	/**
	 * 用户昵称。
	 */
	private String nickname;

	/**
	 * 用户账号状态，真（true）表示已启用。
	 */
	private boolean enabled;

	/**
	 * 用户的凭据（密码）是否没有过期，真（true）表示没有过期。
	 */
	private boolean credentialsNonExpired;

	/**
	 * 用户的权限。
	 */
	private Collection<? extends GrantedAuthority> authorities;
}
