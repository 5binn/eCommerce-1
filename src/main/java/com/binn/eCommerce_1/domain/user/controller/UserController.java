package com.binn.eCommerce_1.domain.user.controller;

import com.binn.eCommerce_1.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

@RequiredArgsConstructor
@Controller
public class UserController {
    private final UserService userService;
}
