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
	 * 返回数据对象所属的租户。
	 *
	 * @return 租户名称。
	 */
	String getTenant();

	/**
	 * 返回数据对象的唯一标识。
	 *
	 * @return 唯一标识。
	 */
	ID getId();

	/**
	 * 设置数据对象的唯一标识。
	 *
	 * @param id 唯一标识。
	 */
	void setId(ID id);

	/**
	 * 返回数据对象创建的时间。
	 *
	 * @return 创建时间。
	 */
	Date getCreateTime();

	/**
	 * 返回数据对象创建者的账号。
	 *
	 * @return 创建者账号。
	 */
	String getCreator();

	/**
	 * 返回数据对象最后更新的时间。
	 *
	 * @return 最后更新时间。
	 */
	Date getUpdateTime();

	/**
	 * 返回数据对象最后更新者的账号。
	 *
	 * @return 最后更新者账号。
	 */
	String getUpdator();

	/**
	 * 返回数据对象更新的版本，用于实现乐观锁。
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

	/**
	 * <pre>
	 * 返回对象可阅读者列表。
	 * 说明
	 * 1：保存值可以为用户账号、群组代码，使用英文[]进行包裹。
	 * 2：保存值用户账号需加前缀：U_，例如：[U_ADMIN]，表示是管理员。
	 * 3：保存值群组代码需加前缀：G_，例如：[G_ADMIN]，表示是管理员组。
	 * 4：保存值为多值时用英文分号+英文空格进行分隔，例如：[U_ADMIN]; [G_ADMIN]。
	 * </pre>
	 *
	 * @return 可阅读者列表。
	 */
	String getReaders();

	/**
	 * <pre>
	 * 返回对象可编辑者列表。
	 * 说明
	 * 1：保存值可以为用户账号、群组代码，使用英文[]进行包裹。
	 * 2：保存值用户账号需加前缀：U_，例如：[U_ADMIN]，表示是管理员。
	 * 3：保存值群组代码需加前缀：G_，例如：[G_ADMIN]，表示是管理员组。
	 * 4：保存值为多值时用英文分号+英文空格进行分隔，例如：[U_ADMIN]; [G_ADMIN]。
	 * </pre>
	 *
	 * @return 可编辑者列表。
	 */
	String getAuthors();
}
