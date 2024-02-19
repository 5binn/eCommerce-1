package com.binn.eCommerce_1.domain.product.controller;

import com.binn.eCommerce_1.domain.product.entity.Product;
import com.binn.eCommerce_1.domain.product.entity.ProductCreateForm;
import com.binn.eCommerce_1.domain.product.service.ProductService;
import com.binn.eCommerce_1.domain.user.entity.SiteUser;
import com.binn.eCommerce_1.domain.user.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

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
        model.addAttribute("productList", productList);
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
        this.productService.create(productCreateForm.getTitle(), productCreateForm.getContent(), productCreateForm.getPrice(), user);
        return "redirect:/product/list";
    }

    @GetMapping("/{id}")
    public String detail(@PathVariable("id") Long id, Model model) {
        Product product = this.productService.getProduct(id);
        model.addAttribute("product", product);
        return "product_detail";
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/{id}/modify")
    public String modify(@PathVariable("id") Long id, Model model, Principal principal, ProductCreateForm productCreateForm) {
        Product product = this.productService.getProduct(id);
        if (!product.getSeller().getUsername().equals(principal.getName())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "수정권한없음");
        }
        productCreateForm.setTitle(product.getTitle());
        productCreateForm.setContent(product.getContent());
        productCreateForm.setPrice(product.getPrice());
        model.addAttribute("product", product);
        return "product_form";
    }

    @PreAuthorize("isAuthenticated()")
    @PostMapping("/{id}/modify")
    public String modify(@PathVariable("id") Long id, Model model, Principal principal,
                         @Valid ProductCreateForm productCreateForm, BindingResult bindingResult) {
        Product product = this.productService.getProduct(id);
        if (!product.getSeller().getUsername().equals(principal.getName())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "수정권한없음");
        }
        this.productService.modify(product, productCreateForm.getTitle(), productCreateForm.getContent(), productCreateForm.getPrice());
        return "redirect:/product/list";
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/{id}/delete")
    public String delete(@PathVariable("id") Long id, Principal principal) {
        Product product = this.productService.getProduct(id);
        if (!product.getSeller().getUsername().equals(principal.getName())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "삭제권한없음");
        }
        this.productService.delete(product);
        return "redirect:/product/list";
    }
}
