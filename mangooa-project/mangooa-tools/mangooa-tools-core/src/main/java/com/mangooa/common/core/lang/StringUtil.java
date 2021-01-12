package com.mangooa.common.core.lang;

import com.mangooa.common.core.text.CharSequenceUtil;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/**
 * @author Weimin Gao
 * @since 1.0.0
 **/
@SuppressWarnings("unused")
public class StringUtil extends CharSequenceUtil {

	/**
	 * 字符常量：空格符 {@code ' '}
	 */
	public static final char SPACE = CharUtil.SPACE;

	/**
	 * 字符常量：制表符 {@code '\t'}
	 */
	public static final char TAB = CharUtil.TAB;

	/**
	 * 字符常量：点 {@code '.'}
	 */
	public static final char DOT = CharUtil.DOT;

	/**
	 * 字符常量：斜杠 {@code '/'}
	 */
	public static final char SLASH = CharUtil.SLASH;

	/**
	 * 字符常量：反斜杠 {@code '\\'}
	 */
	public static final char BACKSLASH = CharUtil.BACKSLASH;

	/**
	 * 字符常量：回车符 {@code '\r'}
	 */
	public static final char CR = CharUtil.CR;

	/**
	 * 字符常量：换行符 {@code '\n'}
	 */
	public static final char LF = CharUtil.LF;

	/**
	 * 字符常量：减号（连接符） {@code '-'}
	 */
	public static final char DASHED = CharUtil.DASHED;

	/**
	 * 字符常量：下划线 {@code '_'}
	 */
	public static final char UNDERLINE = CharUtil.UNDERLINE;

	/**
	 * 字符常量：逗号 {@code ','}
	 */
	public static final char COMMA = CharUtil.COMMA;

	/**
	 * 字符常量：花括号（左） <code>'{'</code>
	 */
	public static final char BRACE_START = CharUtil.BRACE_START;

	/**
	 * 字符常量：花括号（右） <code>'}'</code>
	 */
	public static final char BRACE_END = CharUtil.BRACE_END;

	/**
	 * 字符常量：中括号（左） {@code '['}
	 */
	public static final char BRACKET_START = CharUtil.BRACKET_START;

	/**
	 * 字符常量：中括号（右） {@code ']'}
	 */
	public static final char BRACKET_END = CharUtil.BRACKET_END;

	/**
	 * 字符常量：圆括号（左） {@code '('}
	 */
	public static final char PARENTHESIS_START = CharUtil.PARENTHESIS_START;

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
		} else if (ArrayUtil.isArray(object)) {
			return ArrayUtil.toString(object);
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
