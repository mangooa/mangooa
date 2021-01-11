package com.mangooa.common.core.lang;

import java.util.Objects;

import static java.lang.System.out;

/**
 * 控制台工具类，主要针对对系统标准输出{@link System#out}及错误输出{@link System#err}进行封装。
 *
 * @author Weimin Gao
 * @since 1.0.0
 **/
@SuppressWarnings("unused")
public class Console {

	/**
	 * 消息内容替换占位符。
	 */
	private static final String MESSAGE_REPLACE_PLACEHOLDER = "{}";

	private Console() {
		super();
	}

	/**
	 * 控制台打印消息，同System.out.println()方法。<br/>
	 * 如果参数message中包含{}时，将被认参数values替换后打印。
	 *
	 * @param message 打印消息。
	 * @param values  替换参数message中包含{}的值。
	 */
	public void log(String message, Object... values) {
//		if (ArrayUtils.isEmpty(values) || StringUtils.contains(message, MESSAGE_REPLACE_PLACEHOLDER)) {
//			log_(message, values);
//		} else {
//			//log_(buildTemplateSplitBySpace(values.length + 1), ArrayUtils.insert(values, 0, message));
//		}
	}


	/**
	 * @param cause
	 * @param message
	 * @param values
	 */
	public static void log(Throwable cause, String message, Object... values) {
		out.println(StringUtils.format(message, values));
		if (!Objects.isNull(cause)) {
			cause.printStackTrace();
			out.flush();
		}
	}


	private static void log_(String message, Object... values) {
		log(null, message, values);
	}
}
