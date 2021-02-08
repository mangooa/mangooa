package com.mangooa.tools.core.lang;

import com.mangooa.tools.core.text.CharSequenceUtils;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/**
 * @author Weimin Gao
 * @since 1.0.0
 **/
@SuppressWarnings("unused")
public class StringUtils extends CharSequenceUtils {

	/**
	 * 字符常量：空格符 {@code ' '}
	 */
	public static final char SPACE = CharUtils.SPACE;

	/**
	 * 字符常量：制表符 {@code '\t'}
	 */
	public static final char TAB = CharUtils.TAB;

	/**
	 * 字符常量：点 {@code '.'}
	 */
	public static final char DOT = CharUtils.DOT;

	/**
	 * 字符常量：斜杠 {@code '/'}
	 */
	public static final char SLASH = CharUtils.SLASH;

	/**
	 * 字符常量：反斜杠 {@code '\\'}
	 */
	public static final char BACKSLASH = CharUtils.BACKSLASH;

	/**
	 * 字符常量：回车符 {@code '\r'}
	 */
	public static final char CR = CharUtils.CR;

	/**
	 * 字符常量：换行符 {@code '\n'}
	 */
	public static final char LF = CharUtils.LF;

	/**
	 * 字符常量：减号（连接符） {@code '-'}
	 */
	public static final char DASHED = CharUtils.DASHED;

	/**
	 * 字符常量：下划线 {@code '_'}
	 */
	public static final char UNDERLINE = CharUtils.UNDERLINE;

	/**
	 * 字符常量：逗号 {@code ','}
	 */
	public static final char COMMA = CharUtils.COMMA;

	/**
	 * 字符常量：花括号（左） <code>'{'</code>
	 */
	public static final char BRACE_START = CharUtils.BRACE_START;

	/**
	 * 字符常量：花括号（右） <code>'}'</code>
	 */
	public static final char BRACE_END = CharUtils.BRACE_END;

	/**
	 * 字符常量：中括号（左） {@code '['}
	 */
	public static final char BRACKET_START = CharUtils.BRACKET_START;

	/**
	 * 字符常量：中括号（右） {@code ']'}
	 */
	public static final char BRACKET_END = CharUtils.BRACKET_END;

	/**
	 * 字符常量：圆括号（左） {@code '('}
	 */
	public static final char PARENTHESIS_START = CharUtils.PARENTHESIS_START;

	/**
	 * 截取给定字符串的前后空格，如果给定定的字符串为{@code null}时，则返回{@code null}。
	 *
	 * @param str 给定的字符串。
	 * @return 字符串。
	 * @see String#trim()
	 */
	public static String trim(String str) {
		if (null != str) {
			return str.trim();
		}
		return null;
	}

	/**
	 * 将给定字符串的转换成小写，如果给定定的字符串为{@code null}时，则返回{@code null}。
	 *
	 * @param str 给定的字符串。
	 * @return 字符串。
	 * @see String#toLowerCase()
	 */
	public static String toLowerCase(String str) {
		if (null != str) {
			return str.toLowerCase();
		}
		return null;
	}

	/**
	 * 截取给定字符串的前后空格并转换成小写，如果给定定的字符串为{@code null}时，则返回{@code null}。
	 *
	 * @param str 给定的字符串。
	 * @return 字符串。
	 * @see String#toLowerCase()
	 * @see String#trim()
	 */
	public static String toLowerCaseAndTrim(String str) {
		if (null != str) {
			return str.toLowerCase().trim();
		}
		return null;
	}

	/**
	 * 将给定字符串的转换成大写，如果给定定的字符串为{@code null}时，则返回{@code null}。
	 *
	 * @param str 给定的字符串。
	 * @return 字符串。
	 * @see String#toUpperCase()
	 */
	public static String toUpperCase(String str) {
		if (null != str) {
			return str.toUpperCase();
		}
		return null;
	}

	/**
	 * 截取给定字符串的前后空格并转换成大写，如果给定定的字符串为{@code null}时，则返回{@code null}。
	 *
	 * @param str 给定的字符串。
	 * @return 字符串。
	 * @see String#toUpperCase()
	 * @see String#trim()
	 */
	public static String toUpperCaseAndTrim(String str) {
		if (null != str) {
			return str.toUpperCase().trim();
		}
		return null;
	}


	/**
	 * 调用给定对象的toString方法。<br/>
	 * 如果给定的对象为{@code null}时，则返回null字符串。
	 *
	 * @param object 给定的对象。
	 * @return 字符串。
	 */
	public static String toString(Object object) {
		return null == object ? NULL : object.toString();
	}

	/**
	 * 将给定的对象转换成字符串。<br/>
	 * 如果给定的对象为{@code null}时，则返回null值。<br/>
	 * 如果给定的对象为byte[]、Byte[]、ByteBuffer时，通过指定的指定的字符集进行编码。
	 *
	 * @param object  给定的对象。
	 * @param charset 指定的字符集。
	 * @return 字符串。
	 */
	public String toString(Object object, Charset charset) {
		if (null == object) {
			return null;
		}
		if (object instanceof String) {
			return (String) object;
		} else if (object instanceof byte[]) {
			return toString((byte[]) object, charset);
		} else if (object instanceof Byte[]) {
			return toString((Byte[]) object, charset);
		} else if (object instanceof ByteBuffer) {
			return toString((ByteBuffer) object, charset);
		} else if (ArrayUtils.isArray(object)) {
			return ArrayUtils.toString(object);
		}
		return object.toString();
	}

	/**
	 * 将给定的字节数组根据指定的字符集进行编码转换为字符串。<br/>
	 * 如果给定的对象为{@code null}时，则返回null值。<br/>
	 *
	 * @param data    给定的字节数组。
	 * @param charset 指定的字符集。
	 * @return 字符串。
	 */
	public static String toString(byte[] data, Charset charset) {
		if (data == null) {
			return null;
		}
		if (null == charset) {
			return new String(data);
		}
		return new String(data, charset);
	}

	/**
	 * 将给定的字节数组根据指定的字符集进行编码转换为字符串。<br/>
	 * 如果给定的对象为{@code null}时，则返回null值。<br/>
	 *
	 * @param data    给定的字节数组。
	 * @param charset 指定的字符集。
	 * @return 字符串。
	 */
	public static String toString(byte[] data, String charset) {
		return toString(data, isBlank(charset) ? Charset.defaultCharset() : Charset.forName(charset));
	}

	/**
	 * 将给定的字节数组根据指定的字符集进行编码转换为字符串。<br/>
	 * 如果给定的对象为{@code null}时，则返回null值。<br/>
	 *
	 * @param data    给定的字节数组。
	 * @param charset 指定的字符集。
	 * @return 字符串。
	 */
	public static String toString(Byte[] data, Charset charset) {
		if (data == null) {
			return null;
		}
		byte[] bytes = new byte[data.length];
		Byte b;
		for (int i = 0; i < data.length; i++) {
			b = data[i];
			bytes[i] = (null == b) ? -1 : b;
		}

		return toString(bytes, charset);
	}

	/**
	 * 将给定的字节数组根据指定的字符集进行编码转换为字符串。<br/>
	 * 如果给定的对象为{@code null}时，则返回null值。<br/>
	 *
	 * @param data    给定的字节数组。
	 * @param charset 指定的字符集。
	 * @return 字符串。
	 */
	public static String toString(Byte[] data, String charset) {
		return toString(data, isBlank(charset) ? Charset.defaultCharset() : Charset.forName(charset));
	}

	/**
	 * 将给定的字节缓存对象根据指定的字符集进行编码转换为字符串。<br/>
	 * 如果给定的字节缓存对象为{@code null}时，则返回null值。<br/>
	 *
	 * @param data    给定的字节缓存对象。
	 * @param charset 指定的字符集。
	 * @return 字符串。
	 */
	public static String toString(ByteBuffer data, Charset charset) {
		if (null == data) {
			return null;
		}
		if (null == charset) {
			charset = Charset.defaultCharset();
		}
		return charset.decode(data).toString();
	}

	/**
	 * 将给定的字节缓存对象根据指定的字符集进行编码转换为字符串。<br/>
	 * 如果给定的字节缓存对象为{@code null}时，则返回null值。<br/>
	 *
	 * @param data    给定的字节缓存对象。
	 * @param charset 指定的字符集。
	 * @return 字符串。
	 */
	public static String toString(ByteBuffer data, String charset) {
		return toString(data, Charset.forName(charset));
	}

}
