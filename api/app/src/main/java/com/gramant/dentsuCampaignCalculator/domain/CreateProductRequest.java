package com.gramant.dentsuCampaignCalculator.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class CreateProductRequest {

    private final String name;

    @JsonCreator
    public CreateProductRequest(@JsonProperty("name") String name){
        this.name = name;
    }

    public Product asProduct() {
        return Product.newProduct(name);
    }

}
