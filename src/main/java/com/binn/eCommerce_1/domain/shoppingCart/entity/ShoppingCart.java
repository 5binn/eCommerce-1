package com.binn.eCommerce_1.domain.shoppingCart.entity;


import com.binn.eCommerce_1.domain.product.entity.Product;
import com.binn.eCommerce_1.global.jpa.BaseEntity;
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
public class ShoppingCart extends BaseEntity {
    private Long userId;

    private BigDecimal totalPrice;
}
