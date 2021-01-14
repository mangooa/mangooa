package com.mangooa.server.uaaa.user;

import com.mangooa.common.dao.JpaRepositoryStringId;
import org.springframework.stereotype.Repository;

/**
 * @author Weimin Gao
 * @since 1.0.0
 **/
@Repository
public interface UserRepository extends JpaRepositoryStringId<UserEntity> {

	/**
	 * 根据用户账号查找对应的用户，如果找不到返回{@code null}。
	 *
	 * @param account 用户账号。
	 * @return 用户实体对象。
	 */
	UserEntity findByAccountIgnoreCase(String account);

}
