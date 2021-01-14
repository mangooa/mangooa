package com.mangooa.tools.core.lang;

import java.util.function.Supplier;

/**
 * * 断言。<br/>
 * * 断言某些对象或值是否符合规定，否则抛出异常。
 *
 * @author Weimin Gao
 * @since 1.0.0
 **/
@SuppressWarnings("unused")
public class Assert {

	/**
	 * 断言对象是否为{@code null}，如果不为{@code null}抛出指定类型异常。
	 *
	 * @param object   被检查的对象。
	 * @param supplier 断言不通过时抛出异常的提供者。
	 * @param <T>      被检查的对象的类型。
	 * @param <E>      抛出异常的类型。
	 * @throws E 如果被检查的对象不为{@code null}时。
	 */
	public static <T, E extends Throwable> void isNull(T object, Supplier<E> supplier) throws E {
		if (null != object) {
			throw supplier.get();
		}
	}

	/**
	 * 断言对象是否为{@code null}，如果不为{@code null}抛出{@link IllegalArgumentException}异常。
	 *
	 * @param object 被检查的对象。
	 * @param error  错误抛出异常附带的消息模板，变量用{}代替。
	 * @param params 变量参数列表。
	 * @param <T>    被检查的对象的类型。
	 * @throws IllegalArgumentException 如果被检查的对象不为{@code null}时。
	 */
	public static <T> void isNull(T object, String error, Object... params) throws IllegalArgumentException {
		isNull(object, () -> new IllegalArgumentException(StringUtil.format(error, params)));
	}

	/**
	 * 断言对象是否为{@code null}，如果不为{@code null}抛出{@link IllegalArgumentException}异常。
	 *
	 * @param object 被检查的对象。
	 * @param <T>    被检查的对象的类型。
	 * @throws IllegalArgumentException 如果被检查的对象不为{@code null}时。
	 */
	public static <T> void isNull(T object) throws IllegalArgumentException {
		isNull(object, "[Assertion failed] - this argument must be null");
	}

	/**
	 * 断言对象是否不为{@code null}，如果为{@code null}抛出指定类型异常。
	 *
	 * @param object   被检查的对象。
	 * @param supplier 断言不通过时抛出异常的提供者。
	 * @param <T>      被检查的对象的类型。
	 * @param <E>      抛出异常的类型。
	 * @return 被检查的对象。
	 * @throws E 如果被检查的对象为{@code null}时。
	 */
	public static <T, E extends Throwable> T notNull(T object, Supplier<E> supplier) throws E {
		if (null == object) {
			throw supplier.get();
		}
		return object;
	}

	/**
	 * 断言对象是否不为{@code null}，如果为{@code null}抛出{@link IllegalArgumentException}异常。
	 *
	 * @param object 被检查的对象。
	 * @param error  错误抛出异常附带的消息模板，变量用{}代替。
	 * @param params 变量参数列表。
	 * @param <T>    被检查的对象的类型。
	 * @return 被检查的对象。
	 * @throws IllegalArgumentException 如果被检查的对象为{@code null}时。
	 */
	public static <T> T notNull(T object, String error, Object... params) throws IllegalArgumentException {
		return notNull(object, () -> new IllegalArgumentException(StringUtil.format(error, params)));
	}

	/**
	 * 断言对象是否不为{@code null}，如果为{@code null}抛出{@link IllegalArgumentException}异常。
	 *
	 * @param object 被检查的对象。
	 * @param <T>    被检查的对象的类型。
	 * @return 被检查的对象。
	 * @throws IllegalArgumentException 如果被检查的对象为{@code null}时。
	 */
	public static <T> T notNull(T object) throws IllegalArgumentException {
		return notNull(object, "[Assertion failed] - this argument must not be null");
	}

	/**
	 * 断言是否为假，如果为{@code true}抛出指定类型异常。
	 *
	 * @param expression 布尔表达式。
	 * @param supplier   断言不通过时抛出异常的提供者。
	 * @param <E>        抛出异常的类型。
	 * @throws E 如果被检查的对象为{@code true}时。
	 */
	public static <E extends Throwable> void isFalse(boolean expression, Supplier<E> supplier) throws E {
		if (expression) {
			throw supplier.get();
		}
	}

	/**
	 * 断言是否为假，如果为{@code true}抛出指定类型异常。
	 *
	 * @param expression 布尔表达式。
	 * @param error      错误抛出异常附带的消息模板，变量用{}代替。
	 * @param params     变量参数列表。
	 * @throws IllegalArgumentException 如果被检查的对象为{@code true}时。
	 */
	public static void isFalse(boolean expression, String error, Object... params) throws IllegalArgumentException {
		isFalse(expression, () -> new IllegalArgumentException(StringUtil.format(error, params)));
	}

	/**
	 * 断言是否为假，如果为{@code true}抛出指定类型异常。
	 *
	 * @param expression 布尔表达式。
	 * @throws IllegalArgumentException 如果被检查的对象为{@code true}时。
	 */
	public static void isFalse(boolean expression) throws IllegalArgumentException {
		isFalse(expression, "[Assertion failed] - this expression must be false");
	}

	/**
	 * 断言是否为真，如果为{@code false}抛出给定的异常。
	 *
	 * @param expression 布尔表达式。
	 * @param supplier   断言不通过时抛出异常的提供者。
	 * @param <E>        抛出异常的类型。
	 * @throws E 如果被检查的对象为{@code true}时。
	 */
	public static <E extends Throwable> void isTrue(boolean expression, Supplier<? extends E> supplier) throws E {
		if (!expression) {
			throw supplier.get();
		}
	}

	/**
	 * 断言是否为真，如果为{@code false}抛出{@code IllegalArgumentException}异常。
	 *
	 * @param expression 布尔表达式。
	 * @param error      错误抛出异常附带的消息模板，变量用{}代替。
	 * @param params     变量参数列表。
	 * @throws IllegalArgumentException 如果布尔表达式为{@code false}时。
	 */
	public static void isTrue(boolean expression, String error, Object... params) throws IllegalArgumentException {
		isTrue(expression, () -> new IllegalArgumentException(StringUtil.format(error, params)));
	}

	/**
	 * 断言是否为真，如果为{@code false}抛出{@code IllegalArgumentException}异常。
	 *
	 * @param expression 布尔表达式。
	 * @throws IllegalArgumentException 如果布尔表达式为{@code false}时。
	 */
	public static void isTrue(boolean expression) throws IllegalArgumentException {
		isTrue(expression, "[Assertion failed] - this expression must be true");
	}

}
