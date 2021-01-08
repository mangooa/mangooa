package com.mangooa.common.data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Weimin Gao
 * @since 1.0.0
 **/
public interface Entity<ID extends Serializable> extends DataObject<ID> {

	/**
	 * 返回对象创建时间。
	 *
	 * @return 对象创建时间。
	 */
	Date getCreated();

	/**
	 * 返回对象最后更新时间。
	 *
	 * @return 对象最后更新时间。
	 */
	Date getUpdated();

}
