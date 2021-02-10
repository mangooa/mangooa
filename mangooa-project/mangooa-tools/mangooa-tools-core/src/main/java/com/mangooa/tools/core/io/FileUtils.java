package com.mangooa.tools.core.io;

import com.mangooa.tools.core.io.file.PathUtils;

import java.io.BufferedInputStream;
import java.io.File;

/**
 *
 * @author Weimin Gao
 * @since 1.0.0
 **/
public class FileUtils extends PathUtils {

	/**
	 * 获得输入流。
	 *
	 * @param file 文件。
	 * @return 输入流。
	 * @throws IoException 如果读取文件发生错误时。
	 */
	public static BufferedInputStream getInputStream(File file) throws IoException {
		return IoUtils.toBuffered(IoUtils.toStream(file));
	}

//	/**
//	 * 获得输入流。
//	 *
//	 * @param path 文件路径。
//	 * @return 输入流。
//	 * @throws IoException 如果文件未找到时
//	 */
//	public static BufferedInputStream getInputStream(String path) throws IoException {
//		return getInputStream(file(path));
//	}

}
