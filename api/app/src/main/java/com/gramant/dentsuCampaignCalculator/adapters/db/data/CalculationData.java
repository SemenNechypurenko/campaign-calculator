package com.gramant.dentsuCampaignCalculator.adapters.db.data;

import com.gramant.dentsuCampaignCalculator.adapters.dbdomain.data.tables.records.CalculationModalRecord;
import com.gramant.dentsuCampaignCalculator.domain.Calculation;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Accessors;

import java.time.LocalDate;

@Getter
@Accessors(fluent = true)
@RequiredArgsConstructor
public class CalculationData {
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
    private final Double romiGa;
    private final Double romiAttrModel;
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


    public CalculationModalRecord toCalculationModalRecord(){
       return new CalculationModalRecord(
                dateStart,
                dateEnd,
                product,
                campaign,
                crm,
                channel,
                playground,
                format,
                budget,
                gaTransactions,
                attrTransactionsModel,
                appTransactions,
                effectiveFrequency,
                sales,
                averageCheck,
                cpa,
                romiGa,
                romiAttrModel,
                incomeGa,
                desktopGaTransactions,
                mobileGaTransactions,
                tabletGaTransactions,
                place,
                budgetSecond,
                budgetThird,
                budgetFourth,
                formatSecond,
                newPlayers,
                version
        );
    }

    public static CalculationData from(Calculation calc){
        return new CalculationData(
                calc.dateStart(),
                calc.dateEnd(),
                calc.product(),
                calc.campaign(),
                calc.crm(),
                calc.channel(),
                calc.playground(),
                calc.format(),
                calc.budget(),
                calc.gaTransactions(),
                calc.attrTransactionsModel(),
                calc.appTransactions(),
                calc.effectiveFrequency(),
                calc.sales(),
                calc.averageCheck(),
                calc.cpa(),
                calc.romiGa().value(),
                calc.romiAttrModel().value(),
                calc.incomeGa(),
                calc.desktopGaTransactions(),
                calc.mobileGaTransactions(),
                calc.tabletGaTransactions(),
                calc.place(),
                calc.budgetSecond(),
                calc.budgetThird(),
                calc.budgetFourth(),
                calc.formatSecond(),
                calc.newPlayers(),
                calc.version()
        );
    }
}
