package com.gramant.dentsuCampaignCalculator.adapters.db;

import com.google.common.collect.Lists;
import com.gramant.dentsuCampaignCalculator.adapters.db.data.CalculationData;
import com.gramant.dentsuCampaignCalculator.adapters.dbdomain.data.tables.records.CalculationModalRecord;
import com.gramant.dentsuCampaignCalculator.domain.Calculation;
import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

import static com.gramant.dentsuCampaignCalculator.adapters.dbdomain.data.Tables.CALCULATION_MODAL;

@Repository
@RequiredArgsConstructor
public class CalculationRepository {
    private static final int BATCH_SIZE = 50;

    private final DSLContext dsl;

    public int countLines() {
        return dsl.fetchCount(CALCULATION_MODAL);
    }

    @Transactional
    public void insertCalculations(List<Calculation> calculations) {
        List<List<CalculationModalRecord>> calculationModalRecordPartition = Lists.partition(calculations.stream()
                .map(CalculationData::from)
                .map(CalculationData::toCalculationModalRecord)
                .collect(Collectors.toList()), BATCH_SIZE);


        for (List<CalculationModalRecord> calculationModalRecords : calculationModalRecordPartition) {
            dsl.batchInsert(calculationModalRecords).execute();
        }
    }

}
