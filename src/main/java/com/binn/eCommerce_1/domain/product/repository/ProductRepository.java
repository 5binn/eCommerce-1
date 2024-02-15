package com.binn.eCommerce_1.domain.product.repository;

import com.binn.eCommerce_1.domain.product.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
