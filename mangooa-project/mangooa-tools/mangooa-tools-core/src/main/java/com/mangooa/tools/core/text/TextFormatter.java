package com.mangooa.tools.core.text;

import com.mangooa.tools.core.lang.ArrayUtils;
import com.mangooa.tools.core.lang.StringUtils;

/**
 * 文本格式化工具类。
 *
 * @author Weimin Gao
 * @since 1.0.0
 **/
public class TextFormatter {

	/**
	 * 占位符：{}。
	 */
	public static final String PLACEHOLDER = "{}";

	/**
	 * 将给定的消息根据占位符{}按照顺序替换为对应的值，返回格式后的字符串。<br/>
	 * 如果给定的消息模板为{@code null}时，则返回"null"字符串。<br/>
	 * 如果综合的参数数据为{@code null}或空时，则返回给定的消息模板。<br/>
	 * 如果想输出{}使用\\转义{即可，如果想输出{}之前的\使用双转义符\\\\即可。<br/>
	 * 例如：<br/>
	 * <ol>
	 *     <li>通常使用：format("this is {} for {}", "a", "b") =》 this is a for b</li>
	 *     <li>转义{}： format("this is \\{} for {}", "a", "b") =》 this is \{} for a</li>
	 *     <li>转义\： format("this is \\\\{} for {}", "a", "b") =》 this is \a for b</li>
	 * </ol>
	 *
	 * @param msg    给定的消息。
	 * @param params 给定的消息占位符替换的值。
	 * @return 格式化后的消息。
	 */
	protected static String format(final String msg, final Object... params) {
		if (StringUtils.isBlank(msg) || ArrayUtils.isEmpty(params)) {
			return msg;
		}
		final int length = msg.length() + params.length;
		// 设置缓存大小提高性能
		StringBuilder builder = new StringBuilder(length);
		// 记录已经处理到的位置
		int position = 0;
		// 占位符所在位置
		int index;
		for (int idx = 0; idx < params.length; idx++) {
			index = msg.indexOf(PLACEHOLDER, position);
			// 剩余部分无占位符
			if (index == -1) {
				// 不带占位符的模板直接返回
				if (position == 0) {
					return msg;
				}
				// 字符串模板剩余部分不再包含占位符，加入剩余部分后返回结果
				builder.append(msg, position, length);
				return builder.toString();
			}
			// 转义符
			if (index > 0 && msg.charAt(index - 1) == StringUtils.BACKSLASH) {
				if (index > 1 && msg.charAt(index - 2) == StringUtils.BACKSLASH) {
					// 转义符之前还有一个转义符，占位符依旧有效
					builder.append(msg, position, index - 1);
					builder.append(StringUtils.toString(params[idx]));
					position = index + 2;
				} else {
					// 占位符被转义
					idx--;
					builder.append(msg, position, index - 1);
					builder.append(StringUtils.BRACE_START);
					position = index + 1;
				}
			} else {// 正常占位符
				builder.append(msg, position, index);
				builder.append(StringUtils.toString(params[idx]));
				position = index + 2;
			}
		}
		// 加入最后一个占位符后所有的字符
		builder.append(msg, position, msg.length());
		return builder.toString();
	}
}
