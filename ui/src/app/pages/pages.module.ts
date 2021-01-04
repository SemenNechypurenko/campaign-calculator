import {NgModule} from '@angular/core';
import {NotFoundPageComponent} from './not-found/not-found-page.component';
import {RouterModule} from '@angular/router';
import {ReactiveFormsModule} from '@angular/forms';
import {CommonModule} from '@angular/common';
import {SharedModule} from '../shared/shared.module';
import {ValidatorsModule} from '../validators/validators.module';
import {CoreModule} from '../core/core.module';
import {ForbiddenPageComponent} from './forbidden-page/forbidden-page.component';

@NgModule({
    imports: [
        ReactiveFormsModule,
        CommonModule,
        SharedModule,
        ValidatorsModule,
        CoreModule,
    ],
    exports: [
        RouterModule
    ],
    declarations: [
        NotFoundPageComponent,
        ForbiddenPageComponent
    ]
})

export class PagesModule {
    constructor() {
    }
}

