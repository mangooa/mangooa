package com.mangooa.platform.role;

import com.mangooa.data.jpa.BaseJpaServiceStringId;
import org.springframework.stereotype.Service;

/**
 * @author Weimin Gao
 * @since 1.0.0
 **/
@Service
public class RoleServiceImpl extends BaseJpaServiceStringId<RoleRepository, RoleEntity> implements RoleService {

}
