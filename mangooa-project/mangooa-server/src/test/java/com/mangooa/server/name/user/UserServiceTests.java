package com.mangooa.server.name.user;

import static com.mangooa.server.ServerAppConstant.INIT_ADMIN_ACCOUNT;
import static org.junit.jupiter.api.Assertions.*;

import com.mangooa.server.security.crypto.password.PasswordEncoder;
import com.mangooa.test.BaseAppTest;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Weimin Gao
 * @since 1.0.0
 **/
public class UserServiceTests extends BaseAppTest {

	@Autowired
	private UserService userService;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Test
	public void test() {
		assertNotNull(userService);
	}


	@Test
	public void testFind() {
		UserEntity entity = userService.find(INIT_ADMIN_ACCOUNT);
		assertAll("testFind",
			() -> assertNotNull(entity),
			() -> assertTrue(passwordEncoder.matches(INIT_ADMIN_ACCOUNT, entity.getPassword()))
		);
	}
}
