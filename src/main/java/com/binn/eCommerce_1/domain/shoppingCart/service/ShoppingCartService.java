package com.binn.eCommerce_1.domain.shoppingCart.service;

import com.binn.eCommerce_1.domain.product.entity.Product;
import com.binn.eCommerce_1.domain.shoppingCart.entity.ShoppingCart;
import com.binn.eCommerce_1.domain.shoppingCart.repository.ShoppingCartRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ShoppingCartService {
    private final ShoppingCartRepository shoppingCartRepository;

    public void create(Long userId, Long productId) {
        ShoppingCart shoppingCart = ShoppingCart.builder()
                .userId(userId)
                .productId(productId)
                .build();
        this.shoppingCartRepository.save(shoppingCart);
    }

    public List<ShoppingCart> getShoppingCartByUserId(Long userId) {
        return this.shoppingCartRepository.findByUserId(userId);
    }
}
