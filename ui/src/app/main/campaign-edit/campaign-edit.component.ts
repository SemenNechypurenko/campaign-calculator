import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {CampaignId} from '../../domain/Campaign';
import {CampaignProduct} from '../../domain/CampaignProduct';
import {CampaignApiService} from '../campaign-view/campaign-api.service';
import {Calculation} from '../../domain/Calculation.enum';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {SaveEditCampaignRequest} from '../../domain/request/SaveEditCampaignRequest';

@Component({
    selector: 'app-campaign-edit',
    templateUrl: './campaign-edit.component.html',
    styleUrls: ['./campaign-edit.component.scss']
})
export class CampaignEditComponent implements OnInit {

    campaign: CampaignProduct;
    calculationMethod: Calculation;
    checkoutForm: FormGroup;
    budget: number;
    weeks: number;
    updateCampaignRequest: SaveEditCampaignRequest;

    constructor(
        private campaignsApiService: CampaignApiService,
        private route: ActivatedRoute,
        private formBuilder: FormBuilder) {

    }

    private createForm() {
        this.checkoutForm = this.formBuilder.group({
                budget: [0, [Validators.min(0), Validators.pattern('^[0-9]*$')]],
                weeks: [0, [Validators.min(0), Validators.pattern('^[0-9]*$')]]
            }
        );
    }

    ngOnInit(): void {
        this.createForm();
        this.campaignsApiService.get(this.getCampaignId()).subscribe(value => {
            this.campaign = value;
            this.calculationMethod = this.campaign.calculationMethod;
            this.refreshForm();
        });
    }

    private refreshForm() {
        if (this.calculationMethod === Calculation.ATTRIBUTION) {
            this.getControl('budget').setValue(this.campaign.budget);
            this.getControl('weeks').setValue(0);
        }

        if (this.calculationMethod === Calculation.ECONOMETRIC) {
            this.getControl('budget').setValue(0);
            this.getControl('weeks').setValue(this.campaign.weeks);
        }

        if (this.calculationMethod === Calculation.MIXED) {
            this.getControl('budget').setValue(this.campaign.budget);
            this.getControl('weeks').setValue(this.campaign.weeks);
        }
    }

    getControl(name: string) {
        return this.checkoutForm.get(name);
    }

    getCampaignId(): CampaignId {
        return this.route.snapshot.params.campaignId;
    }

    onItemChanged(input: any) {
        this.calculationMethod = Calculation[input];
    }

    calculate() {
        if (this.checkoutForm.invalid) {
            this.checkoutForm.markAllAsTouched();
            return;
        }

        if (this.calculationMethod === Calculation.ATTRIBUTION
            || this.calculationMethod === Calculation.MIXED) {
            this.budget = this.checkoutForm.value.budget;
        }

        if (this.calculationMethod === Calculation.ECONOMETRIC
            || this.calculationMethod === Calculation.MIXED) {
            this.weeks = this.checkoutForm.value.weeks;
        }
    }

    saveCampaign() {
        if (this.checkoutForm.invalid) {
            this.checkoutForm.markAllAsTouched();
            return;
        }

        this.updateCampaignRequest = new SaveEditCampaignRequest();
        this.updateCampaignRequest.calculationMethod = this.calculationMethod;
        this.updateCampaignRequest.productCode = this.campaign.productCode;
        this.updateCampaignRequest.name = this.campaign.name;

        if (this.calculationMethod === Calculation.ATTRIBUTION) {
            this.updateCampaignRequest.budget = this.checkoutForm.value.budget;
            this.updateCampaignRequest.weeks = 0;
        }

        if (this.calculationMethod === Calculation.ECONOMETRIC) {
            this.updateCampaignRequest.budget = 0;
            this.updateCampaignRequest.weeks = this.checkoutForm.value.weeks;
        }

        if (this.calculationMethod === Calculation.MIXED) {
            this.updateCampaignRequest.weeks = this.checkoutForm.value.weeks;
            this.updateCampaignRequest.budget = this.checkoutForm.value.budget;
        }

        this.campaignsApiService
            .updateCampaign(this.campaign.id, this.updateCampaignRequest).subscribe(value => {
                    console.log('Campaign Updated');
                    this.ngOnInit();
                },
                error => {
                    console.log('Campaign Was Not Updated');
                }
            );
    }
}
