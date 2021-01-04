package com.gramant.dentsuCampaignCalculator.adapters.web;

import com.gramant.dentsuCampaignCalculator.adapters.db.CampaignRepository;
import com.gramant.dentsuCampaignCalculator.adapters.db.ProductRepository;
import com.gramant.dentsuCampaignCalculator.adapters.db.data.CampaignJoinProductData;
import com.gramant.dentsuCampaignCalculator.adapters.web.representations.CampaignAndProductRepresentation;
import com.gramant.dentsuCampaignCalculator.adapters.web.representations.CampaignRepresentation;
import com.gramant.dentsuCampaignCalculator.domain.CalculationMethod;
import com.gramant.dentsuCampaignCalculator.domain.Campaign;
import com.gramant.dentsuCampaignCalculator.domain.CreateCampaignRequest;
import com.gramant.dentsuCampaignCalculator.domain.ids.CampaignId;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/api/campaigns")
@AllArgsConstructor
@Slf4j
public class CampaignResource {

    private final CampaignRepository campaignRepository;
    private final ProductRepository productRepository;

    @PostMapping
    public ResponseEntity<?> addCampaign(@RequestBody CreateCampaignRequest req) {

        if (campaignRepository.getByName(req.getName()).isPresent()) {
            return ResponseEntity.unprocessableEntity().body("Campaign with name ["
                    + req.getName() + "] already exists!");
        }

        if (productRepository.getById(req.getProductCode()).isEmpty()) {
            return ResponseEntity.unprocessableEntity().body("Product with code ["
                    + req.getProductCode().getValue() + "] does not exist!");
        }

        campaignRepository.add(req.asCampaign());
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public List<CampaignRepresentation> list() {
        return campaignRepository.list().stream().map(CampaignRepresentation::from).collect(Collectors.toList());
    }

    @GetMapping("/all")
    public List<CampaignAndProductRepresentation> extendedList() {

        return campaignRepository
                .extendedList()
                .stream()
                .map(CampaignAndProductRepresentation::from)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CampaignRepresentation> getCampaign(@PathVariable("id") CampaignId id) {
        return campaignRepository.getById(id)
                .map(campaign -> ResponseEntity.ok(CampaignRepresentation.from(campaign)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> removeCampaign(@PathVariable("id") CampaignId id) {
        if (campaignRepository.getById(id).isPresent()) {
            campaignRepository.remove(id.getValue());
        }

        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> replaceCampaign(@PathVariable("id") CampaignId id,
                                           @RequestBody CreateCampaignRequest req) {
        if (campaignRepository.getById(id).isEmpty()) {
            return ResponseEntity.unprocessableEntity().body("Campaign with id [" + id + "] does not exist!");
        }

        if (productRepository.getById(req.getProductCode()).isEmpty()) {
            return ResponseEntity.unprocessableEntity().body("Product with code [" + req.getProductCode() + "] does not exist!");
        }

        Campaign campaign = new Campaign(
                id,
                req.getName(), req.getProductCode(),
                CalculationMethod.valueOf(req.getCalculationMethod()),
                req.getBudget(),
                req.getWeeks());

        campaignRepository.update(campaign);

        return ResponseEntity.noContent().build();
    }

}
