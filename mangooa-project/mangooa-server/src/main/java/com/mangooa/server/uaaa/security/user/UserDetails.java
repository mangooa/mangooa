package com.mangooa.server.uaaa.security.user;

import com.mangooa.common.security.core.GrantedAuthority;

import lombok.Getter;
import lombok.Setter;

import java.util.Collection;

/**
 * 用户详情。
 *
 * @author Weimin Gao
 * @since 1.0.0
 **/
@Getter
@Setter
public class UserDetails implements com.mangooa.common.security.user.UserDetails {

	private static final long serialVersionUID = 1013633215253971689L;

	private String tenant;

	private String account;

	private String username;

	private String password;

	private String name;

	private Collection<? extends GrantedAuthority> authorities;

	private boolean accountNonExpired;

	private boolean accountNonLocked;

	private boolean enabled;

	private boolean credentialsNonExpired;
}
