import {Component, Input} from '@angular/core';
import {CampaignProduct} from '../../../domain/CampaignProduct';

@Component({
    selector: 'app-campaign-product-view',
    templateUrl: './campaign-product-view.component.html',
    styleUrls: ['./campaign-product-view.component.scss']
})
export class CampaignProductViewComponent {

    @Input()
    campaign: CampaignProduct;

    constructor() {
    }

}
