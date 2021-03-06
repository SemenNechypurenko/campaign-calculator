package com.gramant.dentsuCampaignCalculator.domain;

import com.gramant.dentsuCampaignCalculator.domain.ids.ProductCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Product {

    private final ProductCode code;
    private final String name;

    public Product(ProductCode code, String name) {
        this.code = code;
        this.name = name;
    }

    public static Product newProduct(String name) {
        return new Product(ProductCode.newCode(), name);
    }

}
