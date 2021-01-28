package com.mangooa.uaa.oauth.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;

/**
 * 令牌配置。
 *
 * @author Weimin Gao
 * @since 1.0.0
 **/
@Configuration
public class TokenConfig {

	@Bean
	public TokenStore tokenStore() {
		return new InMemoryTokenStore();
	}
}
