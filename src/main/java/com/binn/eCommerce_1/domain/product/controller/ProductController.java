package com.binn.eCommerce_1.domain.product.controller;

import com.binn.eCommerce_1.domain.product.entity.Product;
import com.binn.eCommerce_1.domain.product.entity.ProductCreateForm;
import com.binn.eCommerce_1.domain.product.service.ProductService;
import com.binn.eCommerce_1.domain.user.entity.SiteUser;
import com.binn.eCommerce_1.domain.user.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.List;

@RequiredArgsConstructor
@Controller
@RequestMapping("/product")
public class ProductController {
    private final ProductService productService;
    private final UserService userService;

    @GetMapping("/list")
    public String list(Model model) {
        List<Product> productList = this.productService.list();
        model.addAttribute("productList",productList);
        return "product_list";
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/create")
    public String create(ProductCreateForm productCreateForm) {
        return "product_form";
    }

    @PreAuthorize("isAuthenticated()")
    @PostMapping("/create")
    public String create(@Valid ProductCreateForm productCreateForm, BindingResult bindingResult, Principal principal) {
        SiteUser user = this.userService.getUser(principal.getName());
        if (bindingResult.hasErrors()) {
            return "product_form";
        }
        this.productService.create(productCreateForm.getTitle(),productCreateForm.getContent(),productCreateForm.getPrice(),user);
        return "redirect:/product/list";
    }
}
