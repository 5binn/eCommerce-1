package com.binn.eCommerce_1.domain.user.entity;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserCreateForm {
    @NotEmpty(message = "ID를 입력하세요.")
    private String username;
    @NotEmpty(message = "비밀번호를 입력하세요.")
    private String password;
    @NotEmpty(message = "이메일을 입력하세요.")
    private String email;
    @NotEmpty(message = "연락처를 입력하세요.")
    private String phoneNum;
}
