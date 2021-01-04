package com.gramant.dentsuCampaignCalculator.app;

import com.gramant.dentsuCampaignCalculator.domain.Calculation;
import com.gramant.dentsuCampaignCalculator.domain.Percentage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Slf4j
@Service
@RequiredArgsConstructor
public class CalculationImportService {

    private static final int DATE_START = 0;
    private static final int DATE_END = 1;
    private static final int PRODUCT = 2;
    private static final int CAMPAIGN = 3;
    private static final int CRM = 4;
    private static final int CHANNEL = 5;
    private static final int PLAYGROUND = 6;
    private static final int FORMAT = 7;
    private static final int BUDGET = 8;
    private static final int GA_TRANSACTIONS = 9;
    private static final int ATTR_TRANSACTIONS_MODEL = 10;
    private static final int APP_TRANSACTIONS = 11;
    private static final int EFFECTIVE_FREQUENCY = 12;
    private static final int SALES = 13;
    private static final int AVERAGE_CHECK = 14;
    private static final int CPA = 15;
    private static final int ROMI_GA = 16;
    private static final int ROMI_ATTR_MODEL = 17;
    private static final int INCOME_GA = 18;
    private static final int DESKTOP_GA_TRANSACTIONS = 19;
    private static final int MOBILE_GA_TRANSACTIONS = 20;
    private static final int TABLET_GA_TRANSACTIONS = 21;
    private static final int PLACE = 22;
    private static final int BUDGET_SECOND = 23;
    private static final int BUDGET_THIRD = 24;
    private static final int BUDGET_FOURTH = 25;
    private static final int FORMAT_SECOND = 26;
    private static final int NEW_PLAYERS = 27;
    private static final int VERSION = 28;


    public Calculation createFromCsvCSVRecord(CSVRecord csvRecord) {
        try {
            return new Calculation(
                    stringToRuDate(csvRecord.get(DATE_START)),
                    stringToRuDate(csvRecord.get(DATE_END)),
                    csvRecord.get(PRODUCT),
                    csvRecord.get(CAMPAIGN),
                    csvRecord.get(CRM),
                    csvRecord.get(CHANNEL),
                    csvRecord.get(PLAYGROUND),
                    csvRecord.get(FORMAT),
                    stringToDouble(csvRecord.get(BUDGET)),
                    stringToDouble(csvRecord.get(GA_TRANSACTIONS)),
                    stringToDouble(csvRecord.get(ATTR_TRANSACTIONS_MODEL)),
                    stringToDouble(csvRecord.get(APP_TRANSACTIONS)),
                    Integer.parseInt(csvRecord.get(EFFECTIVE_FREQUENCY)),
                    stringToDouble(csvRecord.get(SALES)),
                    stringToDouble(csvRecord.get(AVERAGE_CHECK)),
                    stringToDouble(csvRecord.get(CPA)),
                    stringToPercentage(csvRecord.get(ROMI_GA)),
                    stringToPercentage(csvRecord.get(ROMI_ATTR_MODEL)),
                    stringToDouble(csvRecord.get(INCOME_GA)),
                    stringToDouble(csvRecord.get(DESKTOP_GA_TRANSACTIONS)),
                    stringToDouble(csvRecord.get(MOBILE_GA_TRANSACTIONS)),
                    stringToDouble(csvRecord.get(TABLET_GA_TRANSACTIONS)),
                    csvRecord.get(PLACE),
                    stringToDouble(csvRecord.get(BUDGET_SECOND)),
                    stringToDouble(csvRecord.get(BUDGET_THIRD)),
                    stringToDouble(csvRecord.get(BUDGET_FOURTH)),
                    csvRecord.get(FORMAT_SECOND),
                    stringToDouble(csvRecord.get(NEW_PLAYERS)),
                    1
            );

        } catch (NullPointerException e) {
            throw new IllegalStateException("error then try parse Csv Line");
        }
    }

    private static LocalDate stringToRuDate(String str){
        return LocalDate.parse(str, DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }

    private static Double stringToDouble(String str){
        return Double.parseDouble(str.replace(",", "."));
    }

    private static Percentage stringToPercentage(String str){
        return Percentage.from(str);
    }
}
