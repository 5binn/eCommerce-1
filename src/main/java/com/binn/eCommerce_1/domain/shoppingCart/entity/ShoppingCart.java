package com.binn.eCommerce_1.domain.shoppingCart.entity;


import com.binn.eCommerce_1.domain.product.entity.Product;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.util.Set;

@Entity
@Getter
@SuperBuilder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class ShoppingCart {
    private Long userId;

    private Set<Product> productSet;
    private BigDecimal totalPrice;
}
