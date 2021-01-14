package com.mangooa.uaaa.service;

import com.mangooa.uaaa.domain.User;

/**
 * 用户服务接口。
 *
 * @author Weimin Gao
 * @since 1.0.0
 **/
public interface UserService {

	/**
	 * 根据用户账号查找对应用户，如果找不到返回{@code null}。
	 *
	 * @param account 用户账号。
	 * @return 用户对象。
	 */
	User findUserByAccount(String account);

}
