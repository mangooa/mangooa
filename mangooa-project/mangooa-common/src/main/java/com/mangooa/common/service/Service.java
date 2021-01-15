package com.mangooa.common.service;

import com.mangooa.common.dao.Dao;
import com.mangooa.common.domain.DataObject;

import java.io.Serializable;

/**
 * 数据服务接口。
 *
 * @param <DAO> 数据访问对象类型。
 * @param <DO>  数据对象类型。
 * @param <ID>  数据对象唯一标识类型。
 * @author Weimin Gao
 * @since 1.0.0
 **/
public interface Service<DAO extends Dao<DO, ID>, DO extends DataObject<ID>, ID extends Serializable> {

	/**
	 * 获取数据访问对象。
	 *
	 * @return 数据访问对象。
	 */
	DAO getDao();

	/**
	 * 新建保存数据对象。
	 *
	 * @param object 数据对象。
	 * @return 数据对象。
	 */
	DO save(DO object);

	/**
	 * 编辑保存数据对象。
	 *
	 * @param object 数据对象。
	 * @return 数据对象。
	 */
	DO update(DO object);

}
