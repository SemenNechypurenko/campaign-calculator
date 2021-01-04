package com.gramant.dentsuCampaignCalculator.adapters.web;

import com.gramant.dentsuCampaignCalculator.adapters.db.CalculationRepository;
import com.gramant.dentsuCampaignCalculator.app.CalculationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.URI;

@RestController
@RequestMapping("/api/calculation")
@RequiredArgsConstructor
public class CalculationResource {

    private final CalculationService calculationService;
    private final CalculationRepository calculationRepository;

    @PostMapping("/file")
    public ResponseEntity<?> loadFromExcel(@RequestParam("file") MultipartFile file) throws IOException {

//        calculationRepository.importFromCsv(file.getInputStream());
        calculationService.importFromCsv(file);

        return ResponseEntity.created(URI.create("")).build();
    }

    @GetMapping("/count-lines")
    public ResponseEntity<Integer> getCountLinesInDb(){
        return ResponseEntity.ok(calculationRepository.countLines());
    }
}
