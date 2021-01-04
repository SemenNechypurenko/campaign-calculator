package com.gramant.dentsuCampaignCalculator.adapters.db.converter;


import com.gramant.dentsuCampaignCalculator.domain.CalculationMethod;
import org.jooq.Converter;

public class StringToCalculationConverter implements Converter<String, CalculationMethod> {

    @Override
    public CalculationMethod from(String databaseObject) {
        return CalculationMethod.valueOf(databaseObject);
    }

    @Override
    public String to(CalculationMethod userObject) {
        return String.valueOf(userObject);
    }

    @Override
    public Class<String> fromType() {
        return String.class;
    }

    @Override
    public Class<CalculationMethod> toType() {
        return CalculationMethod.class;
    }
}
