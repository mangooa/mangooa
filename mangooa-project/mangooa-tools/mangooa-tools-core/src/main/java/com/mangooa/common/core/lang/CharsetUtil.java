package com.mangooa.common.core.lang;

import java.nio.charset.Charset;
import java.nio.charset.UnsupportedCharsetException;

/**
 * 字符集相关工具类。
 *
 * @author Weimin Gao
 * @since 1.0.0
 **/
public class CharsetUtil {

	/**
	 * UTF-8
	 */
	public static final String UTF_8 = "UTF-8";

	/**
	 * 将给定的字符集转换为字符集对象。<br/>
	 * 如果给定的字符集为{@code null}时使用默认字符集。
	 *
	 * @param charset 给定的字符集。
	 * @return 字符集对象。
	 * @throws UnsupportedCharsetException 如果给定的字符集不支持时。
	 */
	public static Charset charset(String charset) throws UnsupportedCharsetException {
		return StringUtil.isBlank(charset) ? Charset.defaultCharset() : Charset.forName(charset);
	}

}
