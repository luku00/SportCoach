package com.sport.coach.domain.security;

import org.springframework.security.core.GrantedAuthority;

/**
 *
 * @author luku00
 */
public class Authority implements GrantedAuthority {

    private String authority;

    public Authority() {
    }

    public Authority(String authority) {
        this.authority = authority;
    }

    @Override
    public String getAuthority() {
        return authority;
    }

}
