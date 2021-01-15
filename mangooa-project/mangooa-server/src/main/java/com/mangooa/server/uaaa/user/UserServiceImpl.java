package com.mangooa.server.uaaa.user;

import com.mangooa.common.security.crypto.password.PasswordEncoder;
import com.mangooa.common.service.impl.BaseJpaServiceStringId;

import org.springframework.stereotype.Service;

/**
 * 用户服务实现类。
 *
 * @author Weimin Gao
 * @since 1.0.0
 **/
@Service
public class UserServiceImpl extends BaseJpaServiceStringId<UserRepository, UserEntity> implements UserService {

	/**
	 * 密码加密器。
	 */
	private final PasswordEncoder passwordEncoder;

	/**
	 * 构造函数。
	 *
	 * @param passwordEncoder 密码加密器。
	 */
	public UserServiceImpl(PasswordEncoder passwordEncoder) {
		this.passwordEncoder = passwordEncoder;
	}

	@Override
	public PasswordEncoder getPasswordEncoder() {
		return this.passwordEncoder;
	}
}
