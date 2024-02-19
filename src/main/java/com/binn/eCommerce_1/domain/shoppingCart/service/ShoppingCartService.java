package com.binn.eCommerce_1.domain.shoppingCart.service;

import com.binn.eCommerce_1.domain.product.entity.Product;
import com.binn.eCommerce_1.domain.shoppingCart.entity.ShoppingCart;
import com.binn.eCommerce_1.domain.shoppingCart.repository.ShoppingCartRepository;
import com.binn.eCommerce_1.domain.user.entity.SiteUser;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.parameters.P;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ShoppingCartService {
    private final ShoppingCartRepository shoppingCartRepository;

    public void create(SiteUser user, Product product) {
        ShoppingCart shoppingCart = ShoppingCart.builder()
                .user(user)
                .product(product)
                .build();
        this.shoppingCartRepository.save(shoppingCart);
    }

    public List<ShoppingCart> getShoppingCartByUserId(Long userId) {
        return this.shoppingCartRepository.findByUserId(userId);
    }
}
