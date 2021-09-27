package com.devHyun.TodayTrip01.web.dto.member;


import com.devHyun.TodayTrip01.domain.user.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class JoinDto {

    private static final int MAX_LENGTH = 20;

    @NotBlank
    @Size(max = MAX_LENGTH)
    private String username;

    @NotBlank
    private String password;

    @NotBlank
    private String email;

    @NotBlank
    private String name;


    public User toEntity() {

        return User.builder()
                .username(username)
                .password(password)
                .email(email)
                .name(name)
                .build();
    }
}
