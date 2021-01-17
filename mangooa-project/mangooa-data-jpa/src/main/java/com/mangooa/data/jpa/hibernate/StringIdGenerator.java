package com.mangooa.data.jpa.hibernate;

import com.mangooa.data.jpa.BaseJpaEntityStringId;
import com.mangooa.tools.core.lang.ObjectId;
import com.mangooa.tools.core.lang.StringUtil;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import java.io.Serializable;

/**
 * 实体主键生成器。
 *
 * @author Weimin Gao
 * @since 1.0.0
 **/
@Slf4j
@SuppressWarnings("unused")
public class StringIdGenerator implements IdentifierGenerator {

	@Override
	public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
		String key = ObjectId.get().toHexString();
		if (object instanceof BaseJpaEntityStringId) {
			BaseJpaEntityStringId entity = (BaseJpaEntityStringId) object;
			String id = entity.getId();
			if (StringUtil.isBlank(id)) {
				id = key;
				entity.setId(id);
				log.info("generate entity {} primary key {} successfully", object.getClass().getName(), id);
			} else {
				key = id;
			}
		}
		return key;
	}
}
