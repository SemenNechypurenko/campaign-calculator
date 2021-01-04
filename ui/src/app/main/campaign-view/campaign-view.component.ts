import {Component, OnInit} from '@angular/core';
import {CampaignApiService} from './campaign-api.service';
import {CampaignProduct} from '../../domain/CampaignProduct';

@Component({
    selector: 'app-campaign-view',
    templateUrl: './campaign-view.component.html',
    styleUrls: ['./campaign-view.component.scss']
})
export class CampaignViewComponent implements OnInit {

    campaigns: CampaignProduct[];

    constructor(private campaignsApiService: CampaignApiService) { }

    ngOnInit(): void {
        this.campaignsApiService.list().subscribe(value => {
            this.campaigns = value;
         });
    }

}
