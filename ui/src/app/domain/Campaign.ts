import {ProductCode} from './Product';
import {Calculation} from './Calculation.enum';

export class Campaign {
    id: CampaignId;
    name: string;
    productCode: ProductCode;
    calculationMethod: Calculation;
    budget: number;
    weeks: number;
}

export type CampaignId = string;

