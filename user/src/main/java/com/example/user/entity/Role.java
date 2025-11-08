package com.example.user.entity;

import lombok.Getter;

@Getter
public enum Role {

    ADMIN("admin"),
    USER("user");

    private final String displayName;

    Role(String displayName) {
        this.displayName = displayName;
    }

}
