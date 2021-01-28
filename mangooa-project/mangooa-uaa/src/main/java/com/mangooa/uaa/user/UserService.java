package com.mangooa.uaa.user;

import com.mangooa.common.spring.security.core.userdetails.UserDetailsService;
import com.mangooa.data.jpa.JpaServiceStringId;

/**
 * @author Weimin Gao
 * @since 1.0.0
 **/
@SuppressWarnings("unused")
public interface UserService extends JpaServiceStringId<UserRepository, User>, com.mangooa.common.service.UserService<User>, UserDetailsService {

//	/**
//	 * 初始化管理员。
//	 *
//	 * @param properties 服务器应用配置属性。
//	 */
//	void init(ServerAppProperties properties);

	/**
	 * 用户注册。
	 *
	 * @param email    电子邮箱。
	 * @param password 密码。
	 * @return 用户实体对象。
	 */
	User registration(String email, String password);
}
