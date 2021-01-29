package com.mangooa.uaa.oauth.config;

import com.mangooa.common.spring.security.crypto.password.PasswordEncoder;
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
 * <pre>
 * 授权服务器配置，需要配置以下内容。
 * 1：配置客户端详细信息服务（ClientDetailsServiceConfigurer）
 * 2：配置令牌管理服务（AuthorizationServerTokenServices）
 * 3：配置令牌访问端点（AuthorizationServerEndpointsConfigurer）
 * 4：配置令牌访问端点安全约束（AuthorizationServerSecurityConfigurer）
 * </pre>
 *
 * @author Weimin Gao
 * @since 1.0.0
 **/
@Configuration
@EnableAuthorizationServer
@SuppressWarnings("unused")
public class AuthorizationServerConfigurer extends AuthorizationServerConfigurerAdapter {

	@Resource
	private ClientDetailsService clientDetailsService;

	@Resource
	private TokenStore tokenStore;

	@Resource
	private AuthorizationCodeServices authorizationCodeServices;

	@Resource
	private AuthenticationManager authenticationManager;

	@Resource
	private AuthorizationServerTokenServices tokenServices;

	@Resource
	private PasswordEncoder passwordEncoder;

	/**
	 * 客户端详细信息服务配置。
	 */
	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		// clients.withClientDetails(clientDetailsService);
		clients
			.inMemory()
			.withClient("c1")
			.secret(passwordEncoder.encode("123456"))
			.resourceIds("r1")
			.authorizedGrantTypes("authorization_code", "password", "client_credentials", "implicit", "refresh_token")
			.scopes("all")
			// 配置值为假（false）时会跳转到授权页面，否则直接发放令牌
			.autoApprove(false)
			.redirectUris("http://www.baidu.com");
	}

	/**
	 * 令牌管理服务配置。
	 */
	@Bean
	public AuthorizationServerTokenServices tokenServices() {
		DefaultTokenServices services = new DefaultTokenServices();
		// 客户端详细信息服务
		services.setClientDetailsService(clientDetailsService);
		// 是否产生刷新令牌
		services.setSupportRefreshToken(true);
		// 令牌存储策略
		services.setTokenStore(tokenStore);
		// 访问令牌默认有效期2小时
		services.setAccessTokenValiditySeconds(7200);
		// 刷新令牌默认有效期3天
		services.setRefreshTokenValiditySeconds(259200);
		return services;
	}

	/**
	 * <pre>
	 * 令牌访问端点配置。
	 * 	 /oauth/authorize		获取授权码端点
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
			// 授权码模式需要
			.authorizationCodeServices(authorizationCodeServices)
			// 密码模式需要
			.authenticationManager(authenticationManager)
			// 任何模式都需要配置令牌管理服务
			.tokenServices(tokenServices)
			.allowedTokenEndpointRequestMethods(HttpMethod.POST);
	}

	/**
	 * 令牌访问端点安全约束配置。
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
