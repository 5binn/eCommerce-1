package com.binn.eCommerce_1.domain.product.service;

import com.binn.eCommerce_1.domain.product.entity.Product;
import com.binn.eCommerce_1.domain.product.repository.ProductRepository;
import com.binn.eCommerce_1.domain.user.entity.SiteUser;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@RequiredArgsConstructor
@Service
public class ProductService {
    private final ProductRepository productRepository;

    public List<Product> list() {
        return this.productRepository.findAll();
    }

    public void create(String title, String content, BigDecimal price, SiteUser sellerUser) {
        Product product = Product.builder()
                .title(title)
                .content(content)
                .price(price)
                .sellerUser(sellerUser)
                .build();
        this.productRepository.save(product);
    }
}
