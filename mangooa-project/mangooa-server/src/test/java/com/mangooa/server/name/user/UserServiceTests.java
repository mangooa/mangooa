package com.mangooa.server.name.user;

import static org.junit.jupiter.api.Assertions.*;

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

	@Test
	public void test() {
		assertNotNull(userService);
	}
}
