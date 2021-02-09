package com.mangooa.common.platform.manage;

import java.io.Serializable;

/**
 * 平台配置接口。
 *
 * @author Weimin Gao
 * @since 1.0.0
 **/
public interface PlatformProfile extends Serializable {

	/**
	 * 返回平台域名，如：.mangooa.com。
	 *
	 * @return 平台域名。
	 */
	String getDomain();
}
