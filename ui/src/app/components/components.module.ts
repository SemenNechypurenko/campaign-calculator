import {NgModule} from '@angular/core';

import {TextAreaFormFieldComponent} from './text-area-form-field/text-area-form-field.component';
import {InputFormFieldComponent} from './input-form-field/input-form-field.component';
import {CheckedFormFieldComponent} from './checked-form-field/checked-form-field.component';
import {AccordionComponent} from './accordion/accordion.component';
import {TabsComponent} from './tabs/tabs.component';
import {TabComponent} from './tab/tab.component';
import {ConfirmDeleteModalComponent} from './confirm-delete-modal/confirm-delete-modal.component';
import {SelectOvalItemComponent} from './select-oval-item/select-oval-item.component';
import {RadioGroupComponent} from './radio-group/radio-group.component';
import {InputAcronymFieldComponent} from './input-acronym-field/input-acronym-field.component';
import {InputFormFieldUniqueCheckComponent} from './input-form-field-unique-check/input-form-field-unique-check.component';
import {ConfirmInfoModalComponent} from './confim-info-modal/confirm-info-modal.component';
import {DateTimePickerComponent} from './date-time-picker/date-time-picker.component';
import {CustomToasterService} from './custom-toaster.service';
import {SharedModule} from '../shared/shared.module';


@NgModule({
    imports: [
        SharedModule,
    ],
    providers: [
        CustomToasterService
    ],
    declarations: [
        TextAreaFormFieldComponent,
        InputFormFieldComponent,
        CheckedFormFieldComponent,
        AccordionComponent,
        TabsComponent,
        TabComponent,
        ConfirmDeleteModalComponent,
        SelectOvalItemComponent,
        RadioGroupComponent,
        InputAcronymFieldComponent,
        InputFormFieldUniqueCheckComponent,
        ConfirmInfoModalComponent,
        DateTimePickerComponent,
    ],
    exports: [
        TextAreaFormFieldComponent,
        InputFormFieldComponent,
        CheckedFormFieldComponent,
        AccordionComponent,
        TabsComponent,
        TabComponent,
        SelectOvalItemComponent,
        RadioGroupComponent,
        InputAcronymFieldComponent,
        InputFormFieldUniqueCheckComponent,
        DateTimePickerComponent,

    ]
})
export class ComponentsModule {
    constructor() {
    }
}
