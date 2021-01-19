package com.mangooa.common.data;

import java.io.Serializable;
import java.util.Date;

/**
 * 数据对象接口。
 *
 * @param <ID> 对象唯一标识类型。
 * @author Weimin Gao
 * @since 1.0.0
 **/
@SuppressWarnings("unused")
public interface DataObject<ID extends Serializable> extends Serializable {

	/**
	 * 获取数据对象所属租户名称。
	 *
	 * @return 租户名称。
	 */
	String getTenant();

	/**
	 * 获取数据对象唯一标识。
	 *
	 * @return 唯一标识。
	 */
	ID getId();

	/**
	 * 设置对象唯一标识。
	 *
	 * @param id 唯一标识。
	 */
	void setId(ID id);

	/**
	 * 获取对象创建时间。
	 *
	 * @return 创建时间。
	 */
	Date getCreateTime();

	/**
	 * 获取对象创建者账号。
	 *
	 * @return 创建者账号。
	 */
	String getCreator();

	/**
	 * 获取对象最后更新时间。
	 *
	 * @return 最后更新时间。
	 */
	Date getUpdateTime();

	/**
	 * 获取对象最后更新者账号。
	 *
	 * @return 最后更新者账号。
	 */
	String getUpdator();

	/**
	 * 获取对象更新版本，用于实现乐观锁。
	 *
	 * @return 更新版本。
	 */
	Integer getVersion();

	/**
	 * 表示对象是否保存过。
	 *
	 * @return 真表示对象已经保存过。
	 */
	boolean isSaved();

	/**
	 * 表示对象是否可删除。
	 *
	 * @return 真表示可删除。
	 */
	boolean isDeletable();

	/**
	 * 表示对象是否可编辑。
	 *
	 * @return 真表示可编辑。
	 */
	boolean isEditable();
}
