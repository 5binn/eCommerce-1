package com.binn.eCommerce_1.domain.wish.entity;

import com.binn.eCommerce_1.domain.user.entity.SiteUser;
import com.binn.eCommerce_1.global.jpa.BaseEntity;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.Set;

@Entity
@Getter
@SuperBuilder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class Wish extends BaseEntity {
    private Long userId;

    private Set<Long> productIds;
}
