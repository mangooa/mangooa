package com.mangooa.common.core.lang;

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
	 * 控制台打印新行，功能同System.out.println()方法。
	 */
	public static void log() {
		out.println();
	}

//	/**
//	 * 控制台打印给定的对象。<br/>
//	 * 如果给定的对象为{@code Throwable}对象时，则打印堆栈信息。
//	 *
//	 * @param object 给定的对象。
//	 */
//	public static void log(Object object) {
//		if (object instanceof Throwable) {
//			final Throwable e = (Throwable) object;
//			log(e, e.getMessage());
//		} else {
//			log(TextFormatter.PLACEHOLDER, object);
//		}
//	}
//
//	/**
//	 * 控制台打印给定的异常对象堆栈信息，在打印异常堆栈信息之前先打印给定的信息。<br/>
//	 * 如果给定的异常对象为{@code null}时则忽略不打印。
//	 *
//	 * @param cause  给定的异常对象。
//	 * @param msg    给定的信息。
//	 * @param values 给定的信息占位符替换值。
//	 */
//	public static void log(Throwable cause, String msg, Object... values) {
//		out.println(StringUtil.format(msg, values));
//		if (!Objects.isNull(cause)) {
//			cause.printStackTrace();
//			out.flush();
//		}
//	}
//
//	private static void log0(String message, Object... values) {
//		log(null, message, values);
//	}
//
//	/**
//	 * 控制台打印给定的对象，功能 同 System.out.println()方法。<br/>
//	 * 如果给定的对象为{@code Throwable}对象时，则打印堆栈信息。
//	 *
//	 * @param object 给定的对象。
//	 * @param values 给定的对象占位符替换的值。
//	 */
//	public static void log(Object object, Object... values) {
//		if (ArrayUtil.isEmpty(values)) {
//			log(object);
//		} else {
//			log0(buildTemplateSplitBySpace(values.length + 1), ArrayUtil.insert(values, 0, object));
//		}
//	}
//
//	/**
//	 * 控制台打印给定的消息，功能同System.out.println()方法。<br/>
//	 * 如果给定的消息中包含{}时，将被数组{@code values}中的内容替换后打印。
//	 *
//	 * @param msg    给定的消息。
//	 * @param values 用于替换给定的消息中包含{}位置的值。
//	 */
//	public void log_(String msg, Object... values) {
//		if (ArrayUtil.isEmpty(values) || StringUtil.contains(msg, TextFormatter.PLACEHOLDER)) {
//			log0(msg, values);
//		} else {
//			//log0(buildTemplateSplitBySpace(values.length + 1), ArrayUtil.insert(values, 0, msg));
//		}
//	}
//
//
//
//	/**
//	 * 构建空格分隔的模板，类似于"{} {} {} {}"
//	 *
//	 * @param count 变量数量
//	 * @return 模板
//	 */
//	private static String buildTemplateSplitBySpace(int count) {
//		return StrUtil.repeatAndJoin(TextFormatter.PLACEHOLDER, count, StringUtil.SPACE);
//	}
}
