import {NgModule} from '@angular/core';

import {LayoutComponent} from './layout.component';
import {SidebarComponent} from './sidebar/sidebar.component';
import {HeaderComponent} from './header/header.component';
import {UserblockComponent} from './sidebar/userblock/userblock.component';
import {UserblockService} from './sidebar/userblock/userblock.service';
import {FooterComponent} from './footer/footer.component';

import {SharedModule} from '../shared/shared.module';
import {CoreModule} from '../core/core.module';
import {SinglePageLayoutComponent} from './single-page-layout/single-page-layout.component';
import {AppLayoutComponent} from './app-layout/app-layout.component';

@NgModule({
    imports: [
        SharedModule,
        CoreModule,
    ],
    providers: [
        UserblockService
    ],
    declarations: [
        LayoutComponent,
        SidebarComponent,
        UserblockComponent,
        HeaderComponent,
        FooterComponent,
        SinglePageLayoutComponent,
        AppLayoutComponent
    ],
    exports: [
        LayoutComponent,
        SidebarComponent,
        UserblockComponent,
        HeaderComponent,
        FooterComponent
    ]
})
export class LayoutModule {
}
