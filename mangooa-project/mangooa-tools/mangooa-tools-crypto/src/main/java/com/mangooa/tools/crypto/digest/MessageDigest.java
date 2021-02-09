package com.mangooa.tools.crypto.digest;

import com.mangooa.tools.core.io.FileUtils;
import com.mangooa.tools.core.io.IoException;
import com.mangooa.tools.core.io.IoUtils;
import com.mangooa.tools.core.lang.ArrayUtils;
import com.mangooa.tools.core.lang.CharsetUtils;
import com.mangooa.tools.core.lang.StringUtils;
import com.mangooa.tools.core.util.HexUtils;
import com.mangooa.tools.crypto.CryptoException;
import com.mangooa.tools.crypto.SecurityUtils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import java.util.Objects;

/**
 * 消息摘要。
 *
 * @author Weimin Gao
 * @see java.security.MessageDigest
 * @since 1.0.0
 **/
@SuppressWarnings("unused")
class MessageDigest {

	private java.security.MessageDigest digest;

	/**
	 * 盐值。
	 */
	protected byte[] salt;

	/**
	 * 加盐位置，默认0。
	 */
	protected int saltPosition = 0;

	/**
	 * 散列次数，默认1。
	 */
	protected int digestCount = 1;

	/**
	 * 构造函数，使用JDK实现。
	 *
	 * @param algorithm 算法。
	 */
	public MessageDigest(DigestAlgorithm algorithm) {
		this(algorithm.value(), null);
	}

	/**
	 * 构造函数。
	 *
	 * @param algorithm 摘要算法，使用jdk provider。
	 */
	public MessageDigest(String algorithm) {
		this(algorithm, null);
	}

	/**
	 * 构造函数。
	 *
	 * @param algorithm 摘要算法。
	 * @param provider  摘要算法算法提供者，此参数为{@code null}时使用jdk provider。
	 */
	public MessageDigest(DigestAlgorithm algorithm, Provider provider) {
		init(algorithm.value(), provider);
	}

	/**
	 * 构造函数。
	 *
	 * @param algorithm 摘要算法。
	 * @param provider  摘要算法算法提供者，此参数为{@code null}时使用jdk provider。
	 */
	public MessageDigest(String algorithm, Provider provider) {
		init(algorithm, provider);
	}

	/**
	 * 初始化摘要编码器对象。
	 *
	 * @param algorithm 摘要算法。
	 * @param provider  摘要算法提供者，此参数为{@code null}时使用jdk provider。
	 */
	public void init(String algorithm, Provider provider) {
		if (Objects.isNull(provider)) {
			this.digest = SecurityUtils.createMessageDigest(algorithm);
		} else {
			try {
				this.digest = java.security.MessageDigest.getInstance(algorithm, provider);
			} catch (NoSuchAlgorithmException e) {
				throw new CryptoException(e);
			}
		}
	}

	/**
	 * 设置加盐混淆。
	 *
	 * @param salt 盐值。
	 * @return 当前对象。
	 */
	public MessageDigest setSalt(byte[] salt) {
		this.salt = salt;
		return this;
	}

	/**
	 * 设置加盐的位置，盐值存在时（即不为null或空数组时）有效。<br/>
	 *
	 * @param saltPosition 盐值插入的位置。
	 * @return 当前对象。
	 */
	public MessageDigest setSaltPosition(int saltPosition) {
		this.saltPosition = saltPosition;
		return this;
	}

	/**
	 * 设置重复计算摘要值次数。
	 *
	 * @param digestCount 摘要值次数。
	 * @return 当前对象。
	 */
	public MessageDigest setDigestCount(int digestCount) {
		this.digestCount = digestCount;
		return this;
	}

	/**
	 * 重置内置摘要对象{@link java.security.MessageDigest}。
	 */
	public void reset() {
		this.digest.reset();
	}

	/**
	 * 将给定的字节数组进行摘要加密（使用了加盐和重复摘要次数），返回加密后的字节数组。
	 *
	 * @param data 给定的字节数组。
	 * @return 加密后的字节数组。
	 */
	public byte[] digest(byte[] data) {
		byte[] ret;
		if (ArrayUtils.isEmpty(this.salt)) {
			// 无加盐
			ret = digest0(data);
		} else if (this.saltPosition <= 0) {
			// 加盐在开头
			ret = digest0(this.salt, data);
		} else if (this.saltPosition >= data.length) {
			// 加盐在末尾
			ret = digest0(data, this.salt);
		} else {
			// 加盐在中间
			this.digest.update(data, 0, this.saltPosition);
			this.digest.update(this.salt);
			this.digest.update(data, this.saltPosition, data.length - this.saltPosition);
			ret = this.digest.digest();
		}
		return digest1(ret);
	}

	/**
	 * 将给定的字符串进行摘要加密，返回加密后字节数组。
	 *
	 * @param data    给定的字符串。
	 * @param charset 给定的字符串字符集。
	 * @return 字节数组。
	 */
	public byte[] digest(String data, Charset charset) {
		return digest(StringUtils.toBytes(data, charset));
	}

	/**
	 * 将给定的字符串进行摘要加密，返回加密后的字节数组。
	 *
	 * @param data    给定的字符串。
	 * @param charset 给定的字符串字符集。
	 * @return 加密后的字节数组。
	 */
	public byte[] digest(String data, String charset) {
		return digest(data, CharsetUtils.charset(charset));
	}


	/**
	 * 将给定的数据进行摘要加密转换为十六进制摘要字符串。
	 *
	 * @param data    给定的数据。
	 * @param charset 给定的数据的编码。
	 * @return 十六进制摘要字符串。
	 */
	public String digestHex(String data, Charset charset) {
		return HexUtils.encodeHexStr(digest(data, charset));
	}

	/**
	 * 将给定的数据进行摘要加密转换为十六进制摘要字符串。
	 *
	 * @param data    给定的数据。
	 * @param charset 给定的数据的编码。
	 * @return 十六进制摘要字符串。
	 */
	public String digestHex(String data, String charset) {
		return digestHex(data, CharsetUtils.charset(charset));
	}

	/**
	 * 将给定的数据进行摘要加密转换为十六进制摘要字符串。
	 *
	 * @param data 给定的数据。
	 * @return 十六进制摘要字符串。
	 */
	public String digestHex(String data) {
		return digestHex(data, CharsetUtils.UTF_8);
	}

	/**
	 * 将给定的字节数组进行摘要加密转换为十六进制摘要字符串。
	 *
	 * @param data 给定的字节数组。
	 * @return 十六进制摘要字符串。
	 */
	public String digestHex(byte[] data) {
		return HexUtils.encodeHexStr(digest(data));
	}


	/**
	 * 生成摘要。
	 *
	 * @param data         {@link InputStream}数据流。
	 * @param bufferLength 缓存长度，不足1使用{@link IoUtils#DEFAULT_BUFFER_SIZE}做为默认值。
	 * @return 摘要bytes。
	 * @throws IoException 如果执行摘要计算发生错误时。
	 */
	public byte[] digest(InputStream data, int bufferLength) throws IoException {
		if (bufferLength < 1) {
			bufferLength = IoUtils.DEFAULT_BUFFER_SIZE;
		}
		byte[] result;
		try {
			if (ArrayUtils.isEmpty(this.salt)) {
				result = digestWithoutSalt(data, bufferLength);
			} else {
				result = digestWithSalt(data, bufferLength);
			}
		} catch (IOException e) {
			throw new IoException(e);
		}
		return resetAndRepeatDigest(result);
	}

	/**
	 * 生成摘要，并转为16进制字符串。<br>
	 * 使用默认缓存大小，见{@link IoUtils#DEFAULT_BUFFER_SIZE}。
	 *
	 * @param data         被摘要数据。
	 * @param bufferLength 缓存长度，不足1使用{@link IoUtils#DEFAULT_BUFFER_SIZE}做为默认值。
	 * @return 摘要s
	 */
	public String digestHex(InputStream data, int bufferLength) {
		return HexUtils.encodeHexStr(digest(data, bufferLength));
	}

	/**
	 * 生成摘要，使用默认缓存大小，见 {@link IoUtils#DEFAULT_BUFFER_SIZE}。
	 *
	 * @param data {@link InputStream}数据流。
	 * @return 摘要bytes。
	 */
	public byte[] digest(InputStream data) {
		return digest(data, IoUtils.DEFAULT_BUFFER_SIZE);
	}

	/**
	 * 生成摘要，并转为16进制字符串。<br>
	 * 使用默认缓存大小，见 {@link IoUtils#DEFAULT_BUFFER_SIZE}。
	 *
	 * @param data 被摘要数据。
	 * @return 摘要。
	 */
	public String digestHex(InputStream data) {
		return HexUtils.encodeHexStr(digest(data));
	}

	/**
	 * 生成文件摘要。<br>
	 * 使用默认缓存大小，见{@link IoUtils#DEFAULT_BUFFER_SIZE}。
	 *
	 * @param file 被摘要文件。
	 * @return 摘要bytes。
	 * @throws CryptoException 如果执行摘要计算发生错误时。
	 */
	public byte[] digest(File file) throws CryptoException {
		InputStream in = null;
		try {
			in = FileUtils.getInputStream(file);
			return digest(in);
		} finally {
			IoUtils.close(in);
		}
	}

	/**
	 * 生成文件摘要，并转为16进制字符串。<br>
	 * 使用默认缓存大小，见{@link IoUtils#DEFAULT_BUFFER_SIZE}。
	 *
	 * @param file 被摘要文件。
	 * @return 摘要。
	 */
	public String digestHex(File file) {
		return HexUtils.encodeHexStr(digest(file));
	}

	//-----------------------------------------------------------------------------------------------------------------

	/**
	 * 生成摘要。
	 *
	 * @param data         {@link InputStream}数据流。
	 * @param bufferLength 缓存长度，不足1使用{@link IoUtils#DEFAULT_BUFFER_SIZE}做为默认值。
	 * @return 摘要bytes。
	 * @throws IOException 如果从流中读取数据引发的错误时。
	 */
	private byte[] digestWithoutSalt(InputStream data, int bufferLength) throws IOException {
		final byte[] buffer = new byte[bufferLength];
		int read;
		while ((read = data.read(buffer, 0, bufferLength)) > -1) {
			this.digest.update(buffer, 0, read);
		}
		return this.digest.digest();
	}

	/**
	 * 生成摘要。
	 *
	 * @param data         {@link InputStream}数据流。
	 * @param bufferLength 缓存长度，不足1使用{@link IoUtils#DEFAULT_BUFFER_SIZE}做为默认值。
	 * @return 摘要bytes。
	 * @throws IOException 如果从流中读取数据引发的错误时。
	 */
	private byte[] digestWithSalt(InputStream data, int bufferLength) throws IOException {
		if (this.saltPosition <= 0) {
			// 加盐在开头
			this.digest.update(this.salt);
		}
		final byte[] buffer = new byte[bufferLength];
		int total = 0;
		int read;
		while ((read = data.read(buffer, 0, bufferLength)) > -1) {
			total += read;
			if (this.saltPosition > 0 && total >= this.saltPosition) {
				if (total != this.saltPosition) {
					digest.update(buffer, 0, total - this.saltPosition);
				}
				// 加盐在中间
				this.digest.update(this.salt);
				this.digest.update(buffer, total - this.saltPosition, read);
			} else {
				this.digest.update(buffer, 0, read);
			}
		}
		if (total < this.saltPosition) {
			// 加盐在末尾
			this.digest.update(this.salt);
		}
		return this.digest.digest();
	}

	/**
	 * 重复计算摘要，取决于{@link #digestCount}值。<br>
	 * 每次计算摘要前都会重置{@link #digest}。
	 *
	 * @param digestData 第一次摘要过的数据。
	 * @return 摘要。
	 */
	private byte[] resetAndRepeatDigest(byte[] digestData) {
		final int digestCount = Math.max(1, this.digestCount);
		reset();
		for (int i = 0; i < digestCount - 1; i++) {
			digestData = digest1(digestData);
			reset();
		}
		return digestData;
	}

	private byte[] digest0(byte[]... data) {
		for (byte[] element : data) {
			if (null != element) {
				this.digest.update(element);
			}
		}
		return this.digest.digest();
	}

	private byte[] digest1(byte[] data) {
		final int digestCount = Math.max(1, this.digestCount);
		reset();
		for (int i = 0; i < digestCount - 1; i++) {
			data = digest0(data);
			reset();
		}
		return data;
	}
	//-----------------------------------------------------------------------------------------------------------------
}
