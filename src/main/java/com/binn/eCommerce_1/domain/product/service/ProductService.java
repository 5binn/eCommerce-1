package com.binn.eCommerce_1.domain.product.service;

import com.binn.eCommerce_1.domain.product.entity.Product;
import com.binn.eCommerce_1.domain.product.repository.ProductRepository;
import com.binn.eCommerce_1.domain.user.entity.SiteUser;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ProductService {
    private final ProductRepository productRepository;

    public List<Product> list() {
        return this.productRepository.findAll();
    }

    public void create(String title, String content, BigDecimal price, SiteUser seller) {
        Product product = Product.builder()
                .title(title)
                .content(content)
                .price(price)
                .seller(seller)
                .build();
        this.productRepository.save(product);
    }

    public void modify(Product product, String title, String content, BigDecimal price) {
        Product modifyProduct = product.toBuilder()
                .title(title)
                .content(content)
                .price(price)
                .build();
        this.productRepository.save(modifyProduct);
    }

    public void delete(Product product) {
        this.productRepository.delete(product);
    }
    public Product getProduct(Long id) {
        Optional<Product> product = this.productRepository.findById(id);
        if (product.isEmpty()) {
            return null;
        }
        return product.get();
    }
}
