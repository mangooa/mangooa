package com.mangooa.server.name.user;

import com.mangooa.data.jpa.BaseJpaServiceStringId;
import com.mangooa.server.ServerAppProperties;
import com.mangooa.server.security.crypto.password.PasswordEncoder;

import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Service;

import static com.mangooa.server.ServerAppConstant.INIT_ADMIN_ACCOUNT;
import static com.mangooa.server.ServerAppConstant.INIT_TENANT_NAME;

/**
 * 用户服务实现类。
 *
 * @author Weimin Gao
 * @since 1.0.0
 **/
@Slf4j
@Service
public class UserServiceImpl extends BaseJpaServiceStringId<UserRepository, UserEntity> implements UserService {

	/**
	 * 密码加密器。
	 */
	private final PasswordEncoder passwordEncoder;

	/**
	 * 构造函数。
	 *
	 * @param passwordEncoder 密码加密器。
	 */
	public UserServiceImpl(PasswordEncoder passwordEncoder) {
		this.passwordEncoder = passwordEncoder;
	}

	/**
	 * 初始化管理员。
	 *
	 * @param properties 服务器应用配置属性。
	 */
	@Override
	public void init(ServerAppProperties properties) {
		ServerAppProperties.Init init = properties.getInit();
		if (init.isEnable()) {
			String email = init.getAdmin().getEmail().trim().toLowerCase();
			if (getDao().countByEmailIgnoreCase(email) == 0) {
				String account = INIT_ADMIN_ACCOUNT;
				UserEntity user = UserEntity.of(account, passwordEncoder.encode(account), "管理员", email, INIT_TENANT_NAME);
				user.setEnabled(true);
				save(user, true, user);
				log.info("login password is {}, please change the password after login.", account);
			}
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
	public UserEntity registration(String email, String password) {
		UserEntity user = UserEntity.of(email, passwordEncoder.encode(password));
		return save(user, true, user);
	}

	/**
	 * 根据给定的关键字查找对应的用户实体，如果找不到则返回{@code null}。
	 *
	 * @param key 给定的关键字，可以为用户的电子邮件、用户的手机号、用户的登录名、用户的账号等。
	 * @return 用户实体对象。
	 */
	@Override
	public UserEntity find(String key) {
		String value = key.trim();
		return getDao().findByEmailIgnoreCaseOrCellphoneIgnoreCaseOrUsernameIgnoreCaseOrAccountIgnoreCase(value, value, value, value);
	}
}
