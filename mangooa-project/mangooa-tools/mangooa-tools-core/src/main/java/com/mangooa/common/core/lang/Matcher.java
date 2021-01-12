package com.mangooa.common.core.lang;

/**
 * 匹配接口。
 *
 * @author Weimin Gao
 * @since 1.0.0
 **/
public interface Matcher<T> {

	/**
	 * 匹配给定的对象。
	 *
	 * @param object 给定的对象。
	 * @return 真表示匹配。
	 */
	boolean match(T object);

}
