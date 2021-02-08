package com.mangooa.platform;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;

/**
 * @author Weimin Gao
 * @since 1.0.0
 **/
@ConfigurationProperties(prefix = "platform")
@Getter
@Setter(AccessLevel.PRIVATE)
public class PlatformProperties {

	/**
	 * 初始化配置。
	 */
	@NestedConfigurationProperty
	private Init init = new Init();

	/**
	 * 初始化配置。
	 */
	@Getter
	@Setter(AccessLevel.PRIVATE)
	public static class Init {

		/**
		 * 初始化是否关闭，默认true表示不执行初始化。
		 */
		private boolean close = true;

		/**
		 * 初始化域名。
		 */
		private String domain;

		/**
		 * 初始化租户。
		 */
		private String tenant;

		/**
		 * 初始化管理员配置。
		 */
		private Administrator administrator = new Administrator();

		/**
		 * 初始化管理员配置。
		 */
		@Getter
		@Setter(AccessLevel.PRIVATE)
		public static class Administrator {

			/**
			 * 初始化管理员电子邮件。
			 */
			private String email;
		}
	}
}
