package com.mangooa.server.uaaa.security.domain;

import com.mangooa.common.security.core.GrantedAuthority;

import lombok.Getter;
import lombok.Setter;

import java.util.Collection;

/**
 * 用户详情接口实现类。
 *
 * @author Weimin Gao
 * @since 1.0.0
 **/
@Getter
@Setter
public class UserDetails implements com.mangooa.common.security.domain.UserDetails {

	private static final long serialVersionUID = 1013633215253971689L;

	/**
	 * 表示用户登录租户的名称。
	 */
	private String tenant;

	/**
	 * 表示用户的账号，创建后不可以修改。
	 */
	private String account;

	/**
	 * 表示用户的帐户是否已过期，无法验证已过期的帐户。
	 */
	private boolean accountNonExpired;

	/**
	 * 表示用户账号是锁定还是未锁定，锁定的账号无法通过身份验证。
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
	 * 表示用户的状态是否是启用或禁用，禁用的用户无法通过身份验证。
	 */
	private boolean enabled;

	/**
	 * 表示用户的凭据（密码）是否已过期，过期的凭据会阻止身份验证。
	 */
	private boolean credentialsNonExpired;

	/**
	 * 用户的权限。
	 */
	private Collection<? extends GrantedAuthority> authorities;
}
