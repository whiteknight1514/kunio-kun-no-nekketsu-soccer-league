package com.goal3.kuniokunnonekketsusoccerleague.security;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

//перечисление разрешений (Permission), каждое из которых связано по имени с полномочием (authority)
public enum Permission {

    WRITE,
    READ,
    GENERATE;

    private final SimpleGrantedAuthority authority;

    Permission() {
        this.authority = new SimpleGrantedAuthority(name());
    }

    public SimpleGrantedAuthority authority() {
        return this.authority;
    }
}
