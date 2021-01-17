package com.mangooa.server.uaaa.user;

import com.mangooa.common.domain.Editor;
import com.mangooa.common.security.crypto.password.PasswordEncoder;
import com.mangooa.common.security.user.UserDetails;
import com.mangooa.data.jpa.JpaServiceStringId;
import com.mangooa.server.uaaa.security.user.UserDetailsVo;

/**
 * @author Weimin Gao
 * @since 1.0.0
 **/
@SuppressWarnings("unused")
public interface UserService extends JpaServiceStringId<UserRepository, UserEntity>, com.mangooa.uaaa.service.UserService {

	/**
	 * 获取用户密码加密器。
	 *
	 * @return 密码加密器。
	 */
	PasswordEncoder getPasswordEncoder();

	/**
	 * 用户注册。
	 *
	 * @param email    电子邮箱。
	 * @param password 密码。
	 * @return 用户实体对象。
	 */
	default UserEntity registration(String email, String password) {
		UserEntity user = UserEntity.of(email, getPasswordEncoder().encode(password));
		return save(Editor.of(user),user, true);
	}

	/**
	 * 根据给定的用户登录账号查找对应的用户，返回一个用户详情对象。
	 *
	 * @param username 给定的用户登录账号。
	 * @return 用户详情对象，如果找不到返回{@code null}。
	 */
	default UserDetails findUserByUsername(String username){
		UserDetailsVo ret = null;
		UserEntity user = getDao().findByUsernameIgnoreCase(username);
		if (null != user) {
			ret = new UserDetailsVo();
			ret.setAccount(user.getAccount());
			ret.setAccountNonExpired(true);
			ret.setAccountNonLocked(true);
			ret.setAuthorities(null);
			ret.setEnabled(true);
			ret.setName(user.getName());
			ret.setPassword(user.getPassword());
			ret.setUsername(user.getUsername());
		}
		return ret;
	}

}
