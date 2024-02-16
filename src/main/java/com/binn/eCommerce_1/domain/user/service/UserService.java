package com.binn.eCommerce_1.domain.user.service;

import com.binn.eCommerce_1.domain.user.entity.SiteUser;
import com.binn.eCommerce_1.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public void create(String username, String password, String email, String phoneNum) {
        SiteUser user = SiteUser.builder()
                .username(username)
                .password(passwordEncoder.encode(password))
                .email(email)
                .phoneNum(phoneNum)
                .build();
        this.userRepository.save(user);
    }
}
