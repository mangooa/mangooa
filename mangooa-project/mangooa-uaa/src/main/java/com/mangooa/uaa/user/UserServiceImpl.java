package com.mangooa.uaa.user;

import com.mangooa.common.spring.security.crypto.password.PasswordEncoder;
import com.mangooa.common.uaa.UaaInitConstants;
import com.mangooa.data.jpa.BaseJpaServiceStringId;

import lombok.extern.slf4j.Slf4j;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


/**
 * 用户服务实现类。
 *
 * @author Weimin Gao
 * @since 1.0.0
 **/
@Slf4j
@Service
public class UserServiceImpl extends BaseJpaServiceStringId<UserRepository, User> implements UserService {

	@Resource
	private PasswordEncoder passwordEncoder;

	@Override
	public PasswordEncoder getPasswordEncoder() {
		return passwordEncoder;
	}

	/**
	 * 初始化系统管理员。
	 */
	@Override
	public void init() {
		String account = UaaInitConstants.INIT_ADMIN_ACCOUNT;
		if (getDao().countByAccountIgnoreCase(account) == 0) {
			String tenant = UaaInitConstants.INIT_TENANT_NAME;
			User user = User.of(account, passwordEncoder.encode(account), "管理员", null, tenant);
			user.setEnabled(true);
			save(user, true, user);
			log.info("login password is {}, please change the password after login.", account);
		}
	}

	/**
	 * 用户注册。
	 *
	 * @param email    电子邮箱。
	 * @param password 密码。
	 * @return 用户实体对象。
	 */
	@Override
	public User registration(String email, String password) {
		User user = User.of(email, passwordEncoder.encode(password));
		return save(user, true, user);
	}

	/**
	 * 根据给定的用户唯一标识查找对应的用户实体，如果找不到则返回{@code null}。
	 *
	 * @param uid 给定的用户唯一标识，可以为用户的电子邮件、用户的手机号、用户的登录名、用户的账号等。
	 * @return 用户实体对象。
	 */
	@Override
	public User find(String uid) {
		String value = uid.trim();
		return getDao().findByEmailIgnoreCaseOrCellphoneIgnoreCaseOrUsernameIgnoreCaseOrAccountIgnoreCase(value, value, value, value);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = find(username);
		com.mangooa.security.core.userdetails.UserDetails ret = new com.mangooa.security.core.userdetails.UserDetails();
		ret.setAccount(user.getAccount());
		ret.setAccountNonExpired(true);
		ret.setAccountNonLocked(true);
		ret.setAuthorities(null);
		ret.setCredentialsNonExpired(true);
		ret.setEnabled(true);
		ret.setName(user.getName());
		ret.setNickname(user.getNickname());
		ret.setPassword(user.getPassword());
		ret.setTenant(user.getTenant());
		return ret;
	}
}
