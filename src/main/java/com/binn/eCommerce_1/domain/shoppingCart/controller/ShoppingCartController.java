package com.binn.eCommerce_1.domain.shoppingCart.controller;

import com.binn.eCommerce_1.domain.product.entity.Product;
import com.binn.eCommerce_1.domain.product.service.ProductService;
import com.binn.eCommerce_1.domain.shoppingCart.entity.ShoppingCart;
import com.binn.eCommerce_1.domain.shoppingCart.service.ShoppingCartService;
import com.binn.eCommerce_1.domain.user.entity.SiteUser;
import com.binn.eCommerce_1.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Controller
@RequestMapping("/shoppingCart")
public class ShoppingCartController {
    private final ShoppingCartService shoppingCartService;
    private final UserService userService;
    private final ProductService productService;

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/create/{id}")
    public String create(@PathVariable("id") Long productId, Principal principal) {
        SiteUser user = this.userService.getUser(principal.getName());
        Product product = this.productService.getProduct(productId);
        this.shoppingCartService.create(user, product);
        return String.format("redirect:/product/%s", productId);
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/list")
    public String list(Principal principal, Model model) {
        SiteUser user = this.userService.getUser(principal.getName());
        List<ShoppingCart> shoppingCartList = this.shoppingCartService.getShoppingCartByUserId(user.getId());
        List<Product> productList = new ArrayList<>();
        for (ShoppingCart shoppingCart : shoppingCartList) {
            productList.add(this.productService.getProduct(shoppingCart.getProduct().getId()));
        }
        model.addAttribute("productList", productList);
        return "shoppingCart";
    }
}
