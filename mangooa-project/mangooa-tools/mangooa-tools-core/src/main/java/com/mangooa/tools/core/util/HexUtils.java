package com.mangooa.tools.core.util;

import com.mangooa.tools.core.lang.StringUtils;

import java.nio.charset.Charset;

/**
 * 十六进制工具类。
 *
 * @author Weimin Gao
 * @since 1.0.0
 **/
@SuppressWarnings("unused")
public class HexUtils {

	/**
	 * 用于输出十六进制小写字符的数组。
	 */
	private static final char[] DIGITS_LOWER = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

	/**
	 * 用于输出十六进制大写字符的数组。
	 */
	private static final char[] DIGITS_UPPER = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};


	/**
	 * 将给定的字节数组转换为十六进制字符串。
	 *
	 * @param data   给定的字节数组。
	 * @param digits 用于输出十六进制的节符数组。
	 * @return 十六进制字符数组。
	 */
	private static char[] encodeHex(byte[] data, char[] digits) {
		final int len = data.length;
		final char[] out = new char[len << 1];
		for (int i = 0, j = 0; i < len; i++) {
			// 高位
			out[j++] = digits[(0xF0 & data[i]) >>> 4];
			// 低位
			out[j++] = digits[0x0F & data[i]];
		}
		return out;
	}

	/**
	 * 将给定的字节数组转换为十六进制字符串。
	 *
	 * @param data   给定的字节数组。
	 * @param digits 用于输出十六进制的节符数组。
	 * @return 十六进制字符串。
	 */
	private static String encodeHexStr(byte[] data, char[] digits) {
		return new String(encodeHex(data, digits));
	}

	/**
	 * 将给定的字节数组转换为十六进制字符数组。
	 *
	 * @param data      给定的字节数组。
	 * @param lowercase 真表示输出十六进制小写字符串。
	 * @return 十六进制字符数组。
	 */
	public static char[] encodeHex(byte[] data, boolean lowercase) {
		return encodeHex(data, lowercase ? DIGITS_LOWER : DIGITS_UPPER);
	}

	/**
	 * 将给定的字节数组转换为十六进制字符串。
	 *
	 * @param data      给定的字节数组。
	 * @param lowercase 真表示输出十六进制小写字符串。
	 * @return 十六进制字符串。
	 */
	public static String encodeHexStr(byte[] data, boolean lowercase) {
		return encodeHexStr(data, lowercase ? DIGITS_LOWER : DIGITS_UPPER);
	}

	/**
	 * 将给定的字节数组转换为十六进制字符串。
	 *
	 * @param data 给定的字节数组。
	 * @return 十六进制字符串。
	 */
	public static String encodeHexStr(byte[] data) {
		return encodeHexStr(data, true);
	}

	/**
	 * 将给定的字符串转换为十六进制字符串。
	 *
	 * @param data    给定的字符串。
	 * @param charset 给定的字符串的编码。
	 * @return 十六进制字符串。
	 */
	public static String encodeHexStr(String data, Charset charset) {
		return encodeHexStr(StringUtils.toBytes(data, charset), true);
	}


}
