package com.mangooa.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;

/**
 * WEB应用测试基类。
 *
 * @author Weimin Gao
 * @since 1.0.0
 **/
@AutoConfigureMockMvc
public abstract class BaseWebAppTest extends BaseAppTest {

	@Autowired
	protected MockMvc mockMvc;
}
