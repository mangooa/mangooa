package com.mangooa.tools.core.lang;

/**
 * 字符相关工具类。
 *
 * @author Weimin Gao
 * @since 1.0.0
 **/
@SuppressWarnings("unused")
public class CharUtils {

	/**
	 * 字符常量：空格符 {@code ' '}
	 */
	public static final char SPACE = ' ';

	/**
	 * 字符常量：制表符 {@code '\t'}
	 */
	public static final char TAB = '	';

	/**
	 * 字符常量：点 {@code '.'}
	 */
	public static final char DOT = '.';

	/**
	 * 字符常量：斜杠 {@code '/'}
	 */
	public static final char SLASH = '/';

	/**
	 * 字符常量：反斜杠 {@code '\\'}
	 */
	public static final char BACKSLASH = '\\';

	/**
	 * 字符常量：回车符 {@code '\r'}
	 */
	public static final char CR = '\r';

	/**
	 * 字符常量：换行符 {@code '\n'}
	 */
	public static final char LF = '\n';

	/**
	 * 字符常量：减号（连接符） {@code '-'}
	 */
	public static final char DASHED = '-';

	/**
	 * 字符常量：下划线 {@code '_'}
	 */
	public static final char UNDERLINE = '_';

	/**
	 * 字符常量：逗号 {@code ','}
	 */
	public static final char COMMA = ',';

	/**
	 * 字符常量：花括号（左） <code>'{'</code>
	 */
	public static final char BRACE_START = '{';

	/**
	 * 字符常量：花括号（右） <code>'}'</code>
	 */
	public static final char BRACE_END = '}';

	/**
	 * 字符常量：中括号（左） {@code '['}
	 */
	public static final char BRACKET_START = '[';

	/**
	 * 字符常量：中括号（右） {@code ']'}
	 */
	public static final char BRACKET_END = ']';

	/**
	 * 字符常量：圆括号（左） {@code '('}
	 */
	public static final char PARENTHESIS_START = '(';

	/**
	 * 字符常量：圆括号（右） {@code ')'}
	 */
	public static final char PARENTHESIS_END = ')';

	/**
	 * 字符常量：双引号 {@code '"'}
	 */
	public static final char DOUBLE_QUOTES = '"';

	/**
	 * 字符常量：单引号 {@code '\''}
	 */
	public static final char SINGLE_QUOTE = '\'';

	/**
	 * 字符常量：与 {@code '&'}
	 */
	public static final char AMP = '&';

	/**
	 * 字符常量：冒号 {@code ':'}
	 */
	public static final char COLON = ':';

	/**
	 * 字符常量：艾特 {@code '@'}
	 */
	public static final char AT = '@';

	/**
	 * 检查给定的字符是否为空白字符。<br/>
	 * 空白字符包括：空格、制表符、全角空格和不间断空格。
	 *
	 * @param c 给定的字符。
	 * @return 真表示为空白字符。
	 * @see Character#isWhitespace(int)
	 * @see Character#isSpaceChar(int)
	 */
	public static boolean isBlankChar(char c) {
		return isBlankChar((int) c);
	}

	/**
	 * 检查给定的字符是否为空白字符。<br/>
	 * 空白字符包括：空格、制表符、全角空格和不间断空格。
	 *
	 * @param c 给定的字符。
	 * @return 真表示为空白字符。
	 * @see Character#isWhitespace(int)
	 * @see Character#isSpaceChar(int)
	 */
	public static boolean isBlankChar(int c) {
		return Character.isWhitespace(c)
			|| Character.isSpaceChar(c)
			|| c == '\ufeff'
			|| c == '\u202a';
	}
}
