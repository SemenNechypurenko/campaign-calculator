/*
 * This file is generated by jOOQ.
 */
package com.gramant.dentsuCampaignCalculator.adapters.dbdomain.data.tables.records;


import com.gramant.dentsuCampaignCalculator.adapters.dbdomain.data.tables.CalculationModal;

import java.time.LocalDate;

import org.jooq.Record9;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class CalculationModalRecord extends UpdatableRecordImpl<CalculationModalRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>public.calculation_modal.date_start</code>.
     */
    public CalculationModalRecord setDateStart(LocalDate value) {
        set(0, value);
        return this;
    }

    /**
     * Getter for <code>public.calculation_modal.date_start</code>.
     */
    public LocalDate getDateStart() {
        return (LocalDate) get(0);
    }

    /**
     * Setter for <code>public.calculation_modal.date_end</code>.
     */
    public CalculationModalRecord setDateEnd(LocalDate value) {
        set(1, value);
        return this;
    }

    /**
     * Getter for <code>public.calculation_modal.date_end</code>.
     */
    public LocalDate getDateEnd() {
        return (LocalDate) get(1);
    }

    /**
     * Setter for <code>public.calculation_modal.product</code>.
     */
    public CalculationModalRecord setProduct(String value) {
        set(2, value);
        return this;
    }

    /**
     * Getter for <code>public.calculation_modal.product</code>.
     */
    public String getProduct() {
        return (String) get(2);
    }

    /**
     * Setter for <code>public.calculation_modal.campaign</code>.
     */
    public CalculationModalRecord setCampaign(String value) {
        set(3, value);
        return this;
    }

    /**
     * Getter for <code>public.calculation_modal.campaign</code>.
     */
    public String getCampaign() {
        return (String) get(3);
    }

    /**
     * Setter for <code>public.calculation_modal.crm</code>.
     */
    public CalculationModalRecord setCrm(String value) {
        set(4, value);
        return this;
    }

    /**
     * Getter for <code>public.calculation_modal.crm</code>.
     */
    public String getCrm() {
        return (String) get(4);
    }

    /**
     * Setter for <code>public.calculation_modal.channel</code>.
     */
    public CalculationModalRecord setChannel(String value) {
        set(5, value);
        return this;
    }

    /**
     * Getter for <code>public.calculation_modal.channel</code>.
     */
    public String getChannel() {
        return (String) get(5);
    }

    /**
     * Setter for <code>public.calculation_modal.playground</code>.
     */
    public CalculationModalRecord setPlayground(String value) {
        set(6, value);
        return this;
    }

    /**
     * Getter for <code>public.calculation_modal.playground</code>.
     */
    public String getPlayground() {
        return (String) get(6);
    }

    /**
     * Setter for <code>public.calculation_modal.format</code>.
     */
    public CalculationModalRecord setFormat(String value) {
        set(7, value);
        return this;
    }

    /**
     * Getter for <code>public.calculation_modal.format</code>.
     */
    public String getFormat() {
        return (String) get(7);
    }

    /**
     * Setter for <code>public.calculation_modal.budget</code>.
     */
    public CalculationModalRecord setBudget(Double value) {
        set(8, value);
        return this;
    }

    /**
     * Getter for <code>public.calculation_modal.budget</code>.
     */
    public Double getBudget() {
        return (Double) get(8);
    }

    /**
     * Setter for <code>public.calculation_modal.ga_transactions</code>.
     */
    public CalculationModalRecord setGaTransactions(Double value) {
        set(9, value);
        return this;
    }

    /**
     * Getter for <code>public.calculation_modal.ga_transactions</code>.
     */
    public Double getGaTransactions() {
        return (Double) get(9);
    }

    /**
     * Setter for <code>public.calculation_modal.attr_transactions_model</code>.
     */
    public CalculationModalRecord setAttrTransactionsModel(Double value) {
        set(10, value);
        return this;
    }

    /**
     * Getter for <code>public.calculation_modal.attr_transactions_model</code>.
     */
    public Double getAttrTransactionsModel() {
        return (Double) get(10);
    }

    /**
     * Setter for <code>public.calculation_modal.app_transactions</code>.
     */
    public CalculationModalRecord setAppTransactions(Double value) {
        set(11, value);
        return this;
    }

    /**
     * Getter for <code>public.calculation_modal.app_transactions</code>.
     */
    public Double getAppTransactions() {
        return (Double) get(11);
    }

    /**
     * Setter for <code>public.calculation_modal.effective_frequency</code>.
     */
    public CalculationModalRecord setEffectiveFrequency(Integer value) {
        set(12, value);
        return this;
    }

    /**
     * Getter for <code>public.calculation_modal.effective_frequency</code>.
     */
    public Integer getEffectiveFrequency() {
        return (Integer) get(12);
    }

    /**
     * Setter for <code>public.calculation_modal.sales</code>.
     */
    public CalculationModalRecord setSales(Double value) {
        set(13, value);
        return this;
    }

    /**
     * Getter for <code>public.calculation_modal.sales</code>.
     */
    public Double getSales() {
        return (Double) get(13);
    }

    /**
     * Setter for <code>public.calculation_modal.average_check</code>.
     */
    public CalculationModalRecord setAverageCheck(Double value) {
        set(14, value);
        return this;
    }

    /**
     * Getter for <code>public.calculation_modal.average_check</code>.
     */
    public Double getAverageCheck() {
        return (Double) get(14);
    }

    /**
     * Setter for <code>public.calculation_modal.cpa</code>.
     */
    public CalculationModalRecord setCpa(Double value) {
        set(15, value);
        return this;
    }

    /**
     * Getter for <code>public.calculation_modal.cpa</code>.
     */
    public Double getCpa() {
        return (Double) get(15);
    }

    /**
     * Setter for <code>public.calculation_modal.romi_ga</code>.
     */
    public CalculationModalRecord setRomiGa(Double value) {
        set(16, value);
        return this;
    }

    /**
     * Getter for <code>public.calculation_modal.romi_ga</code>.
     */
    public Double getRomiGa() {
        return (Double) get(16);
    }

    /**
     * Setter for <code>public.calculation_modal.romi_attr_model</code>.
     */
    public CalculationModalRecord setRomiAttrModel(Double value) {
        set(17, value);
        return this;
    }

    /**
     * Getter for <code>public.calculation_modal.romi_attr_model</code>.
     */
    public Double getRomiAttrModel() {
        return (Double) get(17);
    }

    /**
     * Setter for <code>public.calculation_modal.income_ga</code>.
     */
    public CalculationModalRecord setIncomeGa(Double value) {
        set(18, value);
        return this;
    }

    /**
     * Getter for <code>public.calculation_modal.income_ga</code>.
     */
    public Double getIncomeGa() {
        return (Double) get(18);
    }

    /**
     * Setter for <code>public.calculation_modal.desktop_ga_transactions</code>.
     */
    public CalculationModalRecord setDesktopGaTransactions(Double value) {
        set(19, value);
        return this;
    }

    /**
     * Getter for <code>public.calculation_modal.desktop_ga_transactions</code>.
     */
    public Double getDesktopGaTransactions() {
        return (Double) get(19);
    }

    /**
     * Setter for <code>public.calculation_modal.mobile_ga_gransactions</code>.
     */
    public CalculationModalRecord setMobileGaGransactions(Double value) {
        set(20, value);
        return this;
    }

    /**
     * Getter for <code>public.calculation_modal.mobile_ga_gransactions</code>.
     */
    public Double getMobileGaGransactions() {
        return (Double) get(20);
    }

    /**
     * Setter for <code>public.calculation_modal.tablet_ga_transactions</code>.
     */
    public CalculationModalRecord setTabletGaTransactions(Double value) {
        set(21, value);
        return this;
    }

    /**
     * Getter for <code>public.calculation_modal.tablet_ga_transactions</code>.
     */
    public Double getTabletGaTransactions() {
        return (Double) get(21);
    }

    /**
     * Setter for <code>public.calculation_modal.place</code>.
     */
    public CalculationModalRecord setPlace(String value) {
        set(22, value);
        return this;
    }

    /**
     * Getter for <code>public.calculation_modal.place</code>.
     */
    public String getPlace() {
        return (String) get(22);
    }

    /**
     * Setter for <code>public.calculation_modal.budget_second</code>.
     */
    public CalculationModalRecord setBudgetSecond(Double value) {
        set(23, value);
        return this;
    }

    /**
     * Getter for <code>public.calculation_modal.budget_second</code>.
     */
    public Double getBudgetSecond() {
        return (Double) get(23);
    }

    /**
     * Setter for <code>public.calculation_modal.budget_third</code>.
     */
    public CalculationModalRecord setBudgetThird(Double value) {
        set(24, value);
        return this;
    }

    /**
     * Getter for <code>public.calculation_modal.budget_third</code>.
     */
    public Double getBudgetThird() {
        return (Double) get(24);
    }

    /**
     * Setter for <code>public.calculation_modal.budget_fourth</code>.
     */
    public CalculationModalRecord setBudgetFourth(Double value) {
        set(25, value);
        return this;
    }

    /**
     * Getter for <code>public.calculation_modal.budget_fourth</code>.
     */
    public Double getBudgetFourth() {
        return (Double) get(25);
    }

    /**
     * Setter for <code>public.calculation_modal.format_second</code>.
     */
    public CalculationModalRecord setFormatSecond(String value) {
        set(26, value);
        return this;
    }

    /**
     * Getter for <code>public.calculation_modal.format_second</code>.
     */
    public String getFormatSecond() {
        return (String) get(26);
    }

    /**
     * Setter for <code>public.calculation_modal.new_players</code>.
     */
    public CalculationModalRecord setNewPlayers(Double value) {
        set(27, value);
        return this;
    }

    /**
     * Getter for <code>public.calculation_modal.new_players</code>.
     */
    public Double getNewPlayers() {
        return (Double) get(27);
    }

    /**
     * Setter for <code>public.calculation_modal.version</code>.
     */
    public CalculationModalRecord setVersion(Integer value) {
        set(28, value);
        return this;
    }

    /**
     * Getter for <code>public.calculation_modal.version</code>.
     */
    public Integer getVersion() {
        return (Integer) get(28);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record9<LocalDate, LocalDate, String, String, String, String, String, String, Integer> key() {
        return (Record9) super.key();
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached CalculationModalRecord
     */
    public CalculationModalRecord() {
        super(CalculationModal.CALCULATION_MODAL);
    }

    /**
     * Create a detached, initialised CalculationModalRecord
     */
    public CalculationModalRecord(LocalDate dateStart, LocalDate dateEnd, String product, String campaign, String crm, String channel, String playground, String format, Double budget, Double gaTransactions, Double attrTransactionsModel, Double appTransactions, Integer effectiveFrequency, Double sales, Double averageCheck, Double cpa, Double romiGa, Double romiAttrModel, Double incomeGa, Double desktopGaTransactions, Double mobileGaGransactions, Double tabletGaTransactions, String place, Double budgetSecond, Double budgetThird, Double budgetFourth, String formatSecond, Double newPlayers, Integer version) {
        super(CalculationModal.CALCULATION_MODAL);

        setDateStart(dateStart);
        setDateEnd(dateEnd);
        setProduct(product);
        setCampaign(campaign);
        setCrm(crm);
        setChannel(channel);
        setPlayground(playground);
        setFormat(format);
        setBudget(budget);
        setGaTransactions(gaTransactions);
        setAttrTransactionsModel(attrTransactionsModel);
        setAppTransactions(appTransactions);
        setEffectiveFrequency(effectiveFrequency);
        setSales(sales);
        setAverageCheck(averageCheck);
        setCpa(cpa);
        setRomiGa(romiGa);
        setRomiAttrModel(romiAttrModel);
        setIncomeGa(incomeGa);
        setDesktopGaTransactions(desktopGaTransactions);
        setMobileGaGransactions(mobileGaGransactions);
        setTabletGaTransactions(tabletGaTransactions);
        setPlace(place);
        setBudgetSecond(budgetSecond);
        setBudgetThird(budgetThird);
        setBudgetFourth(budgetFourth);
        setFormatSecond(formatSecond);
        setNewPlayers(newPlayers);
        setVersion(version);
    }
}