package com.mangooa.common.crypto.digest;

/**
 * 信息摘要算法类型枚举。
 *
 * @author Weimin Gao
 * @since 1.0.0
 **/
public enum DigestAlgorithm {

	/**
	 * 信息摘要算法5。
	 */
	MD5("MD5");

	private final String value;

	/**
	 * 构造函数。
	 *
	 * @param value 信息摘要算法字符串表示值。
	 */
	DigestAlgorithm(String value) {
		this.value = value;
	}

	/**
	 * 获取信息摘要算法字符串表示值。
	 *
	 * @return 信息摘要算法字符串表示值。
	 */
	public String value() {
		return value;
	}
}

