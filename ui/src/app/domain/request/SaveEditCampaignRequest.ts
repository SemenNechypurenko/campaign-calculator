import {ProductCode} from '../Product';
import {Calculation} from '../Calculation.enum';

export class SaveEditCampaignRequest {
    name: string;
    productCode: ProductCode;
    calculationMethod: Calculation;
    budget: number;
    weeks: number;
}
