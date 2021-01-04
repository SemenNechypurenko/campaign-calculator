import {ProductCode} from './Product';
import {Calculation} from './Calculation.enum';
import {CampaignId} from './Campaign';

export class CampaignProduct {
    id: CampaignId;
    name: string;
    productCode: ProductCode;
    calculationMethod: Calculation;
    budget: number;
    weeks: number;
    productName: string;
}

