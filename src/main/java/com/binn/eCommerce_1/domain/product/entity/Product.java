package com.binn.eCommerce_1.domain.product.entity;

import com.binn.eCommerce_1.domain.shoppingCart.entity.ShoppingCart;
import com.binn.eCommerce_1.domain.user.entity.SiteUser;
import com.binn.eCommerce_1.global.jpa.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
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
public class Product extends BaseEntity {
    private String title;
    @Column(columnDefinition = "TEXT")
    private String content;
    private BigDecimal price;
    private Long wishCount;
    @ManyToOne
    private SiteUser seller;
    private BigDecimal discountRate;
    private String productImg;
}
