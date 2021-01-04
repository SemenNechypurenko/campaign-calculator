package com.gramant.dentsuCampaignCalculator.domain;

import java.util.Objects;

public class Percentage {
    private final Double value;

    private Percentage(Double value) {
        this.value = value;
    }

    public static Percentage from(String str) {
        Objects.requireNonNull(str);

        String formattedSir = str.replace(",", ".") //change separator
                .replace("%", ""); // delete %

        return new Percentage(Double.parseDouble(formattedSir));
    }

    public static Percentage from(Double aDouble) {
        return new Percentage(aDouble);
    }

    public Double value() {
        return value;
    }

    public String valueStr() {
        return value.toString() + "%";
    }
}
