package com.mangooa.common.core.lang;

import java.util.Objects;

/**
 * @author Weimin Gao
 * @since 1.0.0
 **/
public class ArrayUtils {

	private ArrayUtils() {
		super();
	}

	/**
	 * 检测传入的对象是否是数组对象。
	 *
	 * @param obj 传入的对象。
	 * @return 真表示为数组对象，如果为{@code null}返回false。
	 */
	public static boolean isArray(Object obj) {
		if (Objects.isNull(obj)) {
			return false;
		}
		return obj.getClass().isArray();
	}

	/**
	 * 检测传入的数组对象是否为空。
	 *
	 * @param array 传入的数组对象。
	 * @param <T>   数组元素类型。
	 * @return 真表示为空。
	 */
	public static <T> boolean isEmpty(T[] array) {
		return Objects.isNull(array) || array.length == 0;
	}
}
