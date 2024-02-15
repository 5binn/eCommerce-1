package com.binn.eCommerce_1.domain.product.service;

import com.binn.eCommerce_1.domain.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ProductService {
    private final ProductRepository productRepository;
}
