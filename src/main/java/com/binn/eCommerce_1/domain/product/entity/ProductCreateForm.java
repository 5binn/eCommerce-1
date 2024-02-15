package com.binn.eCommerce_1.domain.product.entity;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class ProductCreateForm {
    @NotEmpty(message = "제목을 입력하세요.")
    private String title;
    @NotEmpty(message = "내용을 입력하세요.")
    private String content;
    @NotEmpty(message = "금액을 입력하세요.")
    private BigDecimal price;
}
