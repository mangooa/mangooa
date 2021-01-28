package com.mangooa.server.user;

import com.mangooa.data.jpa.JpaServiceStringId;
import com.mangooa.server.ServerAppProperties;

/**
 * @author Weimin Gao
 * @since 1.0.0
 **/
@SuppressWarnings("unused")
public interface UserService extends JpaServiceStringId<UserRepository, User> {

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
	User registration(String email, String password);

	/**
	 * 根据给定的关键字查找对应的用户实体，如果找不到则返回{@code null}。
	 *
	 * @param key 给定的关键字，可以为用户账号、用户登录名、用户电子邮件、用户手机号等。
	 * @return 用户实体对象。
	 */
	User find(String key);
}
