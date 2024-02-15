package com.binn.eCommerce_1.domain.shoppingCart.service;

import com.binn.eCommerce_1.domain.shoppingCart.repository.ShoppingCartRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ShoppingCartService {
    private final ShoppingCartRepository shoppingCartRepository;
}
