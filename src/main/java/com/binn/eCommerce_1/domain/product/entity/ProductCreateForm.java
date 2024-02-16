package com.binn.eCommerce_1.domain.product.entity;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
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
    @NotNull(message = "금액을 입력하세요.")
    @DecimalMin(value = "0.01", inclusive = true, message = "Value must be greater than or equal to 0.01")
    @DecimalMax(value = "1000000.00", inclusive = true, message = "Value must be less than or equal to 1000000.00")
    private BigDecimal price;
}
