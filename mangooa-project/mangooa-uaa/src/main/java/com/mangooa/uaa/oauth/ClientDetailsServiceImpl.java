package com.mangooa.uaa.oauth;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.security.oauth2.provider.client.BaseClientDetails;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 认证客户端详情服务。
 *
 * @author Weimin Gao
 * @since 1.0.0
 **/
@Component
public class ClientDetailsServiceImpl implements ClientDetailsService {

	@Resource
	private PasswordEncoder passwordEncoder;

	@Override
	public ClientDetails loadClientByClientId(String clientId) throws ClientRegistrationException {

		BaseClientDetails client = new BaseClientDetails();
		client.setClientId("c1");
		client.setClientSecret(passwordEncoder.encode("123456"));
		client.setResourceIds(Arrays.asList("r1"));
		client.setAuthorizedGrantTypes(Arrays.asList("authorization_code", "password", "client_credentials", "implicit", "refresh_token"));
		client.setScope(Arrays.asList("all"));
		client.isAutoApprove("true");
		Set<String> uris = new HashSet<>();
		uris.add("http://www.baidu.com");
		client.setRegisteredRedirectUri(uris);
		return client;
	}
}
