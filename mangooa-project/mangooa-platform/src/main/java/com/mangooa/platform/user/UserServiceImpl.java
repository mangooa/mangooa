package com.mangooa.platform.user;

import com.mangooa.common.platform.security.crypto.password.PasswordEncoder;
import com.mangooa.platform.PlatformConstants;
import com.mangooa.data.jpa.BaseJpaServiceStringId;

import com.mangooa.platform.PlatformProperties;
import lombok.extern.slf4j.Slf4j;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Objects;


/**
 * 用户服务实现类。
 *
 * @author Weimin Gao
 * @since 1.0.0
 **/
@Slf4j
@Service
public class UserServiceImpl extends BaseJpaServiceStringId<UserRepository, UserEntity> implements UserService {

	@Resource
	private PasswordEncoder passwordEncoder;

	@Override
	public PasswordEncoder getPasswordEncoder() {
		return passwordEncoder;
	}

	/**
	 * 初始化平台系统管理员。
	 *
	 * @param init 平台初始化配置。
	 * @return 用户实体对象。
	 */
	@Override
	public UserEntity init(PlatformProperties.Init init) {
		String account = PlatformConstants.PLATFORM_ADMIN_ACCOUNT;
		UserEntity user = getDao().findByAccountIgnoreCase(account);
		if (Objects.isNull(user)) {
			String tenant = PlatformConstants.PLATFORM_TENANT_NAME;
			user = UserEntity.of(account, passwordEncoder.encode(account), "管理员", null, tenant);
			user.setEnabled(true);
			save(user, user, true);
			log.info("login password is {}, please change the password after login.", account);
		}
		return user;
	}

	/**
	 * 用户注册。
	 *
	 * @param email    电子邮箱。
	 * @param password 密码。
	 * @return 用户实体对象。
	 */
	@Override
	public UserEntity registration(String email, String password) {
		UserEntity user = UserEntity.of(email, passwordEncoder.encode(password));
		return save(user, user, true);
	}

	/**
	 * 根据给定的用户唯一标识查找对应的用户实体，如果找不到则返回{@code null}。
	 *
	 * @param uid 给定的用户唯一标识，可以为用户的电子邮件、用户的手机号、用户的登录名、用户的账号等。
	 * @return 用户实体对象。
	 */
	@Override
	public UserEntity find(String uid) {
		String value = uid.trim();
		return getDao().findByEmailIgnoreCaseOrCellphoneIgnoreCaseOrUsernameIgnoreCaseOrAccountIgnoreCase(value, value, value, value);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserEntity user = find(username);
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
