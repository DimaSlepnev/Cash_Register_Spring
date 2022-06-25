package org.example.model;

import org.springframework.security.core.GrantedAuthority;

public enum Position implements GrantedAuthority {
    expert, senior_cashier, cashier;
    @Override
    public String getAuthority() {
        return name();
    }
}
