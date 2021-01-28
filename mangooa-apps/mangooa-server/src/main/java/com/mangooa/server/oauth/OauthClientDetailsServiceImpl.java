package com.mangooa.server.oauth;

import com.mangooa.server.app.AppService;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.stereotype.Service;

/**
 * @author Weimin Gao
 * @since 1.0.0
 **/
@Service
public class OauthClientDetailsServiceImpl implements org.springframework.security.oauth2.provider.ClientDetailsService {

	private final AppService appService;

	public OauthClientDetailsServiceImpl(AppService appService) {
		this.appService = appService;
	}

	@Override
	public ClientDetails loadClientByClientId(String clientId) throws ClientRegistrationException {
		return null;
	}
}
