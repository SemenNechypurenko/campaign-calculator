package com.gramant.dentsuCampaignCalculator.adapters.web.representations;

import com.gramant.dentsuCampaignCalculator.adapters.db.data.CampaignJoinProductData;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class CampaignAndProductRepresentation {
    private final String id;
    private final String name;
    private final String productCode;
    private final String calculationMethod;
    private final Integer budget;
    private final Integer weeks;
    private final String productName;

    public static CampaignAndProductRepresentation from(CampaignJoinProductData campaignJoinProductData){
        return new CampaignAndProductRepresentation(
                campaignJoinProductData.getCampaign().getId().getValue().toString(),
                campaignJoinProductData.getCampaign().getName(),
                campaignJoinProductData.getCampaign().getProductCode().getValue().toString(),
                campaignJoinProductData.getCampaign().getCalculationMethod().toString(),
                campaignJoinProductData.getCampaign().getBudget(),
                campaignJoinProductData.getCampaign().getWeeks(),
                campaignJoinProductData.getProduct().getName()
        );
    }
}
