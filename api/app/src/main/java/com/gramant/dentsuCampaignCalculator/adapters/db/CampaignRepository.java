package com.gramant.dentsuCampaignCalculator.adapters.db;

import com.gramant.dentsuCampaignCalculator.adapters.db.data.CampaignJoinProductData;
import com.gramant.dentsuCampaignCalculator.adapters.dbdomain.data.tables.records.CampaignRecord;
import com.gramant.dentsuCampaignCalculator.domain.CalculationMethod;
import com.gramant.dentsuCampaignCalculator.domain.Campaign;
import com.gramant.dentsuCampaignCalculator.domain.Product;
import com.gramant.dentsuCampaignCalculator.domain.ids.CampaignId;
import com.gramant.dentsuCampaignCalculator.domain.ids.ProductCode;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import static com.gramant.dentsuCampaignCalculator.adapters.dbdomain.data.Tables.CAMPAIGN;
import static com.gramant.dentsuCampaignCalculator.adapters.dbdomain.data.tables.Product.PRODUCT;

@Repository
@RequiredArgsConstructor
@Slf4j
public class CampaignRepository {

    private final DSLContext dsl;

    @Transactional(readOnly = true)
    public Optional<Campaign> getById(CampaignId id) {
        Optional<Record> record = dsl
                .select()
                .from(CAMPAIGN)
                .where(CAMPAIGN.ID.eq(id.getValue()))
                .fetchOptional();
        return record.map(CampaignRepository::map);
    }

    @Transactional(readOnly = true)
    public Optional<Campaign> getByName(String name) {
        Optional<Record> record = dsl
                .select()
                .from(CAMPAIGN)
                .where(CAMPAIGN.NAME.eq(name))
                .fetchOptional();
        return record.map(CampaignRepository::map);
    }

    @Transactional
    public void remove(UUID id) {
        dsl.deleteFrom(CAMPAIGN)
                .where(CAMPAIGN.ID.eq(id))
                .execute();
    }

    @Transactional
    public void add(Campaign campaign) {
        dsl.insertInto(CAMPAIGN)
                .set(CampaignData.fromCampaign(campaign).asRecord())
                .execute();
    }

    private static Campaign map(Record record) {
        CampaignRecord campaignRecord = record.into(CAMPAIGN);
        return new Campaign(
                new CampaignId(campaignRecord.getId()),
                campaignRecord.getName(),
                new ProductCode(campaignRecord.getProductCode()),
                campaignRecord.getCalculation(),
                campaignRecord.getBudget(),
                campaignRecord.getWeeks()
        );
    }

    @Transactional
    public void update(Campaign campaign) {
        dsl.update(CAMPAIGN)
                .set(CampaignData.fromCampaign(campaign).asRecord())
                .where(CAMPAIGN.ID.eq(campaign.getId().getValue()))
                .execute();
    }

    public List<Campaign> list() {
        return dsl.select().from(CAMPAIGN).fetch().map(CampaignRepository::map);
    }

    public List<CampaignJoinProductData> extendedList() {

        return dsl
                .select()
                .from(CAMPAIGN.join(PRODUCT)
                        .on(CAMPAIGN.PRODUCT_CODE.eq(PRODUCT.CODE))
                ).fetch().stream().map(record -> {
                    Campaign campaign = map(record);
                    Product product = ProductRepository.map(record);
                    return new CampaignJoinProductData(campaign, product);
                }).collect(Collectors.toList());

    }

    static class CampaignData {
        private final UUID id;
        private final String name;
        private final UUID productCode;
        private final CalculationMethod calculationMethod;
        private final Integer budget;
        private final Integer weeks;

        CampaignData(UUID id, String name, UUID productCode,
                     CalculationMethod calculationMethod,
                     Integer budget, Integer weeks
        ) {
            this.id = id;
            this.name = name;
            this.productCode = productCode;
            this.calculationMethod = calculationMethod;
            this.budget = budget;
            this.weeks = weeks;
        }

        public static CampaignData fromCampaign(Campaign campaign) {
            return new CampaignData
                    (
                            campaign.getId().getValue(),
                            campaign.getName(),
                            campaign.getProductCode().getValue(),
                            campaign.getCalculationMethod(),
                            campaign.getBudget(),
                            campaign.getWeeks()
                    );
        }

        public Campaign asCampaign() {
            return new Campaign(new CampaignId(id), name, new ProductCode(productCode), calculationMethod, budget, weeks);
        }

        public CampaignRecord asRecord() {
            return new CampaignRecord()
                    .with(CAMPAIGN.ID, id)
                    .with(CAMPAIGN.NAME, name)
                    .with(CAMPAIGN.PRODUCT_CODE, productCode)
                    .with(CAMPAIGN.CALCULATION, calculationMethod)
                    .with(CAMPAIGN.BUDGET, budget)
                    .with(CAMPAIGN.WEEKS, weeks);
        }
    }
}
