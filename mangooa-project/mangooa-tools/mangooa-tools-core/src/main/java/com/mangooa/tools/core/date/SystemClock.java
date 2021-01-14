package com.mangooa.tools.core.date;

/**
 * 系统时钟。
 *
 * @author Weimin Gao
 * @since 1.0.0
 **/
public class SystemClock {

	/**
	 * 获取系统当前时间戳。
	 *
	 * @return 当前时间戳。
	 */
	public static long now() {
		return System.currentTimeMillis();
	}
}
