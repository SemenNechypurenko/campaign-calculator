import {NgModule, Optional, SkipSelf} from '@angular/core';
import {SettingsService} from './settings/settings.service';
import {throwIfAlreadyLoaded} from './module-import-guard';
import {CustomToasterService} from '../components/custom-toaster.service';
import {CommonModule} from '@angular/common';
import {FormsModule} from '@angular/forms';
import {BsDatepickerModule} from 'ngx-bootstrap/datepicker';
import {TimepickerModule} from 'ngx-bootstrap/timepicker';


@NgModule({
    imports: [
        CommonModule,
        FormsModule,
        BsDatepickerModule,
        TimepickerModule
    ],
    providers: [
        SettingsService,
        CustomToasterService
    ],
    declarations: [],
    exports: []
})
export class CoreModule {
    constructor(@Optional() @SkipSelf() parentModule: CoreModule) {
        throwIfAlreadyLoaded(parentModule, 'CoreModule');
    }
}
