package com.mangooa.common.platform.user;

/**
 * @author Weimin Gao
 * @since 1.0.0
 **/
public interface UserService<U extends User> {

	/**
	 * 根据给定的用户唯一标识查找对应的用户，如果找不到则返回{@code null}。
	 *
	 * @param uid 给定的用户唯一标识。
	 * @return 用户对象。
	 */
	U find(String uid);
}
