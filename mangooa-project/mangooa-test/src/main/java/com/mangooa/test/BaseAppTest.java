package com.mangooa.test;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

/**
 * 应用测试基类。
 *
 * @author Weimin Gao
 * @since 1.0.0
 **/
@SpringBootTest
@ActiveProfiles({"junit"})
public abstract class BaseAppTest {
}
