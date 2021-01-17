package com.mangooa.common.data;

import java.io.Serializable;

/**
 * 数据访问接口。
 *
 * @param <DO> 数据对象类型。
 * @param <ID> 数据对象唯一标识类型。
 * @author Weimin Gao
 * @since 1.0.0
 **/
@SuppressWarnings("unused")
public interface Dao<DO extends DataObject<ID>, ID extends Serializable> {

}
