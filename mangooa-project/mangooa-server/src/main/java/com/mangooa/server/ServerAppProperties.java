package com.mangooa.server;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;
import org.springframework.core.env.Environment;

/**
 * 服务器应用属性。
 *
 * @author Weimin Gao
 * @since 1.0.0
 **/
@Getter
@Setter
@ConfigurationProperties(prefix = "mangooa.server")
public class ServerAppProperties {

	private final Environment environment;

	public ServerAppProperties(Environment environment) {
		this.environment = environment;
		setName(environment.getProperty("spring.application.name"));
		setSessionCookieName(environment.getProperty("server.servlet.session.cookie.name"));
	}

	/**
	 * 应用名称。
	 */
	@Setter(AccessLevel.PRIVATE)
	private String name;


	/**
	 * 会话Cookie名称。
	 */
	@Setter(AccessLevel.PRIVATE)
	private String sessionCookieName;

	/**
	 * 初始化配置，服务器第一次启用时创建默认配置，再次启用后此参考无效。
	 */
	@NestedConfigurationProperty
	private Init init = new Init();

	/**
	 * 初始化配置。
	 */
	@Getter
	@Setter
	public static class Init {

		/**
		 * 是否开启初始化，默认为false表示不执行初始化。
		 */
		private boolean enable = false;

		/**
		 * 初始化服务器域，以英文字线点开头，如：.mangooa.com
		 */
		private String domain;

		/**
		 * 初始化管理员。
		 */
		private Admin admin = new Admin();

		/**
		 * 初始化管理员。
		 */
		@Getter
		@Setter
		public static class Admin {

			/**
			 * 管理员电子邮件。
			 */
			private String email;
		}
	}

}
