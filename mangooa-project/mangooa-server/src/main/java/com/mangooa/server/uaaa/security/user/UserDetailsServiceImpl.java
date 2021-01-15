package com.mangooa.server.uaaa.security.user;

import com.mangooa.common.security.user.UserDetails;
import com.mangooa.server.uaaa.user.UserService;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * 用户详情服务。
 *
 * @author Weimin Gao
 * @since 1.0.0
 **/
@Service
@SuppressWarnings("unused")
public class UserDetailsServiceImpl implements org.springframework.security.core.userdetails.UserDetailsService {

	/**
	 * 用户服务。
	 */
	private final UserService userService;

	/**
	 * 构造函数。
	 *
	 * @param userService 用户服务。
	 */
	public UserDetailsServiceImpl(UserService userService) {
		this.userService = userService;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserDetails user = userService.findUserByUsername(username);
		if (null == user) {
			throw new UsernameNotFoundException(username);
		}
		return user;
	}
}
