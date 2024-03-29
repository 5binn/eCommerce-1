package com.binn.eCommerce_1.domain.user.entity;

import com.binn.eCommerce_1.global.jpa.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;

@Entity
@Getter
@SuperBuilder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class SiteUser extends BaseEntity {
    @Column(length = 200, unique = true)
    private String username;

    private String password;

    @Column(unique = true)
    private String email;

    private String phoneNum;

    private boolean role;

    private String seller_authorization;

    private BigDecimal point;
}
