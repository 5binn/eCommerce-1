package com.binn.eCommerce_1.domain.shoppingCart.controller;

import com.binn.eCommerce_1.domain.shoppingCart.service.ShoppingCartService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

@RequiredArgsConstructor
@Controller
public class ShoppingCartController {
    private final ShoppingCartService shoppingCartService;
}
