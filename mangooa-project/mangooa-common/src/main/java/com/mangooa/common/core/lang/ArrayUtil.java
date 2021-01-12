package com.mangooa.common.core.lang;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Objects;

/**
 * 数组相关工具类。
 *
 * @author Weimin Gao
 * @since 1.0.0
 **/
@SuppressWarnings("unused")
public class ArrayUtil {

	/**
	 * 检查给定的对象是否是数组对象。<br/>
	 * 如果给定的对象为{@code null}时返回false。
	 *
	 * @param object 给定的对象。
	 * @return 真表示为数组对象。
	 */
	public static boolean isArray(Object object) {
		return null != object && object.getClass().isArray();
	}

	/**
	 * 检查给定的数组是否为空。<br/>
	 * 如果给定的数组为{@code null}时返回true。
	 *
	 * @param array 给定的数组。
	 * @param <T>   给定的数组元素类型。
	 * @return 真表示为空。
	 */
	public static <T> boolean isEmpty(T[] array) {
		return null == array || array.length == 0;
	}

	/**
	 * 检查给定的对象是否为空。<br/>
	 * 如果给定的对象为{@code null}时返回true。<br/>
	 * 如果给定的对象为非数组对象时返回false。<br/>
	 * 如果给定的对象为数组对象时，且数组长度大于0情况下返回false，否则返回true。
	 *
	 * @param array 给定的对象。
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
	 * 检查给定的数组是否为非空。
	 *
	 * @param array 给定的数组。
	 * @param <T>   给定的数组元素类型。
	 * @return 真表示为非空。
	 */
	public static <T> boolean isNotEmpty(T[] array) {
		return (null != array && array.length != 0);
	}

	/**
	 * 检测给定的对象是否为非空。
	 *
	 * @param array 给定的对象。
	 * @return 真表示为非空。
	 */
	public static boolean isNotEmpty(Object array) {
		return !isEmpty(array);
	}

	/**
	 * 返回给定的数组对象中第一个匹配规则的值。
	 *
	 * @param matcher 匹配接口。
	 * @param array   给定的数组。
	 * @param <T>     给定的数组元素类型。
	 * @return 第一个匹配规则的值，如果不存在非空元素或给定的数组为空，返回{@code null}值。
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
	 * 返回给定的数组中第一个非空元素的值。
	 *
	 * @param array 给定的数组.
	 * @param <T>   给定的数组元素类型。
	 * @return 第一个非空元素的值，如果不存在非空元素或给定的数组为空，返回{@code null}值。
	 */
	@SafeVarargs
	public static <T> T firstNonNull(T... array) {
		return firstMatch(Objects::nonNull, array);
	}

	/**
	 * 检查给定的数据是否全部为{@code null}值。
	 *
	 * @param array 给定的数据。
	 * @param <T>   给定的数据元素类型。
	 * @return 真表示全部为{@code null}值。
	 */
	@SafeVarargs
	public static <T> boolean isAllNull(T... array) {
		return null == firstNonNull(array);
	}

	/**
	 * 检查给定的数组是否包含{@code null}元素。
	 *
	 * @param array 给定的数组。
	 * @param <T>   给定的数组元素类型。
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

	/**
	 * 将给定的数组对象内容转成字符串。
	 *
	 * @param object 给定的数组对象。
	 * @return 字符串。
	 * @see Arrays#toString
	 */
	public static String toString(Object object) {
		if (null == object) {
			return null;
		}
		if (object instanceof long[]) {
			return Arrays.toString((long[]) object);
		} else if (object instanceof int[]) {
			return Arrays.toString((int[]) object);
		} else if (object instanceof short[]) {
			return Arrays.toString((short[]) object);
		} else if (object instanceof char[]) {
			return Arrays.toString((char[]) object);
		} else if (object instanceof byte[]) {
			return Arrays.toString((byte[]) object);
		} else if (object instanceof boolean[]) {
			return Arrays.toString((boolean[]) object);
		} else if (object instanceof float[]) {
			return Arrays.toString((float[]) object);
		} else if (object instanceof double[]) {
			return Arrays.toString((double[]) object);
		} else if (ArrayUtil.isArray(object)) {
			try {
				return Arrays.deepToString((Object[]) object);
			} catch (Exception e) {
				// 忽略
			}
		}
		return object.toString();
	}

}
