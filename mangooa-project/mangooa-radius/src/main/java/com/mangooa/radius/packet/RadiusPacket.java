package com.mangooa.radius.packet;

import com.mangooa.radius.attribute.RadiusAttribute;

import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

/**
 * 远程认证拨号用户服务数据包（以下简称数据包），子类可以继承此类表示一种对应具体服务的数据包。
 *
 * @author Weimin Gao
 * @see AccessRequest
 * @see AccessAccept
 * @see AccountingRequest
 * @see CoaRequest
 * @since 1.0.0
 **/
public class RadiusPacket {

	/**
	 * 1 接入请求
	 */
	public static final int ACCESS_REQUEST = 1;

	/**
	 * 2 接入允许
	 */
	public static final int ACCESS_ACCEPT = 2;

	/**
	 * 3 接入拒绝
	 */
	public static final int ACCESS_REJECT = 3;

	/**
	 * 4 计费请求
	 */
	public static final int ACCOUNTING_REQUEST = 4;

	/**
	 * 5 计费响应
	 */
	public static final int ACCOUNTING_RESPONSE = 5;

	/**
	 * 11 接入询问
	 */
	public static final int ACCESS_CHALLENGE = 11;

	/**
	 * 12 服务器状态
	 */
	public static final int STATUS_SERVER = 12;

	/**
	 * 13 客户端状态
	 */
	public static final int STATUS_CLIENT = 13;

	/**
	 * 255 保留
	 */
	public static final int RESERVED = 255;

	/**
	 * 0 未定义
	 */
	public static final int UNDEFINED = 0;

	/**
	 * 数据包最小长度为20个字节。
	 */
	public static final int PACKET_MIN_LENGTH = 20;

	/**
	 * 数据包最大长度为4096个字节。
	 */
	public static final int PACKET_MAX_LENGTH = 4096;

	/**
	 * 数据包类型1字节。
	 */
	private int type = UNDEFINED;

	/**
	 * 数据包标识符1字节，用于匹配请求包和响应包，同一组请求包和响应包的Identifier应相同。
	 */
	private int identifier = 0;

	/**
	 * 数据包验证字16字节，用于对数据包进行签名。
	 */
	private byte[] authenticator = null;

	/**
	 * 数据包属性。
	 */
	private final List<RadiusAttribute> attributes = new ArrayList<>();


	/**
	 * 获取下一个发送的数据包标识符，返回值在[1-255]之间。
	 *
	 * @return 下一个发送的数据包标识符。
	 */
	public static synchronized int getNextIdentifier() {
		nextId++;
		if (nextId > INT_255) {
			nextId = 0;
		}
		return nextId;
	}

	/**
	 * 下一个发送的数据包标识符。
	 */
	private static int nextId = 0;

	/**
	 * 常量整型255。
	 */
	private static final int INT_255 = 255;

	/**
	 * MD5摘要。
	 */
	private MessageDigest md5Digest = null;

	/**
	 * 随机数生成器。
	 */
	private static SecureRandom random = new SecureRandom();

}
