package com.mangooa.server.tenant.impl;

import com.mangooa.data.jpa.BaseJpaServiceStringId;
import com.mangooa.server.tenant.TenantEntity;
import com.mangooa.server.tenant.TenantRepository;
import com.mangooa.server.tenant.TenantService;
import org.springframework.stereotype.Service;

/**
 * @author Weimin Gao
 * @since 1.0.0
 **/
@Service
public class TenantServiceImpl extends BaseJpaServiceStringId<TenantRepository, TenantEntity> implements TenantService {

}
