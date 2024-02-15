package com.binn.eCommerce_1.domain.product.controller;

import com.binn.eCommerce_1.domain.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

@RequiredArgsConstructor
@Controller
public class ProductController {
    private final ProductService productService;
}
