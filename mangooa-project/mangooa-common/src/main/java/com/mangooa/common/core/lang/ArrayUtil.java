package com.mangooa.common.core.lang;

import java.lang.reflect.Array;
import java.util.Objects;

/**
 * 数组工具类。
 *
 * @author Weimin Gao
 * @since 1.0.0
 **/
@SuppressWarnings("unused")
public class ArrayUtil {

	private ArrayUtil() {
		super();
	}

	/**
	 * 对象是否是数组对象。<br/>
	 * 如果参数object为{@code null}时则返回false。
	 *
	 * @param object 对象。
	 * @return 真表示为数组对象。
	 */
	public static boolean isArray(Object object) {
		return null != object && object.getClass().isArray();
	}

	/**
	 * 数组是否为空。
	 *
	 * @param array 数组。
	 * @param <T>   数组元素类型。
	 * @return 真表示为空。
	 */
	public static <T> boolean isEmpty(T[] array) {
		return null == array || array.length == 0;
	}

	/**
	 * 数组是否为空。<br/>
	 * 如果参数array为{@code null}则返回true。<br/>
	 * 如果参数array为非数组对象，则返回false。<br/>
	 * 如果参数array为数组对象，数组长度大于0情况下返回false，否则返回true。
	 *
	 * @param array 数组。
	 * @return 真表示为空。
	 */
	public static boolean isEmpty(Object array) {
		if (null != array) {
			if (isArray(array)) {
				return 0 == Array.getLength(array);
			}
			return false;
		}
		return true;
	}

	/**
	 * 数组是否为非空。
	 *
	 * @param <T>   数组元素类型。
	 * @param array 数组。
	 * @return 真表示不为空。
	 */
	public static <T> boolean isNotEmpty(T[] array) {
		return (null != array && array.length != 0);
	}

	/**
	 * 数组是否为非空。<br/>
	 *
	 * @param array 数据。
	 * @return 真表示不为空。
	 */
	public static boolean isNotEmpty(Object array) {
		return !isEmpty(array);
	}

	/**
	 * 返回数组中第一个匹配规则的值。
	 *
	 * @param matcher 匹配接口。
	 * @param array   数组。
	 * @param <T>     数组元素类型。
	 * @return 第一个匹配规则的值，如果不存在非空元素或数组为空，返回{@code null}值。
	 */
	@SafeVarargs
	public static <T> T firstMatch(Matcher<T> matcher, T... array) {
		if (isNotEmpty(array)) {
			for (final T element : array) {
				if (matcher.match(element)) {
					return element;
				}
			}
		}
		return null;
	}

	/**
	 * 返回数组中第一个非空元素的值。
	 *
	 * @param array 数组.
	 * @param <T>   数组元素类型。
	 * @return 第一个非空元素的值，如果不存在非空元素或数组为空，返回{@code null}值。
	 */
	@SafeVarargs
	public static <T> T firstNonNull(T... array) {
		return firstMatch(Objects::nonNull, array);
	}

	/**
	 * 检查数据是否全部为null值。
	 *
	 * @param array 数组。
	 * @param <T>   数组元素类型。
	 * @return 真表示全部为null值。
	 */
	@SafeVarargs
	public static <T> boolean isAllNull(T... array) {
		return null == firstNonNull(array);
	}

	/**
	 * 检查数组是否包含{@code null}元素。
	 *
	 * @param array 被检查的数组。
	 * @param <T>   数组元素类型。
	 * @return 真表示包含。
	 */
	@SafeVarargs
	public static <T> boolean hasNull(T... array) {
		if (isNotEmpty(array)) {
			for (T element : array) {
				if (null == element) {
					return true;
				}
			}
		}
		return false;
	}
}
