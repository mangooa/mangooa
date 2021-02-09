package com.mangooa.tools.crypto.digest;

import com.mangooa.tools.core.lang.CharsetUtils;

import java.io.File;
import java.io.InputStream;
import java.nio.charset.Charset;

/**
 * 摘要工具类。
 *
 * @author Weimin Gao
 * @since 1.0.0
 **/
@SuppressWarnings("unused")
public class DigestUtils {

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
		return md5(data, CharsetUtils.UTF_8);
	}

	/**
	 * 计算32位MD5摘要值并转换成十六进制摘要字符串。
	 *
	 * @param data 被摘要数据。
	 * @return 十六进制摘要字符串。
	 */
	public static String md5Hex(byte[] data) {
		return new Md5().digestHex(data);
	}

	/**
	 * 计算32位MD5摘要值并转换成十六进制摘要字符串。
	 *
	 * @param data    被摘要数据。
	 * @param charset 被摘要数据的编码。
	 * @return 十六进制摘要字符串。
	 */
	public static String md5Hex(String data, String charset) {
		return new Md5().digestHex(data, charset);
	}

	/**
	 * 计算32位MD5摘要值并转换成十六进制摘要字符串。
	 *
	 * @param data    被摘要数据。
	 * @param charset 被摘要数据的编码。
	 * @return 十六进制摘要字符串。
	 */
	public static String md5Hex(String data, Charset charset) {
		return new Md5().digestHex(data, charset);
	}

	/**
	 * 计算32位MD5摘要值并转换成十六进制摘要字符串。
	 *
	 * @param data 被摘要数据。
	 * @return 十六进制摘要字符串。
	 */
	public static String md5Hex(String data) {
		return md5Hex(data, CharsetUtils.UTF_8);
	}

	/**
	 * 计算32位MD5摘要值并转换成十六进制摘要字符串。
	 *
	 * @param data 被摘要数据。
	 * @return 十六进制摘要字符串。
	 */
	public static String md5Hex(InputStream data) {
		return new Md5().digestHex(data);
	}

//	/**
//	 * 计算32位MD5摘要值并转换成十六进制摘要字符串。
//	 *
//	 * @param file 被摘要文件。
//	 * @return 十六进制摘要字符串。
//	 */
//	public static String md5Hex(File file) {
//		return new Md5().digestHex(file);
//	}

}
