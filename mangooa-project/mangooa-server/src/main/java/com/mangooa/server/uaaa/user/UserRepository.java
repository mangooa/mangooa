package com.mangooa.server.uaaa.user;

import com.mangooa.data.jpa.JpaRepositoryStringId;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * @author Weimin Gao
 * @since 1.0.0
 **/
@Repository
public interface UserRepository extends JpaRepositoryStringId<UserEntity> {

	/**
	 * 根据给定的关键字（ 用户的电子邮件、手机号、登录名、账号）查找对应的用户实体，如果找不到则返回{@code null}。
	 *
	 * @param email     用户的电子邮件。
	 * @param cellphone 用户的手机号。
	 * @param username  用户的登录名。
	 * @param account   用户的账号。
	 * @return 用户实体对象。
	 */
	UserEntity findByEmailIgnoreCaseOrCellphoneIgnoreCaseOrUsernameIgnoreCaseOrAccountIgnoreCase(String email, String cellphone, String username, String account);

	/**
	 * 根据给定的登录账号查找对应的用户实体，如果找不到则返回{@code null}。
	 *
	 * @param username 给定的登录账号，忽略大小写。
	 * @return 用户实体对象。
	 */
	UserEntity findByUsernameIgnoreCase(String username);

	/**
	 * 根据给定的电子邮件查找对应的用户实体，如果找不到则返回{@code null}。
	 *
	 * @param email 给定的电子邮件，忽略大小写。
	 * @return 用户实体对象。
	 */
	UserEntity findByEmailIgnoreCase(String email);

	/**
	 * 根据给定的电子邮件查找对应用户实体的数量，如果找不到则返回零。
	 *
	 * @param email 给定的电子邮件，忽略大小写。
	 * @return 用户实体的数量。
	 */
	long countByEmailIgnoreCase(String email);

}
