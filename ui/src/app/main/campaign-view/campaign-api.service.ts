import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {CampaignProduct} from '../../domain/CampaignProduct';
import {CampaignId} from '../../domain/Campaign';
import {SaveEditCampaignRequest} from '../../domain/request/SaveEditCampaignRequest';

@Injectable({
    providedIn: 'root'
})
export class CampaignApiService {

    constructor(private http: HttpClient
    ) {
    }

    list(): Observable<CampaignProduct[]> {
        return this.http.get(this.getUrl('/all')) as Observable<CampaignProduct[]>;
    }

    get(campaignId: CampaignId): Observable<CampaignProduct> {
        return this.http.get(this.getUrl('/' + campaignId)) as Observable<CampaignProduct>;
    }

    updateCampaign(campaignId: CampaignId, request: SaveEditCampaignRequest): Observable<any> {
        return this.http.put(this.getUrl('/' + campaignId), request);
    }

    private getUrl = (path: string) => '/api/campaigns' + path;
}
