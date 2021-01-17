package com.mangooa.server.tenant;

import com.mangooa.data.jpa.JpaRepositoryStringId;
import org.springframework.stereotype.Repository;

/**
 * @author Weimin Gao
 * @since 1.0.0
 **/
@Repository
public interface TenantRepository extends JpaRepositoryStringId<TenantEntity> {
}
