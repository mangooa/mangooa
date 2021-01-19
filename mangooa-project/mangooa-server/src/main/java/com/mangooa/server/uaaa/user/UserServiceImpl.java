package com.mangooa.server.uaaa.user;

import com.mangooa.common.domain.Editor;
import com.mangooa.common.security.crypto.password.PasswordEncoder;
import com.mangooa.data.jpa.BaseJpaServiceStringId;

import com.mangooa.server.ServerAppProperties;
import com.mangooa.server.uaaa.security.user.UserDetails;
import com.mangooa.tools.core.lang.ObjectId;

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
		if (!init.isEnable()) {
			String email = init.getAdmin().getEmail().trim().toLowerCase();
			if (getDao().countByEmailIgnoreCase(email) == 0) {
				String password = ObjectId.get().toHexString();
				UserEntity entity = UserEntity.of(INIT_ADMIN_ACCOUNT, passwordEncoder.encode(password), "管理员", email, INIT_TENANT_NAME);
				entity.setEnabled(true);
				save(Editor.of(entity), entity, true);
				log.info("login password is {}, please change the password after login.", password);
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
		//UserEntity user = UserEntity.of(email, passwordEncoder.encode(password));
		//return save(Editor.of(user), user, true);
		return null;
	}

	/**
	 * 根据给定的用户登录账号查找对应的用户，返回一个用户详情对象。
	 *
	 * @param username 给定的用户登录账号。
	 * @return 用户详情对象，如果找不到返回{@code null}。
	 */
	@Override
	public UserDetails findUserByUsername(String username) {
		UserDetails ret = null;
		UserEntity user = getDao().findByUsernameIgnoreCase(username);
		if (null != user) {
			ret = new UserDetails();
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
