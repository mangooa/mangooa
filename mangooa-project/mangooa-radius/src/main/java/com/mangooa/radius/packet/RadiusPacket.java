package com.mangooa.radius.packet;

import com.mangooa.radius.attribute.RadiusAttribute;

import java.util.ArrayList;
import java.util.List;

/**
 * 远程认证拨号用户服务数据包（以下简称”数据包“），子类可以继承此类表示一种对应具体服务的数据包。
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
	private RadiusPacketType packetType = RadiusPacketType.UNDEFINED;

	/**
	 * 数据包的标识符。
	 */
	private int packetIdentifier = 0;

	/**
	 * 数据包的属性。
	 */
	private final List<RadiusAttribute> attributes =  new ArrayList<>();


}
