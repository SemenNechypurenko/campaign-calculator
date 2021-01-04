import {AppComponent} from './app.component';

import {CoreModule} from './core/core.module';
import {LayoutModule} from './layout/layout.module';
import {SharedModule} from './shared/shared.module';
import {RoutesModule} from './routes/routes.module';
import {LOCALE_ID, NgModule} from '@angular/core';
import {HTTP_INTERCEPTORS, HttpClientModule} from '@angular/common/http';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {ToasterModule, ToasterService} from 'angular2-toaster';
import {BsDropdownModule} from 'ngx-bootstrap/dropdown';

import {InterceptorCatchUserNotLogin} from './Interceptors/Interceptor-catch-user-not-login';
import {PagesModule} from './pages/pages.module';
import {MainModule} from './main/main.module';

import {InterceptorCatch502ErrorInterceptor} from './Interceptors/interceptor-catch502-error.interceptor';
import {InterceptorCatch504ErrorInterceptor} from './Interceptors/interceptor-catch504-error.interceptor';
import localeRu from '@angular/common/locales/ru';
import {registerLocaleData} from '@angular/common';
registerLocaleData(localeRu);

@NgModule({
    declarations: [
        AppComponent
    ],
    imports: [
        HttpClientModule,
        BrowserAnimationsModule, // required for ng2-tag-input
        CoreModule,
        LayoutModule,
        ToasterModule.forRoot(),
        SharedModule.forRoot(),
        RoutesModule,
        ToasterModule.forRoot(),
        BsDropdownModule.forRoot(),
        PagesModule,
        MainModule,
    ],
    providers: [
        { provide: LOCALE_ID, useValue: 'ru' },
        ToasterService,
        {
            provide: HTTP_INTERCEPTORS,
            useClass: InterceptorCatchUserNotLogin,
            multi: true
        },
        {
            provide: HTTP_INTERCEPTORS,
            useClass: InterceptorCatch502ErrorInterceptor,
            multi: true
        },
        {

            provide: HTTP_INTERCEPTORS,
            useClass: InterceptorCatch504ErrorInterceptor,
            multi: true
        },
    ],
    exports: [],
    bootstrap: [AppComponent]
})
export class AppModule {
}
