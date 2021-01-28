package com.mangooa.uaa.oauth.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.code.AuthorizationCodeServices;
import org.springframework.security.oauth2.provider.code.InMemoryAuthorizationCodeServices;
import org.springframework.security.oauth2.provider.token.AuthorizationServerTokenServices;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;

import javax.annotation.Resource;

/**
 * 授权服务配置。
 *
 * @author Weimin Gao
 * @since 1.0.0
 **/
@Configuration
@EnableAuthorizationServer
@SuppressWarnings("unused")
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

	@Resource
	private ClientDetailsService clientDetailsService;

	@Resource
	private TokenStore tokenStore;

	/**
	 * 授权码模式需要配置授权码管理服务。
	 */
	@Resource
	private AuthorizationCodeServices authorizationCodeServices;

	/**
	 * 密码模式需要认证管理器。
	 */
	@Resource
	private AuthenticationManager authenticationManager;

	/**
	 * 令牌管理服务。
	 */
	@Resource
	private AuthorizationServerTokenServices tokenServices;

	/**
	 * 1：配置获取客户详情。
	 */
	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		clients.withClientDetails(clientDetailsService);
	}

	/**
	 * 2：配置令牌管理服务。
	 */
	@Bean
	public AuthorizationServerTokenServices tokenServices() {
		DefaultTokenServices services = new DefaultTokenServices();
		services.setClientDetailsService(clientDetailsService);
		services.setSupportRefreshToken(true);
		services.setTokenStore(tokenStore);
		services.setAccessTokenValiditySeconds(60);
		services.setRefreshTokenValiditySeconds(120);
		return services;
	}

	/**
	 * <pre>
	 * 3：配置令牌访问端点。
	 * 	 /oauth/authorize		获取授权端点
	 * 	 /oauth/token		    获取令牌端点
	 * 	 /oauth/confirm_access	用户确认授权提交端点
	 * 	 /oauth/error			授权服务报错错误信息端点
	 * 	 /oauth/check_token		用于解析令牌信息的端点
	 * 	 /oauth/token_key		获取公有密钥的端点
	 * </pre>
	 */
	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) {
		endpoints
			// 授权码服务
			.authorizationCodeServices(authorizationCodeServices)
			// 认证管理器
			.authenticationManager(authenticationManager)
			// 令牌管理服务
			.tokenServices(tokenServices)
			.allowedTokenEndpointRequestMethods(HttpMethod.POST);
	}

	/**
	 * 4：配置令牌访问端点安全约束。
	 */
	@Override
	public void configure(AuthorizationServerSecurityConfigurer security) {
		security
			// 允许访问获取公有密钥的端点：/oauth/token_key
			.tokenKeyAccess("permitAll()")
			// 允许访问用于解析令牌信息的端点：/oauth/check_token
			.checkTokenAccess("permitAll()")
			// 允许表单认证（申请令牌）
			.allowFormAuthenticationForClients();
	}

	@Bean
	public AuthorizationCodeServices authorizationCodeServices() {
		return new InMemoryAuthorizationCodeServices();
	}


}
