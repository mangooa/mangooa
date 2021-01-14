package com.mangooa.tools.core.date;

import java.util.Calendar;

/**
 * 星期枚举。
 *
 * @author Weimin Gao
 * @since 1.0.0
 **/
@SuppressWarnings("unused")
public enum Week {

	/**
	 * 周日
	 */
	SUNDAY(Calendar.SUNDAY),

	/**
	 * 周一
	 */
	MONDAY(Calendar.MONDAY),

	/**
	 * 周二
	 */
	TUESDAY(Calendar.TUESDAY),

	/**
	 * 周三
	 */
	WEDNESDAY(Calendar.WEDNESDAY),

	/**
	 * 周四
	 */
	THURSDAY(Calendar.THURSDAY),

	/**
	 * 周五
	 */
	FRIDAY(Calendar.FRIDAY),

	/**
	 * 周六
	 */
	SATURDAY(Calendar.SATURDAY);

	/**
	 * 对应日历{@link java.util.Calendar}中的星期值。
	 */
	private final int value;

	/**
	 * 构造函数。
	 *
	 * @param value 对应日历{@link java.util.Calendar}中的星期值。
	 */
	Week(int value) {
		this.value = value;
	}

	/**
	 * 将日历{@link java.util.Calendar}星期相关值转换为星期枚举对象。<br>
	 *
	 * @param day 日历{@link java.util.Calendar}类中星期值，1表示星期日。
	 * @return 星期枚举对象。
	 */
	public static Week of(int day) {
		switch (day) {
			case Calendar.SUNDAY:
				return SUNDAY;
			case Calendar.MONDAY:
				return MONDAY;
			case Calendar.TUESDAY:
				return TUESDAY;
			case Calendar.WEDNESDAY:
				return WEDNESDAY;
			case Calendar.THURSDAY:
				return THURSDAY;
			case Calendar.FRIDAY:
				return FRIDAY;
			case Calendar.SATURDAY:
				return SATURDAY;
			default:
				throw new IllegalArgumentException("day of week must be between 1-7.");
		}
	}

	/**
	 * 获得对应日历{@link java.util.Calendar}中的星期值。
	 *
	 * @return 星期值。
	 */
	public int getValue() {
		return value;
	}

	/**
	 * 获取当前星期枚举的中文名。
	 *
	 * @param prefix 星期的前缀，例如前枚举为"MONDAY"，前缀为"星期"时则返回"星期一"；前缀为"周"时返回"周一"。
	 * @return 当前星期枚举的中文名。
	 */
	public String getChnName(String prefix) {
		if (null == prefix) {
			throw new IllegalArgumentException("prefix is null.");
		}
		switch (this) {
			case SUNDAY:
				return prefix + "日";
			case MONDAY:
				return prefix + "一";
			case TUESDAY:
				return prefix + "二";
			case WEDNESDAY:
				return prefix + "三";
			case THURSDAY:
				return prefix + "四";
			case FRIDAY:
				return prefix + "五";
			case SATURDAY:
				return prefix + "六";
			default:
				return null;
		}
	}

	/**
	 * 获取当前星期枚举的中文名。
	 *
	 * @return 当前星期枚举的中文名。
	 */
	public String getChnName() {
		return getChnName("星期");
	}

}
