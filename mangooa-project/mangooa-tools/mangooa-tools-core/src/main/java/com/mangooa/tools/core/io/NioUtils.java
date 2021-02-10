package com.mangooa.tools.core.io;

/**
 * NIO相关工具封装，主要针对Channel读写、拷贝等封装。
 *
 * @author Weimin Gao
 * @since 1.0.0
 **/
public class NioUtils {

	/**
	 * 默认缓存大小8192个字节8K。
	 */
	public static final int DEFAULT_BUFFER_SIZE = 8192;

	/**
	 * 数据流末尾。
	 */
	public static final int EOF = -1;
}
