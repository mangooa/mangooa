package com.mangooa.tools.core.date;

import java.util.Calendar;

/**
 * 日期时间各个部分枚举，各个部分的值与日历{@code java.util.Calendar}中值对应。
 *
 * @author Weimin Gao
 * @since 1.0.0
 **/
@SuppressWarnings("unused")
public enum DateTimeField {

	/**
	 * 世纪
	 *
	 * @see Calendar#ERA
	 */
	ERA(Calendar.ERA),

	/**
	 * 年
	 *
	 * @see Calendar#YEAR
	 */
	YEAR(Calendar.YEAR),

	/**
	 * 月
	 *
	 * @see Calendar#MONTH
	 */
	MONTH(Calendar.MONTH),

	/**
	 * 一年中第几周
	 *
	 * @see Calendar#WEEK_OF_YEAR
	 */
	WEEK_OF_YEAR(Calendar.WEEK_OF_YEAR),

	/**
	 * 一月中第几周
	 *
	 * @see Calendar#WEEK_OF_MONTH
	 */

	WEEK_OF_MONTH(Calendar.WEEK_OF_MONTH),

	/**
	 * 一月中的第几天
	 *
	 * @see Calendar#DAY_OF_MONTH
	 */
	DAY_OF_MONTH(Calendar.DAY_OF_MONTH),

	/**
	 * 一年中的第几天
	 *
	 * @see Calendar#DAY_OF_YEAR
	 */
	DAY_OF_YEAR(Calendar.DAY_OF_YEAR),

	/**
	 * 周几，1表示周日，2表示周一
	 *
	 * @see Calendar#DAY_OF_WEEK
	 */
	DAY_OF_WEEK(Calendar.DAY_OF_WEEK),

	/**
	 * 天所在的周是这个月的第几周
	 *
	 * @see Calendar#DAY_OF_WEEK_IN_MONTH
	 */
	DAY_OF_WEEK_IN_MONTH(Calendar.DAY_OF_WEEK_IN_MONTH),

	/**
	 * 上午或者下午
	 *
	 * @see Calendar#AM_PM
	 */
	AM_PM(Calendar.AM_PM),

	/**
	 * 小时，用于12小时制
	 *
	 * @see Calendar#HOUR
	 */
	HOUR(Calendar.HOUR),

	/**
	 * 小时，用于24小时制
	 *
	 * @see Calendar#HOUR
	 */
	HOUR_OF_DAY(Calendar.HOUR_OF_DAY),

	/**
	 * 分钟
	 *
	 * @see Calendar#MINUTE
	 */
	MINUTE(Calendar.MINUTE),

	/**
	 * 秒
	 *
	 * @see Calendar#SECOND
	 */
	SECOND(Calendar.SECOND),

	/**
	 * 毫秒
	 *
	 * @see Calendar#MILLISECOND
	 */
	MILLISECOND(Calendar.MILLISECOND);

	private final int value;

	DateTimeField(int value) {
		this.value = value;
	}

	/**
	 * 获取当前日期时间字段枚举对象对应日历{@code java.util.Calendar}中的值。
	 *
	 * @return 当前日期时间字段枚举的值。
	 */
	public int getValue() {
		return this.value;
	}

	/**
	 * 根据给定的值获取对应的日期时间字段枚举对象。
	 *
	 * @param value 给定的值，对应日历{@code java.util.Calendar}中的值。
	 * @return 日期时间字段枚举对象。
	 */
	public static DateTimeField of(int value) {
		switch (value) {
			case Calendar.ERA:
				return ERA;
			case Calendar.YEAR:
				return YEAR;
			case Calendar.MONTH:
				return MONTH;
			case Calendar.WEEK_OF_YEAR:
				return WEEK_OF_YEAR;
			case Calendar.WEEK_OF_MONTH:
				return WEEK_OF_MONTH;
			case Calendar.DAY_OF_MONTH:
				return DAY_OF_MONTH;
			case Calendar.DAY_OF_YEAR:
				return DAY_OF_YEAR;
			case Calendar.DAY_OF_WEEK:
				return DAY_OF_WEEK;
			case Calendar.DAY_OF_WEEK_IN_MONTH:
				return DAY_OF_WEEK_IN_MONTH;
			case Calendar.AM_PM:
				return AM_PM;
			case Calendar.HOUR:
				return HOUR;
			case Calendar.HOUR_OF_DAY:
				return HOUR_OF_DAY;
			case Calendar.MINUTE:
				return MINUTE;
			case Calendar.SECOND:
				return SECOND;
			case Calendar.MILLISECOND:
				return MILLISECOND;
			default:
				throw new IllegalArgumentException("value out of rang.");
		}
	}
}
