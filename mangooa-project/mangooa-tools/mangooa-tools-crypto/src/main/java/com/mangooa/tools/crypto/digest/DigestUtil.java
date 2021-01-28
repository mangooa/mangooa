package com.mangooa.tools.crypto.digest;

import com.mangooa.tools.core.lang.CharsetUtil;

/**
 * 摘要工具类。
 *
 * @author Weimin Gao
 * @since 1.0.0
 **/
@SuppressWarnings("unused")
public class DigestUtil {

	/**
	 * 计算32位MD5摘要值。
	 *
	 * @param data 被摘要数据。
	 * @return MD5摘要。
	 */
	public static byte[] md5(byte[] data) {
		return new Md5().digest(data);
	}

	/**
	 * 计算32位MD5摘要值。
	 *
	 * @param data    被摘要数据。
	 * @param charset 字符编码。
	 * @return MD5摘要。
	 */
	public static byte[] md5(String data, String charset) {
		return new Md5().digest(data, charset);
	}

	/**
	 * 计算32位MD5摘要值，使用UTF-8编码。
	 *
	 * @param data 被摘要数据。
	 * @return MD5摘要。
	 */
	public static byte[] md5(String data) {
		return md5(data, CharsetUtil.UTF_8);
	}

}
