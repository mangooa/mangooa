package com.mangooa.server.security.core.userdetails;

import com.mangooa.server.name.user.UserEntity;
import com.mangooa.server.name.user.UserService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

/**
 * 用户详情服务。
 *
 * @author Weimin Gao
 * @since 1.0.0
 **/
@Component
@Slf4j
public class UserDetailsServiceImpl implements UserDetailsService {

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
		log.info("user account '{}' {}found.", username, (user == null ? "not " : ""));
		if (null == user) {
			throw new UsernameNotFoundException(username);
		}
		UserDetails ret = new UserDetails();
		ret.setAccount(user.getAccount());
		ret.setAccountNonExpired(true);
		ret.setAccountNonLocked(true);
		ret.setAuthorities(null);
		ret.setCredentialsNonExpired(true);
		ret.setEnabled(true);
		ret.setName(user.getName());
		ret.setNickname(user.getNickname());
		ret.setPassword(user.getPassword());
		ret.setTenant(user.getTenant());
		ret.setUsername(user.getUsername());
		return ret;
	}
}
