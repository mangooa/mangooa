package com.mangooa.common.crypto.digest;

import com.mangooa.common.crypto.CryptoException;

import java.security.Provider;

/**
 * 全局BouncyCastleProvider单例。
 *
 * @author Weimin Gao
 * @since 1.0.0
 **/
public enum GlobalBouncyCastleProvider {

	/**
	 * 实例。
	 */
	INSTANCE;

	private Provider provider;

	GlobalBouncyCastleProvider() {
		try {
			this.provider = ProviderFactory.createBouncyCastleProvider();
		} catch (CryptoException e) {
			// 忽略
		}
	}

	/**
	 * 获取BouncyCastleProvider实例，如果未引入BouncyCastle则返回null值。
	 *
	 * @return Provider接口实例。
	 * @see Provider
	 */
	public Provider getProvider() {
		return this.provider;
	}

}
