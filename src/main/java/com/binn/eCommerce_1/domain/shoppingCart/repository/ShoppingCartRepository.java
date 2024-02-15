package com.binn.eCommerce_1.domain.shoppingCart.repository;

import com.binn.eCommerce_1.domain.shoppingCart.entity.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Long> {
}
