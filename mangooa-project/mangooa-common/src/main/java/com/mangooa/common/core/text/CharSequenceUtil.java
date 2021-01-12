package com.mangooa.common.core.text;

import com.mangooa.common.core.lang.ArrayUtil;
import com.mangooa.common.core.lang.CharUtil;
import com.mangooa.common.core.lang.CharsetUtil;

import java.nio.charset.Charset;

/**
 * 字符文本工具类。
 *
 * @author Weimin Gao
 * @since 1.0.0
 **/
@SuppressWarnings("unused")
public class CharSequenceUtil {

	/**
	 * 字符串常量：{@code "null"} ，注意{@code "null" != null}。
	 */
	public static final String NULL = "null";

	/**
	 * 字符串常量：空字符串 {@code ""}
	 */
	public static final String EMPTY = "";

	/**
	 * 字符串常量：空格符 {@code " "}
	 */
	public static final String SPACE = " ";

	/**
	 * 检查给定的字符串中是否包含子字符串。<br/>
	 * 如果给定的字符串或子字符串为{@code null}时，返回false。
	 *
	 * @param str    字符串。
	 * @param substr 子字符串。
	 * @return 真表示包含。
	 */
	public static boolean contains(CharSequence str, CharSequence substr) {
		if (null == str || null == substr) {
			return false;
		}
		return str.toString().contains(substr);
	}

	/**
	 * 检查给定的字符串是否为空白字符串。<br/>
	 * 空白字符串范围：<br/>
	 * <ol>
	 *     <li>{@code null}</li>
	 *     <li>空字符串{@code ""}</li>
	 *     <li>空格、全角空格、制表符、换行符，等不可见字符</li>
	 * </ol>
	 * 例子：<br/>
	 * <ul>
	 *     <li>{@code isBlank(null)     // true}</li>
	 *     <li>{@code isBlank("")       // true}</li>
	 *     <li>{@code isBlank(" ")      // true}</li>
	 *     <li>{@code isBlank(" \t\n")	// true}</li>
	 *     <li>{@code isBlank("abc")	// false}</li>
	 * </ul>
	 *
	 * @param cs 给定的字符串.
	 * @return 真表示是空白字符串。
	 */
	public static boolean isBlank(CharSequence cs) {
		int length;
		if ((null == cs) || ((length = cs.length()) == 0)) {
			return true;
		}
		// 循环检测只要有一个非空字符即为非空字符串
		for (int i = 0; i < length; i++) {
			if (!CharUtil.isBlankChar(cs.charAt(i))) {
				return false;
			}
		}
		return true;
	}

	/**
	 * 检查字符串是否为非空白字符串。<br/>
	 * 空白字符串范围：<br/>
	 * <ol>
	 *     <li>不为{@code null}</li>
	 *     <li>不为空字符串{@code ""}</li>
	 *      <li>不为空格、全角空格、制表符、换行符，等不可见字符</li>
	 * </ol>
	 * 例子：<br/>
	 * <ul>
	 *     <li>{@code isNotBlank(null)      // false}</li>
	 *     <li>{@code isNotBlank("")        // false}</li>
	 *     <li>{@code isNotBlank(" ")       // false}</li>
	 *     <li>{@code isNotBlank(" \t\n")	// false}</li>
	 *     <li>{@code isNotBlank("abc")     // true}</li>
	 * </ul>
	 *
	 * @param cs 给定的字符串.
	 * @return 真表示是非空白字符串。
	 */
	public static boolean isNotBlank(CharSequence cs) {
		return !isBlank(cs);
	}

	/**
	 * 检查给定的字符串数组，是否全部为空白字符串。<br/>
	 * 如果给定的字符串数据的长度为0或者其中的任意一个元素为空字符串，则返回true。<br/>
	 * 例子：<br/>
	 * <ul>
	 *     <li>{@code isAllBlank()                  // true}</li>
	 *     <li>{@code isAllBlank("", null, " ")     // true}</li>
	 *     <li>{@code isAllBlank("123", " ")        // false}</li>
	 *     <li>{@code isAllBlank("123", "abc")      // false}</li>
	 * </ul>
	 *
	 * @param cs 给定的字符串数组。
	 * @return 真表示全部为空白字符串。
	 */
	public static boolean isAllBlank(CharSequence... cs) {
		if (ArrayUtil.isEmpty(cs)) {
			return true;
		}
		for (CharSequence str : cs) {
			if (isNotBlank(str)) {
				return false;
			}
		}
		return true;
	}

	/**
	 * 检查给定的字符串数组，是否全部为非空白字符串。<br/>
	 * 如果给定的字符串数据的长度不为0且其中的任意一个元素不为空字符串，则返回true。<br/>
	 * 例子：<br/>
	 * <ul>
	 *     <li>{@code isAllNotBlank()                  // false}</li>
	 *     <li>{@code isAllNotBlank("", null, " ")     // false}</li>
	 *     <li>{@code isAllNotBlank("123", " ")        // false}</li>
	 *     <li>{@code isAllNotBlank("123", "abc")      // true}</li>
	 * </ul>
	 *
	 * @param cs 给定的字符串数组。
	 * @return 真表示全部为空白字符串。
	 */
	public static boolean isAllNotBlank(CharSequence... cs) {
		return !hasBlank(cs);
	}

	/**
	 * 检查给定的字符串数组中，是否包含空白字符串。<br/>
	 * 如果给定的字符串数据的长度为0或者其中的任意一个元素是空字符串，则返回true。<br/>
	 * 例子：<br/>
	 * <ul>
	 *     <li>{@code hasBlank()                  // true}</li>
	 *     <li>{@code hasBlank("", null, " ")     // true}</li>
	 *     <li>{@code hasBlank("123", " ")        // true}</li>
	 *     <li>{@code hasBlank("123", "abc")      // false}</li>
	 * </ul>
	 *
	 * @param cs 给定的字符串数组.
	 * @return 真表示包含空字符串。
	 */
	public static boolean hasBlank(CharSequence... cs) {
		if (ArrayUtil.isEmpty(cs)) {
			return true;
		}
		for (CharSequence str : cs) {
			if (isBlank(str)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 检查给定的字符串是否为空字符串。<br/>
	 * 空字符串范围如下：<br/>
	 * <ol>
	 *     <li>{@code null}</li>
	 *     <li>{@code ""}</li>
	 * </ol>
	 * 例子：<br/>
	 * <ul>
	 *     <li>{@code isEmpty(null)     // true}</li>
	 *     <li>{@code isEmpty("")       // true}</li>
	 *     <li>{@code isEmpty(" \t\n")  // false}</li>
	 *     <li>{@code isEmpty("abc")    // false}</li>
	 * </ul>
	 *
	 * @param cs 给定的字符串.
	 * @return 真表示为空字符串。
	 */
	public static boolean isEmpty(CharSequence cs) {
		return null == cs || cs.length() == 0;
	}


	/**
	 * 检查给定的字符串是否为非空字符串。<br/>
	 * 非空字符串范围如下：<br/>
	 * <ol>
	 *     <li>不为{@code null}</li>
	 *     <li>不为{@code ""}</li>
	 * </ol>
	 * 例子：<br/>
	 * <ul>
	 *     <li>{@code isNotEmpty(null)     // false}</li>
	 *     <li>{@code isNotEmpty("")       // false}</li>
	 *     <li>{@code isNotEmpty(" \t\n")  // true}</li>
	 *     <li>{@code isNotEmpty("abc")    // true}</li>
	 * </ul>
	 *
	 * @param cs 给定的字符串.
	 * @return 真表示为非空字符串。
	 */
	public static boolean isNotEmpty(CharSequence cs) {
		return !isEmpty(cs);
	}

	/**
	 * 检查给定的字符串数组，是否包含空字符串。<br/>
	 * 空字符串范围如下：<br/>
	 * <ol>
	 *     <li>{@code null}</li>
	 *     <li>{@code ""}</li>
	 * </ol>
	 * 例子：<br/>
	 * <ul>
	 *     <li>{@code hasEmpty()                  // true}</li>
	 *     <li>{@code hasEmpty("", null)          // true}</li>
	 *     <li>{@code hasEmpty("123", "")         // true}</li>
	 *     <li>{@code hasEmpty("123", "abc")      // false}</li>
	 *     <li>{@code hasEmpty(" ", "\t", "\n")   // false}</li>
	 * </ul>
	 *
	 * @param cs 给定的字符串数组。
	 * @return 真表示包含空字符串。
	 */
	public static boolean hasEmpty(CharSequence... cs) {
		if (ArrayUtil.isEmpty(cs)) {
			return true;
		}
		for (CharSequence str : cs) {
			if (isEmpty(str)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 检查给定的字符串数组，是否全部为空字符串。<br/>
	 * 空字符串范围如下：<br/>
	 * <ol>
	 *     <li>{@code null}</li>
	 *     <li>{@code ""}</li>
	 * </ol>
	 * 例子：<br/>
	 * <ul>
	 *     <li>{@code isAllEmpty()                  // true}</li>
	 *     <li>{@code isAllEmpty("", null)          // true}</li>
	 *     <li>{@code isAllEmpty("123", "")         // false}</li>
	 *     <li>{@code isAllEmpty("123", "abc")      // false}</li>
	 *     <li>{@code isAllEmpty(" ", "\t", "\n")   // false}</li>
	 * </ul>
	 *
	 * @param cs 给定的字符串数组。
	 * @return 真表示全部为空字符串。
	 */
	public static boolean isAllEmpty(CharSequence... cs) {
		if (ArrayUtil.isEmpty(cs)) {
			return true;
		}
		for (CharSequence str : cs) {
			if (isNotEmpty(str)) {
				return false;
			}
		}
		return true;
	}

	/**
	 * 检查给定的字符串数组，是否全部为非空字符串。<br/>
	 * 非空字符串范围如下：<br/>
	 * <ol>
	 *     <li>不为{@code null}</li>
	 *     <li>不为{@code ""}</li>
	 * </ol>
	 * 例子：<br/>
	 * <ul>
	 *     <li>{@code isAllNotEmpty()                  // false}</li>
	 *     <li>{@code isAllNotEmpty("", null)          // false}</li>
	 *     <li>{@code isAllNotEmpty("123", "")         // false}</li>
	 *     <li>{@code isAllNotEmpty("123", "abc")      // true}</li>
	 *     <li>{@code isAllNotEmpty(" ", "\t", "\n")   // true}</li>
	 * </ul>
	 *
	 * @param cs 给定的字符串数组。
	 * @return 真表示全部为非空字符串。
	 */
	public static boolean isAllNotEmpty(CharSequence... cs) {
		return !hasEmpty(cs);
	}

	/**
	 * 将给定的消息根据占位符{}按照顺序替换为对应的值，返回格式后的字符串。<br/>
	 * 如果给定的消息模板为{@code null}时，则返回"null"字符串。<br/>
	 * 如果综合的参数数据为{@code null}或空时，则返回给定的消息模板。<br/>
	 * 如果想输出{}使用\\转义{即可，如果想输出{}之前的\使用双转义符\\\\即可。<br/>
	 * 例如：<br/>
	 * <ol>
	 *     <li>通常使用：format("this is {} for {}", "a", "b") =》 this is a for b</li>
	 *     <li>转义{}： format("this is \\{} for {}", "a", "b") =》 this is \{} for a</li>
	 *     <li>转义\： format("this is \\\\{} for {}", "a", "b") =》 this is \a for b</li>
	 * </ol>
	 *
	 * @param msg    给定的消息。
	 * @param values 给定的消息占位符替换的值。
	 * @return 格式化后的字符串。
	 */
	public static String format(CharSequence msg, Object... values) {
		if (null == msg) {
			return NULL;
		}
		if (ArrayUtil.isEmpty(msg) || isBlank(msg)) {
			return msg.toString();
		}
		return TextFormatter.format(msg.toString(), values);
	}

	/**
	 * 将给定的字符串使用指定字符集进行编码，返回编码后的字节数组。<br/>
	 * 如果给定字符串的字符集为空，则使用平台默认字符集进行编码。
	 *
	 * @param cs      给定的字符串。
	 * @param charset 给定字符串的字符集。
	 * @return 编码后的字节数组。
	 */
	public static byte[] toBytes(CharSequence cs, Charset charset) {
		if (null == cs) {
			return null;
		}
		if (null == charset) {
			return cs.toString().getBytes();
		}
		return cs.toString().getBytes(charset);
	}

	/**
	 * 将给定的字符串使用指定字符集进行编码，返回编码后的字节数组。<br/>
	 * 如果给定字符串的字符集为空，则使用平台默认字符集进行编码。
	 *
	 * @param cs      给定的字符串。
	 * @param charset 给定的字符串的字符集。
	 * @return 编码后的字节数组。
	 */
	public static byte[] toBytes(CharSequence cs, String charset) {
		return toBytes(cs, isBlank(charset) ? Charset.defaultCharset() : Charset.forName(charset));
	}

	/**
	 * 将给定的字符串使用UTF8字符集进行编码，返回编码后的字节数组。<br/>
	 *
	 * @param cs 给定的字符串。
	 * @return 编码后的字节数组。
	 */
	public static byte[] toBytesUseUtf8(CharSequence cs) {
		return toBytes(cs, CharsetUtil.UTF_8);
	}

}
