package com.mangooa.tools.core.date;

import java.util.Calendar;
import java.util.Date;

/**
 * 日历对象封装工具类。
 *
 * @author Weimin Gao
 * @since 1.0.0
 **/
@SuppressWarnings("unused")
public class CalendarUtil {

	/**
	 * 获取一个日历对象，时间为默认时区的当前时间。
	 *
	 * @return 日历对象。
	 * @see java.util.Calendar
	 */
	public static Calendar getCalendar() {
		return Calendar.getInstance();
	}

	/**
	 * 获取一个日历{@link java.util.Calendar}对象。
	 *
	 * @param date 日期对象。
	 * @return 日历对象。
	 */
	public static Calendar getCalendar(Date date) {
		if (date instanceof DateTime) {
			return ((DateTime) date).toCalendar();
		} else {
			return getCalendar(date.getTime());
		}
	}

	/**
	 * 获取一个日历{@link java.util.Calendar}对象。
	 *
	 * @param timestamp 时间戳。
	 * @return 日历对象。
	 */
	public static Calendar getCalendar(long timestamp) {
		final Calendar cal = Calendar.getInstance();
		cal.setTimeInMillis(timestamp);
		return cal;
	}
}
