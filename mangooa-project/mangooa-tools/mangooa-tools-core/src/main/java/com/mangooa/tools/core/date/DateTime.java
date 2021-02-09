package com.mangooa.tools.core.date;

import com.mangooa.tools.core.util.ObjectUtils;

import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/**
 * 日期时间，继承{@link java.util.Date}。
 *
 * @author Weimin Gao
 * @since 1.0.0
 **/
@SuppressWarnings("unused")
public class DateTime extends Date {

	private static final long serialVersionUID = 6037260821887166115L;

	/**
	 * 时区
	 */
	private TimeZone timeZone;

	/**
	 * 一周的第一天，默认是周一。
	 */
	private Week firstDayOfWeek = Week.MONDAY;

	/**
	 * 构造函数。
	 *
	 * @param timestamp 时间毫秒数。
	 * @param timeZone  时区。
	 */
	public DateTime(long timestamp, TimeZone timeZone) {
		super(timestamp);
		this.timeZone = (null == timeZone) ? TimeZone.getDefault() : timeZone;
	}

	/**
	 * 构造函数。
	 *
	 * @param date 日期。
	 */
	public DateTime(Date date) {
		this(date.getTime(), (date instanceof DateTime) ? ((DateTime) date).timeZone : TimeZone.getDefault());
	}

	/**
	 * 构造函数。
	 *
	 * @param date     日期。
	 * @param timeZone 时区。
	 */
	public DateTime(Date date, TimeZone timeZone) {
		this(date.getTime(), timeZone);
	}

	/**
	 * 构造函数。
	 *
	 * @param timestamp 时间戳。
	 */
	public DateTime(long timestamp) {
		this(timestamp, TimeZone.getDefault());
	}

	/**
	 * 创建日期时间对象。
	 *
	 * @param date 日期。
	 * @return 日期时间对象。
	 */
	public static DateTime of(Date date) {
		return (date instanceof DateTime) ? (DateTime) date : new DateTime(date);
	}

	/**
	 * 创建日期时间对象。
	 *
	 * @param timestamp 时间戳。
	 * @return 日期时间对象。
	 */
	public static DateTime of(long timestamp) {
		return new DateTime(timestamp);
	}

	/**
	 * 获得一周的第一天，默认为周一。
	 *
	 * @return 一周的第一天。
	 */
	public Week getFirstDayOfWeek() {
		return firstDayOfWeek;
	}

	/**
	 * 获取时区。
	 *
	 * @return 时区。
	 */
	public TimeZone getTimeZone() {
		return this.timeZone;
	}

	/**
	 * 获取时区ID。
	 *
	 * @return 时区ID。
	 */
	public ZoneId getZoneId() {
		return this.timeZone.toZoneId();
	}

	/**
	 * 获取日历{@link java.util.Calendar}对象根据当前日期时间对象。
	 *
	 * @param zone   设置新的时区。
	 * @param locale 设置新的区域。
	 * @return 日历对象。
	 */
	public Calendar toCalendar(TimeZone zone, Locale locale) {
		if (null == zone) {
			throw new IllegalArgumentException("zone is null.");
		}
		if (null == locale) {
			throw new IllegalArgumentException("locale is null.");
		}
		final Calendar cal = Calendar.getInstance(zone, locale);
		cal.setFirstDayOfWeek(this.firstDayOfWeek.getValue());
		cal.setTime(this);
		return cal;
	}

	/**
	 * 获取日历{@link java.util.Calendar}对象根据当前日期时间对象。
	 *
	 * @param locale 设置新的区域。
	 * @return 日历对象。
	 */
	public Calendar toCalendar(Locale locale) {
		return toCalendar(this.timeZone, locale);
	}

	/**
	 * 获取日历{@link java.util.Calendar}对象根据当前日期时间对象。
	 *
	 * @param zone 设置新的时区。
	 * @return 日历对象。
	 */
	public Calendar toCalendar(TimeZone zone) {
		return toCalendar(zone, Locale.getDefault(Locale.Category.FORMAT));
	}

	/**
	 * 获取日历{@link java.util.Calendar}对象根据当前日期时间对象。
	 *
	 * @return 日历对象。
	 */
	public Calendar toCalendar() {
		return toCalendar(Locale.getDefault(Locale.Category.FORMAT));
	}

	/**
	 * 设置一周的第一天。<br/>
	 * 备注：JDK中的日历{@link java.util.Calendar}中默认一周的第一天是周日，当前日期时间对象默认值设置为周一。</br>
	 * 设置一周的第一天主要影响{@link #weekOfMonth()}和{@link #weekOfYear()} 两个方法。
	 *
	 * @param firstDayOfWeek 一周的第一天。
	 * @return 当前对象。
	 * @see #weekOfMonth()
	 * @see #weekOfYear()
	 */
	public DateTime setFirstDayOfWeek(Week firstDayOfWeek) {
		this.firstDayOfWeek = firstDayOfWeek;
		return this;
	}

	/**
	 * 设置时区。
	 *
	 * @param timeZone 时区。
	 * @return 当前对象。
	 */
	public DateTime setTimeZone(TimeZone timeZone) {
		this.timeZone = ObjectUtils.defaultIfNull(timeZone, TimeZone.getDefault());
		return this;
	}

	/**
	 * 获取当前日期时间某个部分的值。
	 *
	 * @param field 日期时间字段。
	 * @return 当前日期时间某个部分的值，如：getField(DateTimeField.YEAR)返回当前日期时间对象中的年份。
	 */
	public int getField(DateTimeField field) {
		return getField(field.getValue());
	}

	/**
	 * 获取当前日期时间某个部分的值。
	 *
	 * @param field 日期时间字段对应日历{@link java.util.Calendar}中的值。
	 * @return 当前日期时间某个部分的值，如：getField(Calendar.YEAR)返回当前日期时间对象中的年份。
	 */
	public int getField(int field) {
		return toCalendar().get(field);
	}

	/**
	 * <pre>
	 * 获得当前日期时间所在年份的第几周。
	 * 此方法返回值与一周的第一天有关，比如：2020年1月2日为周日。
	 * 如果一周的第一天为周日，那这天是第二周（返回2）。
	 * 如果一周的第一天为周一，那这天是第一周（返回1）。
	 * 跨年的那个星期得到的结果总是1。
	 * </pre>
	 *
	 * @return 第几周。
	 * @see #setFirstDayOfWeek(Week)
	 */
	public int weekOfYear() {
		return getField(DateTimeField.WEEK_OF_YEAR);
	}

	/**
	 * <pre>
	 * 获得当前日期时间所在月份的第几周。
	 * 此方法返回值与一周的第一天有关，比如：2020年1月2日为周日。
	 * 如果一周的第一天为周日，那这天是第二周（返回2）。
	 * 如果一周的第一天为周一，那这天是第一周（返回1）。
	 * </pre>
	 *
	 * @return 第几周。
	 * @see #setFirstDayOfWeek(Week)
	 */
	public int weekOfMonth() {
		return getField(DateTimeField.WEEK_OF_MONTH);
	}

}
