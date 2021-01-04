package com.gramant.dentsuCampaignCalculator.adapters.web.representations;

import com.gramant.dentsuCampaignCalculator.domain.Product;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class ProductRepresentation {
    private final String code;
    private final String name;

    public static ProductRepresentation from(Product product){
        return new ProductRepresentation(
                product.getCode().getValue().toString(),
                product.getName()
        );
    }
}
