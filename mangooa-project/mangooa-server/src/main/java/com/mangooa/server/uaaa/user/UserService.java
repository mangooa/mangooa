package com.mangooa.server.uaaa.user;

import com.mangooa.common.service.JpaServiceStringId;

/**
 * @author Weimin Gao
 * @since 1.0.0
 **/
public interface UserService extends JpaServiceStringId<UserRepository, UserEntity>, com.mangooa.uaaa.service.UserService {

}
