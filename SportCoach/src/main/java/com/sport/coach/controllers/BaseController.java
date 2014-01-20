package com.sport.coach.controllers;

import com.sport.coach.domain.user.Role;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 *
 * @author luku00
 */
public abstract class BaseController {

    /**
     * will load logged user from security context
     *
     * @return actually logged userName
     */
    protected String getLoggedUserName() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return auth.getName(); //get logged in username
    }

    protected Role gelLoggedUserRole() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return Role.valueOf(auth.getAuthorities().iterator().next().getAuthority());
    }
}
