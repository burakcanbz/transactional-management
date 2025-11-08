package com.example.user.dto;

import com.example.user.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UpdateUserDTO {

    private String username;
    private String password;
    private String email;
    private Role role;

}
