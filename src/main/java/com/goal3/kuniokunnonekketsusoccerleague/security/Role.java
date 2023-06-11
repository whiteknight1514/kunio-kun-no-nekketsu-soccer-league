package com.goal3.kuniokunnonekketsusoccerleague.security;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;

//перечисление ролей (Role), каждая из которых содержит Set разрешений (Permission)
public enum Role {

    ADMIN(Set.of(Permission.WRITE, Permission.READ, Permission.GENERATE)),
    USER(Set.of(Permission.READ, Permission.GENERATE)),
    VIEWER(Set.of(Permission.READ));

    private final Set<Permission> permissions;

    Role(Set<Permission> permissions) {
        this.permissions = permissions;
    }

    public Set<Permission> permissions() {
        return this.permissions;
    }

    public Set<SimpleGrantedAuthority> authorities() {
        return this.permissions.stream()
                .map(Permission::authority)
                .collect(Collectors.toSet());
    }
}
