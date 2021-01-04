package com.gramant.dentsuCampaignCalculator.app;

import com.gramant.dentsuCampaignCalculator.adapters.db.CalculationRepository;
import lombok.RequiredArgsConstructor;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CalculationService {

    private final CalculationImportService calculationImportService;
    private final CalculationRepository calculationRepository;

    public void importFromCsv(MultipartFile file) {
        try {
            CSVParser csvRecords = new CSVParser(new InputStreamReader(file.getInputStream()), CSVFormat.DEFAULT);
            List<CSVRecord> records = csvRecords.getRecords();
            calculationRepository.insertCalculations(records.stream()
                    .skip(1)
                    .map(calculationImportService::createFromCsvCSVRecord)
                    .collect(Collectors.toList()));

        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }
}
