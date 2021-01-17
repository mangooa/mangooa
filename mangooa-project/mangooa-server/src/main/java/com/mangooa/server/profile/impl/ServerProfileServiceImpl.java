package com.mangooa.server.profile.impl;

import com.mangooa.data.jpa.BaseJpaServiceStringId;
import com.mangooa.server.profile.ServerProfileEntity;
import com.mangooa.server.profile.ServerProfileRepository;
import com.mangooa.server.profile.ServerProfileService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author Weimin Gao
 * @since 1.0.0
 **/
@Slf4j
@Service
public class ServerProfileServiceImpl extends BaseJpaServiceStringId<ServerProfileRepository, ServerProfileEntity> implements ServerProfileService {



}
