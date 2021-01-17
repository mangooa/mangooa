package com.mangooa.server;

import lombok.Getter;
import lombok.Setter;

import org.springframework.boot.context.properties.ConfigurationProperties;

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

	/**
	 * 初始化配置，服务器第一次启用时创建默认配置，再次启用后此参考无效。
	 */
	private Init init = new Init();

	/**
	 * 初始化配置。
	 */
	@Getter
	@Setter
	public static class Init {

		/**
		 * 服务器域，以英文字线点开头，如“.mangooa.com"。
		 */
		private String domain;

		/**
		 * 是否关闭初始化操作，默认为false表示启动时执行初始化。
		 */
		private boolean close = false;

	}

}
