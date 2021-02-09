package com.mangooa.tools.core.io;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * @author Weimin Gao
 * @since 1.0.0
 **/
public class FileUtils {

	/**
	 * 获得输入流。
	 *
	 * @param file 文件。
	 * @return 输入流
	 * @throws IoException 如果文件未找到时。
	 */
	public static BufferedInputStream getInputStream(Path file) throws IoException {
		final InputStream in;
		try {
			in = Files.newInputStream(file);
		} catch (IOException e) {
			throw new IoException(e);
		}
		return IoUtils.toBuffered(in);
	}
}
