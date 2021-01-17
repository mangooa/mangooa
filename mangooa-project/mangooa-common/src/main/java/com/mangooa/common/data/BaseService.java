package com.mangooa.common.data;

import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;

/**
 * 数据服务接口实现类。
 *
 * @param <DAO> 数据访问对象类型。
 * @param <DO>  数据对象类型。
 * @param <ID>  数据对象唯一标识类型。
 * @author Weimin Gao
 * @since 1.0.0
 **/
@SuppressWarnings("unused")
public abstract class BaseService<DAO extends Dao<DO, ID>, DO extends DataObject<ID>, ID extends Serializable> implements Service<DAO, DO, ID> {

	@Autowired(required = false)
	private DAO dao;

	@Override
	public DAO getDao() {
		return dao;
	}

	/**
	 * 设置数据访问对象。
	 *
	 * @param dao 数据访问对象。
	 */
	protected void setDao(DAO dao) {
		this.dao = dao;
	}
}
