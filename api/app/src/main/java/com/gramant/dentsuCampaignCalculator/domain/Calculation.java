package com.gramant.dentsuCampaignCalculator.domain;

import lombok.Getter;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.time.LocalDate;

@Getter
@Accessors(fluent = true)
//@EqualsAndHashCode(of = {"id"})
@ToString
public class Calculation {
    private final LocalDate dateStart;
    private final LocalDate dateEnd;
    private final String product;
    private final String campaign;
    private final String crm;
    private final String channel;
    private final String playground;
    private final String format;

    private final Double budget;
    private final Double gaTransactions;
    private final Double attrTransactionsModel;
    private final Double appTransactions;
    private final Integer effectiveFrequency;
    private final Double sales;
    private final Double averageCheck;
    private final Double cpa;
    private final Percentage  romiGa;
    private final Percentage romiAttrModel;
    private final Double incomeGa;
    private final Double desktopGaTransactions;
    private final Double mobileGaTransactions;
    private final Double tabletGaTransactions;
    private final String place;
    private final Double budgetSecond;
    private final Double budgetThird;
    private final Double budgetFourth;
    private final String formatSecond;
    private final Double newPlayers;
    private final Integer version;

    public Calculation(LocalDate dateStart, LocalDate dateEnd, String product, String campaign, String crm, String channel, String playground, String format, Double budget, Double gaTransactions, Double attrTransactionsModel, Double appTransactions, Integer effectiveFrequency, Double sales, Double averageCheck, Double cpa, Percentage romiGa, Percentage romiAttrModel, Double incomeGa, Double desktopGaTransactions, Double mobileGaTransactions, Double tabletGaTransactions, String place, Double budgetSecond, Double budgetThird, Double budgetFourth, String formatSecond, Double newPlayers, Integer version) {
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        this.product = product;
        this.campaign = campaign;
        this.crm = crm;
        this.channel = channel;
        this.playground = playground;
        this.format = format;
        this.budget = budget;
        this.gaTransactions = gaTransactions;
        this.attrTransactionsModel = attrTransactionsModel;
        this.appTransactions = appTransactions;
        this.effectiveFrequency = effectiveFrequency;
        this.sales = sales;
        this.averageCheck = averageCheck;
        this.cpa = cpa;
        this.romiGa = romiGa;
        this.romiAttrModel = romiAttrModel;
        this.incomeGa = incomeGa;
        this.desktopGaTransactions = desktopGaTransactions;
        this.mobileGaTransactions = mobileGaTransactions;
        this.tabletGaTransactions = tabletGaTransactions;
        this.place = place;
        this.budgetSecond = budgetSecond;
        this.budgetThird = budgetThird;
        this.budgetFourth = budgetFourth;
        this.formatSecond = formatSecond;
        this.newPlayers = newPlayers;
        this.version = version;
    }
}
