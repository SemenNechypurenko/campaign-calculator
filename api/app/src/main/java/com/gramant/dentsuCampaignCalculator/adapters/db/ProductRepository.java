package com.gramant.dentsuCampaignCalculator.adapters.db;

import com.gramant.dentsuCampaignCalculator.adapters.dbdomain.data.tables.records.ProductRecord;
import com.gramant.dentsuCampaignCalculator.domain.Product;
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

import static com.gramant.dentsuCampaignCalculator.adapters.dbdomain.data.Tables.PRODUCT;


@Repository
@RequiredArgsConstructor
@Slf4j
public class ProductRepository {

    private final DSLContext dsl;

    @Transactional(readOnly = true)
    public Optional<Product> getByName(String name) {
        Optional<Record> record = dsl
                .select()
                .from(PRODUCT)
                .where(PRODUCT.NAME.eq(name))
                .fetchOptional();
        return record.map(ProductRepository::map);
    }

    @Transactional(readOnly = true)
    public Optional<Product> getById(ProductCode code) {
        return dsl
                .select()
                .from(PRODUCT)
                .where(PRODUCT.CODE.eq(code.getValue()))
                .fetchOptional()
                .map(ProductRepository::map);
    }

    @Transactional(readOnly = true)
    public List<Product> list() {
        return dsl.select().from(PRODUCT).fetch().map(ProductRepository::map);
    }

    @Transactional
    public void add(Product product) {
        dsl.insertInto(PRODUCT)
                .set(ProductData.fromProduct(product).asRecord())
                .execute();
    }

    @Transactional
    public void update(Product product) {
        dsl.update(PRODUCT)
                .set(ProductData.fromProduct(product).asRecord())
                .where(PRODUCT.CODE.eq(product.getCode().getValue()))
                .execute();
    }

    @Transactional
    public void remove(ProductCode code) {
        dsl.deleteFrom(PRODUCT)
                .where(PRODUCT.CODE.eq(code.getValue()))
                .execute();

    }

    public static Product map(Record record) {
        ProductRecord productsRecord = record.into(PRODUCT);
        return new Product(new ProductCode(productsRecord.getCode()), productsRecord.getName());
    }

    static class ProductData {
        private final UUID code;
        private final String name;

        ProductData(UUID code, String name) {
            this.code = code;
            this.name = name;
        }

        public static ProductData fromProduct(Product product) {
            return new ProductData(product.getCode().getValue(), product.getName());
        }

        public Product asProduct() {
            return new Product(new ProductCode(code), name);
        }

        public ProductRecord asRecord() {
            return new ProductRecord()
                    .with(PRODUCT.CODE, code)
                    .with(PRODUCT.NAME, name);
        }
    }

}
