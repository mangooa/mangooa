package com.mangooa.tools.core.io.file;

import com.mangooa.tools.core.io.IoException;
import com.mangooa.tools.core.io.IoUtils;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * NIO中Path对象操作封装。
 *
 * @author Weimin Gao
 * @since 1.0.0
 **/
public class PathUtils {

	/**
	 * 获得输入流。
	 *
	 * @param path 文件路径。
	 * @return 输入流
	 * @throws IoException 如果读取文件发生错误时。
	 */
	public static BufferedInputStream getInputStream(Path path) throws IoException {
		final InputStream in;
		try {
			in = Files.newInputStream(path);
		} catch (IOException e) {
			throw new IoException(e);
		}
		return IoUtils.toBuffered(in);
	}

}
