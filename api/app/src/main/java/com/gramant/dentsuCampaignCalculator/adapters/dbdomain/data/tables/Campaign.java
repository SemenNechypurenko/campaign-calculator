/*
 * This file is generated by jOOQ.
 */
package com.gramant.dentsuCampaignCalculator.adapters.dbdomain.data.tables;


import com.gramant.dentsuCampaignCalculator.adapters.db.converter.StringToCalculationConverter;
import com.gramant.dentsuCampaignCalculator.adapters.dbdomain.data.Keys;
import com.gramant.dentsuCampaignCalculator.adapters.dbdomain.data.Public;
import com.gramant.dentsuCampaignCalculator.adapters.dbdomain.data.tables.records.CampaignRecord;
import com.gramant.dentsuCampaignCalculator.domain.CalculationMethod;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row6;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Campaign extends TableImpl<CampaignRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>public.campaign</code>
     */
    public static final Campaign CAMPAIGN = new Campaign();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<CampaignRecord> getRecordType() {
        return CampaignRecord.class;
    }

    /**
     * The column <code>public.campaign.id</code>.
     */
    public final TableField<CampaignRecord, UUID> ID = createField(DSL.name("id"), SQLDataType.UUID.nullable(false), this, "");

    /**
     * The column <code>public.campaign.name</code>.
     */
    public final TableField<CampaignRecord, String> NAME = createField(DSL.name("name"), SQLDataType.VARCHAR(100).nullable(false), this, "");

    /**
     * The column <code>public.campaign.product_code</code>.
     */
    public final TableField<CampaignRecord, UUID> PRODUCT_CODE = createField(DSL.name("product_code"), SQLDataType.UUID.nullable(false), this, "");

    /**
     * The column <code>public.campaign.calculation</code>.
     */
    public final TableField<CampaignRecord, CalculationMethod> CALCULATION = createField(DSL.name("calculation"), SQLDataType.VARCHAR(50).nullable(false), this, "", new StringToCalculationConverter());

    /**
     * The column <code>public.campaign.budget</code>.
     */
    public final TableField<CampaignRecord, Integer> BUDGET = createField(DSL.name("budget"), SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>public.campaign.weeks</code>.
     */
    public final TableField<CampaignRecord, Integer> WEEKS = createField(DSL.name("weeks"), SQLDataType.INTEGER.nullable(false), this, "");

    private Campaign(Name alias, Table<CampaignRecord> aliased) {
        this(alias, aliased, null);
    }

    private Campaign(Name alias, Table<CampaignRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>public.campaign</code> table reference
     */
    public Campaign(String alias) {
        this(DSL.name(alias), CAMPAIGN);
    }

    /**
     * Create an aliased <code>public.campaign</code> table reference
     */
    public Campaign(Name alias) {
        this(alias, CAMPAIGN);
    }

    /**
     * Create a <code>public.campaign</code> table reference
     */
    public Campaign() {
        this(DSL.name("campaign"), null);
    }

    public <O extends Record> Campaign(Table<O> child, ForeignKey<O, CampaignRecord> key) {
        super(child, key, CAMPAIGN);
    }

    @Override
    public Schema getSchema() {
        return Public.PUBLIC;
    }

    @Override
    public UniqueKey<CampaignRecord> getPrimaryKey() {
        return Keys.PK_CAMPAIGN_ID;
    }

    @Override
    public List<UniqueKey<CampaignRecord>> getKeys() {
        return Arrays.<UniqueKey<CampaignRecord>>asList(Keys.PK_CAMPAIGN_ID, Keys.UQ_CAMPAIGN_NAME);
    }

    @Override
    public List<ForeignKey<CampaignRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<CampaignRecord, ?>>asList(Keys.CAMPAIGN__CAMPAIGN_PRODUCT_CODE_FKEY);
    }

    public Product product() {
        return new Product(this, Keys.CAMPAIGN__CAMPAIGN_PRODUCT_CODE_FKEY);
    }

    @Override
    public Campaign as(String alias) {
        return new Campaign(DSL.name(alias), this);
    }

    @Override
    public Campaign as(Name alias) {
        return new Campaign(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Campaign rename(String name) {
        return new Campaign(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Campaign rename(Name name) {
        return new Campaign(name, null);
    }

    // -------------------------------------------------------------------------
    // Row6 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row6<UUID, String, UUID, CalculationMethod, Integer, Integer> fieldsRow() {
        return (Row6) super.fieldsRow();
    }
}
