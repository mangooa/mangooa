package com.mangooa.tools.core.util;

import java.util.UUID;

/**
 * 唯一标识生成器工具类，如：UUID、ObjectId（MongoDB）。
 *
 * @author Weimin Gao
 * @since 1.0.0
 **/
@SuppressWarnings("unused")
public class IdUtils {

	/**
	 * 生成随机的通用唯一识别码（Universally Unique Identifier）。
	 *
	 * @return 唯一识别码。
	 */
	public static String randomUuid() {
		return UUID.randomUUID().toString();
	}

	/**
	 * 生成随机的通用唯一识别码（Universally Unique Identifier），并去掉了横线。
	 *
	 * @return 简化的UUID，去掉了横线。
	 */
	public static String simpleUuid() {
		return UUID.randomUUID().toString().replaceAll("-", "");
	}

	/**
	 * 创建一个唯一标识（MongoDB生成策略实现）。
	 *
	 * @return 唯一标识。
	 */
	public static String objectId() {
		return ObjectId.get().toHexString();
	}

}
