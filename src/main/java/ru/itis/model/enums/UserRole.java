package ru.itis.model.enums;

import org.springframework.security.core.GrantedAuthority;

public enum UserRole implements GrantedAuthority {
    USER, ADMIN, AUTHOR;

    @Override
    public String getAuthority() {
        return name();
    }
}
