import {SharedModule} from '../shared/shared.module';
import {CoreModule} from '../core/core.module';
import {TableModule} from 'ngx-easy-table';

import {ComponentsModule} from '../components/components.module';
import {TestComponent} from './test/test.component';
import {CampaignViewComponent} from './campaign-view/campaign-view.component';
import {NgModule} from '@angular/core';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {CommonModule} from '@angular/common';
import {CampaignProductViewComponent} from './campaign-view/campaign-product-view/campaign-product-view.component';
import {CampaignEditComponent} from './campaign-edit/campaign-edit.component';

@NgModule({
    imports: [
        ReactiveFormsModule,
        CommonModule,
        FormsModule,
        SharedModule,
        CoreModule,
        TableModule,
        ComponentsModule,
    ],
    exports: [],
    declarations: [
        TestComponent,
        CampaignViewComponent,
        CampaignProductViewComponent,
        CampaignEditComponent
    ]
})

export class MainModule {
    constructor() {
    }
}
