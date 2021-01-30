package com.mangooa.common.spring.security.core.userdetails;

import com.mangooa.common.uaa.User;

/**
 * @author Weimin Gao
 * @since 1.0.0
 **/
@SuppressWarnings("unused")
public interface UserDetails extends User, org.springframework.security.core.userdetails.UserDetails {

}
