import {NotFoundPageComponent} from '../pages/not-found/not-found-page.component';
import {Route} from '@angular/router';
import {ForbiddenPageComponent} from '../pages/forbidden-page/forbidden-page.component';
import {AppLayoutComponent} from '../layout/app-layout/app-layout.component';
import {TestComponent} from '../main/test/test.component';
import {CampaignViewComponent} from '../main/campaign-view/campaign-view.component';
import {CampaignEditComponent} from '../main/campaign-edit/campaign-edit.component';

export const routes: Route [] = [

    // {path: '', component: TestComponent},
    {
        path: '',
        component: AppLayoutComponent,
        children: [
            {path: '', component: TestComponent},
            {path: 'campaigns', component: CampaignViewComponent},
            {path: 'campaigns/:campaignId', component: CampaignEditComponent},
        ]
    },

// Not found
    {path: '404', component: NotFoundPageComponent},
// forbidden
    {path: '403', component: ForbiddenPageComponent},

    {path: '**', redirectTo: '404'},
];
