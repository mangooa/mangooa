package com.mangooa.server.security.domain;

import com.mangooa.common.security.domain.UserDetails;
import com.mangooa.server.name.user.UserEntity;
import com.mangooa.server.name.user.UserService;

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
		UserEntity user = userService.find(username);
		if (null == user) {
			throw new UsernameNotFoundException(username);
		}
		return null;
	}
}
