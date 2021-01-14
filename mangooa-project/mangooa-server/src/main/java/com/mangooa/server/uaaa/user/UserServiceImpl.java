package com.mangooa.server.uaaa.user;

import com.mangooa.common.service.impl.BaseJpaServiceStringId;
import com.mangooa.tools.core.lang.Assert;
import com.mangooa.uaaa.domain.User;
import org.springframework.stereotype.Service;

/**
 * @author Weimin Gao
 * @since 1.0.0
 **/
@Service
public class UserServiceImpl extends BaseJpaServiceStringId<UserRepository, UserEntity> implements UserService {

	@Override
	public User findUserByAccount(String account) {
		Assert.notNull(account);
		return getDao().findByAccountIgnoreCase(account.trim());
	}
}
