package com.mangooa.common.crypto.digest;

import com.mangooa.common.core.lang.ArrayUtil;
import com.mangooa.common.core.lang.CharsetUtil;
import com.mangooa.common.core.lang.StringUtil;
import com.mangooa.common.crypto.CryptoException;
import com.mangooa.common.crypto.SecurityUtil;

import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import java.util.Objects;

/**
 * 摘要编码器。
 *
 * @author Weimin Gao
 * @see java.security.MessageDigest
 * @since 1.0.0
 **/
@SuppressWarnings("unused")
public class DigestEncoder {

	private MessageDigest digest;

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
	public DigestEncoder(DigestAlgorithm algorithm) {
		this(algorithm.value(), null);
	}

	/**
	 * 构造函数。
	 *
	 * @param algorithm 摘要算法，使用jdk provider。
	 */
	public DigestEncoder(String algorithm) {
		this(algorithm, null);
	}

	/**
	 * 构造函数。
	 *
	 * @param algorithm 摘要算法。
	 * @param provider  摘要算法算法提供者，此参数为{@code null}时使用jdk provider。
	 */
	public DigestEncoder(DigestAlgorithm algorithm, Provider provider) {
		init(algorithm.value(), provider);
	}

	/**
	 * 构造函数。
	 *
	 * @param algorithm 摘要算法。
	 * @param provider  摘要算法算法提供者，此参数为{@code null}时使用jdk provider。
	 */
	public DigestEncoder(String algorithm, Provider provider) {
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
			this.digest = SecurityUtil.createMessageDigest(algorithm);
		} else {
			try {
				this.digest = MessageDigest.getInstance(algorithm, provider);
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
	public DigestEncoder setSalt(byte[] salt) {
		this.salt = salt;
		return this;
	}

	/**
	 * 设置加盐的位置，盐值存在时（即不为null或空数组时）有效。<br/>
	 *
	 * @param saltPosition 盐值插入的位置。
	 * @return 当前对象。
	 */
	public DigestEncoder setSaltPosition(int saltPosition) {
		this.saltPosition = saltPosition;
		return this;
	}

	/**
	 * 设置重复计算摘要值次数。
	 *
	 * @param digestCount 摘要值次数。
	 * @return 当前对象。
	 */
	public DigestEncoder setDigestCount(int digestCount) {
		this.digestCount = digestCount;
		return this;
	}

	/**
	 * 重置内置摘要对象{@link MessageDigest}。
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
		if (ArrayUtil.isEmpty(this.salt)) {
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

	/**
	 * 将给定的字符串进行摘要加密，返回加密后字节数组。
	 *
	 * @param data    给定的字符串。
	 * @param charset 给定的字符串字符集。
	 * @return 字节数组。
	 */
	public byte[] digest(String data, Charset charset) {
		return digest(StringUtil.toBytes(data, charset));
	}

	/**
	 * 将给定的字符串进行摘要加密，返回加密后的字节数组。
	 *
	 * @param data    给定的字符串。
	 * @param charset 给定的字符串字符集。
	 * @return 加密后的字节数组。
	 */
	public byte[] digest(String data, String charset) {
		return digest(data, CharsetUtil.charset(charset));
	}

}
