package com.mangooa.platform.user;

import com.mangooa.common.platform.security.core.userdetails.UserDetailsService;
import com.mangooa.common.platform.security.crypto.password.PasswordEncoder;
import com.mangooa.data.jpa.JpaServiceStringId;

/**
 * @author Weimin Gao
 * @since 1.0.0
 **/
@SuppressWarnings("unused")
public interface UserService extends JpaServiceStringId<UserRepository, UserEntity>, com.mangooa.common.service.UserService<UserEntity>, UserDetailsService {


	/**
	 * 返回用户密码编码器。
	 *
	 * @return 密码编码器。
	 */
	PasswordEncoder getPasswordEncoder();

	/**
	 * 初始化系统管理员。
	 */
	void init();

	/**
	 * 用户注册。
	 *
	 * @param email    电子邮箱。
	 * @param password 密码。
	 * @return 用户实体对象。
	 */
	UserEntity registration(String email, String password);
}
