package com.mangooa.server.uaaa.user;

import com.mangooa.common.security.user.UserDetails;
import com.mangooa.data.jpa.JpaServiceStringId;
import com.mangooa.server.ServerAppProperties;
import org.springframework.boot.ApplicationArguments;

/**
 * @author Weimin Gao
 * @since 1.0.0
 **/
@SuppressWarnings("unused")
public interface UserService extends JpaServiceStringId<UserRepository, UserEntity>, com.mangooa.uaaa.service.UserService {

	/**
	 * 初始化管理员。
	 *
	 * @param properties 服务器应用配置属性。
	 */
	void init(ServerAppProperties properties);

	/**
	 * 用户注册。
	 *
	 * @param email    电子邮箱。
	 * @param password 密码。
	 * @return 用户实体对象。
	 */
	UserEntity registration(String email, String password);

	/**
	 * 根据给定的用户登录账号查找对应的用户，返回一个用户详情对象。
	 *
	 * @param username 给定的用户登录账号。
	 * @return 用户详情对象，如果找不到返回{@code null}。
	 */
	UserDetails findUserByUsername(String username);
}
