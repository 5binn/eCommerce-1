package com.binn.eCommerce_1.domain.shoppingCart.repository;

import com.binn.eCommerce_1.domain.shoppingCart.entity.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Long> {

    public List<ShoppingCart> findByUserId(Long userId);
}
