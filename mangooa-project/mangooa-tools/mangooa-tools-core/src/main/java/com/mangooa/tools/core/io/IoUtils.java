package com.mangooa.tools.core.io;

import com.mangooa.tools.core.io.file.IoFileNotFoundException;

import java.io.*;

/**
 * @author Weimin Gao
 * @since 1.0.0
 **/
public class IoUtils extends NioUtils {

	/**
	 * 执行关闭，失败时不抛出异常。
	 *
	 * @param closeable 被关闭的对象。
	 */
	public static void close(Closeable closeable) {
		if (null != closeable) {
			try {
				closeable.close();
			} catch (Exception e) {
				// 忽略
			}
		}
	}

	/**
	 * 转换为{@link BufferedInputStream}。
	 *
	 * @param in {@link InputStream}。
	 * @return {@link BufferedInputStream}。
	 */
	public static BufferedInputStream toBuffered(InputStream in) {
		return (in instanceof BufferedInputStream) ? (BufferedInputStream) in : new BufferedInputStream(in);
	}

	/**
	 * 转换为{@link BufferedOutputStream}。
	 *
	 * @param out {@link OutputStream}。
	 * @return {@link BufferedOutputStream}。
	 */
	public static BufferedOutputStream toBuffered(OutputStream out) {
		return (out instanceof BufferedOutputStream) ? (BufferedOutputStream) out : new BufferedOutputStream(out);
	}

	/**
	 * 转为文件输入流。
	 *
	 * @param file 文件。
	 * @return {@link FileInputStream}。
	 * @throws IoFileNotFoundException 如果文件未找到时。
	 */
	public static FileInputStream toStream(File file) throws IoFileNotFoundException {
		try {
			return new FileInputStream(file);
		} catch (FileNotFoundException e) {
			throw new IoFileNotFoundException(e);
		}
	}
}
