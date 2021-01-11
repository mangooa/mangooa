package com.mangooa.radius.packet;

import com.mangooa.radius.attribute.RadiusAttribute;

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
	 * 数据包最小长度为20个字节。
	 */
	public static final int PACKET_MIN_LENGTH = 20;

	/**
	 * 数据包最大长度为4096个字节。
	 */
	public static final int PACKET_MAX_LENGTH = 4096;

	/**
	 * 数据包类型。
	 */
	private Type type = Type.UNDEFINED;

	/**
	 * 数据包的标识符。
	 */
	private int identifier = 0;

	/**
	 * 数据包的属性。
	 */
	private final List<RadiusAttribute> attributes =  new ArrayList<>();



	/**
	 * 远程认证拨号用户服务数据包类型枚举。
	 *
	 * @author Weimin Gao
	 * @since 1.0.0
	 **/
	public enum Type {

		/**
		 * 1 接入请求
		 */
		ACCESS_REQUEST(1, "接入请求"),

		/**
		 * 2 接入允许
		 */
		ACCESS_ACCEPT(2, "接入允许"),

		/**
		 * 3 接入拒绝
		 */
		ACCESS_REJECT(3, "接入拒绝"),

		/**
		 * 4 计费请求
		 */
		ACCOUNTING_REQUEST(4, "计费请求"),

		/**
		 * 5 计费响应
		 */
		ACCOUNTING_RESPONSE(5, "计费响应"),

		/**
		 * 11 接入询问
		 */
		ACCESS_CHALLENGE(11, "接入询问"),

		/**
		 * 12 服务器状态
		 */
		STATUS_SERVER(12, "服务器状态"),

		/**
		 * 13 客户端状态
		 */
		STATUS_CLIENT(13, "客户端状态"),

		/**
		 * 255 保留
		 */
		RESERVED(255, "保留"),

		/**
		 * 0 未定义
		 */
		UNDEFINED(0, "未定义");

		private int code;

		private String name;

		Type(int code, String name) {
			this.code = code;
			this.name = name;
		}

		public int getCode() {
			return code;
		}

		public String getName() {
			return name;
		}
	}


}
