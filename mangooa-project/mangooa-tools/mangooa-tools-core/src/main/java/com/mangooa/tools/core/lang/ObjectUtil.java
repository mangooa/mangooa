package com.mangooa.tools.core.lang;

/**
 * 对象工具类。
 *
 * @author Weimin Gao
 * @since 1.0.0
 **/
@SuppressWarnings("unused")
public class ObjectUtil {

	/**
	 * 检查给定的对象为{@code null}时返回默认值，否则返回给定的对象。<br/>
	 * 例子：<br/>
	 * <ol>
	 * 	<li>defaultIfNull(null, null)=null</li>
	 * 	<li>defaultIfNull(null, "")=""</li>
	 * 	<li>defaultIfNull("", "bb")=""</li>
	 * 	<li>defaultIfNull(" ", "bb")=" "</li>
	 * 	<li>defaultIfNull("aa", "bb")="aa"</li>
	 * </ol>
	 *
	 * @param object       给定的对象。
	 * @param defaultValue 默认值。
	 * @param <T>          给定的对象的类型。
	 * @return 默认值，如果给定的对象为{@code null}时。
	 */
	public static <T> T defaultIfNull(final T object, final T defaultValue) {
		return (null != object) ? object : defaultValue;
	}


	/**
	 * 检查给定的对象为{@code null}或者""时返回默认值，否则返回给定的对象。<br/>
	 * 例子：<br/>
	 * <ol>
	 * 	<li>defaultIfEmpty(null, null)=null</li>
	 * 	<li>defaultIfEmpty(null, "")=""</li>
	 * 	<li>defaultIfEmpty("", "bb")="bb"</li>
	 * 	<li>defaultIfEmpty(" ", "bb")=" "</li>
	 * 	<li>defaultIfEmpty("aa", "bb")="aa"</li>
	 * </ol>
	 *
	 * @param str          给定的对象。
	 * @param defaultValue 默认值。
	 * @param <T>          给定的对象的类型。
	 * @return 默认值，如果给定的对象为{@code null}或者""时。
	 */
	public static <T extends CharSequence> T defaultIfEmpty(final T str, final T defaultValue) {
		return StringUtil.isEmpty(str) ? defaultValue : str;
	}

	/**
	 * 检查给定的对象为{@code null}或者""或者空白字符时返回默认值，否则返回给定的对象。<br/>
	 * 例子：<br/>
	 * <ol>
	 * 	<li>defaultIfBlank(null, null)=null</li>
	 * 	<li>defaultIfBlank(null, "")=""</li>
	 * 	<li>defaultIfBlank("", "bb")=""</li>
	 * 	<li>defaultIfBlank(" ", "bb")="bb"</li>
	 * 	<li>defaultIfBlank("aa", "bb")="aa"</li>
	 * </ol>
	 *
	 * @param object       给定的对象。
	 * @param defaultValue 默认值。
	 * @param <T>          给定的对象的类型。
	 * @return 默认值, 如果给定的对象为{@code null}或者""或者空白字符时。
	 */
	public static <T extends CharSequence> T defaultIfBlank(final T object, final T defaultValue) {
		return StringUtil.isBlank(object) ? defaultValue : object;
	}

}
