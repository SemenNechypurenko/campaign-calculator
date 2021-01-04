package com.gramant.dentsuCampaignCalculator.adapters.db.data;

import com.gramant.dentsuCampaignCalculator.domain.Campaign;
import com.gramant.dentsuCampaignCalculator.domain.Product;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
@EqualsAndHashCode
public class CampaignJoinProductData {
    private final Campaign campaign;
    private final Product product;
}
