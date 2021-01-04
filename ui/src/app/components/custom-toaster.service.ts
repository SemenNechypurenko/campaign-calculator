import {Injectable} from '@angular/core';
import {ToasterService} from 'angular2-toaster';
import {HttpErrorResponse} from '@angular/common/http';
import {UtilsService} from './utils.service';

@Injectable({
    providedIn: 'root'
})
export class CustomToasterService {
    private static ERROR_TITLE_TRANSLATE_KEY = 'toaster.title.error';
    private static SUCCESS_TITLE_TRANSLATE_KEY = 'toaster.title.success';

    private static FORBIDDEN_TRANSLATE_KEY = 'toaster.body.error.forbidden';
    private static UNKNOWN_TRANSLATE_KEY = 'toaster.body.error.unknown';

    constructor(private toasterService: ToasterService
    ) {
    }

    public popSuccess(bodyKey: string) {
        const errorMessageTitle = CustomToasterService.SUCCESS_TITLE_TRANSLATE_KEY;
        const errorMessageBody = bodyKey;

        this.toasterService.pop('success', errorMessageTitle, errorMessageBody);
    }

    public popError(bodyKey: string) {
        const errorMessageTitle = CustomToasterService.ERROR_TITLE_TRANSLATE_KEY;
        this.toasterService.pop('error', errorMessageTitle, bodyKey);
    }

    public popErrorText(text: string) {
        const errorMessageTitle = CustomToasterService.ERROR_TITLE_TRANSLATE_KEY;

        this.toasterService.pop('error', errorMessageTitle, text);
    }

    public popErrorForbidden() {
        const errorMessageTitle = CustomToasterService.ERROR_TITLE_TRANSLATE_KEY;
        const errorMessageBody = CustomToasterService.FORBIDDEN_TRANSLATE_KEY;

        this.toasterService.pop('error', errorMessageTitle, errorMessageBody);
    }

    public popHttpErrorResponse(error: HttpErrorResponse) {
        if (error instanceof HttpErrorResponse) {
            let errorMessageTitle = CustomToasterService.ERROR_TITLE_TRANSLATE_KEY;

            errorMessageTitle = errorMessageTitle + ' ' + error.statusText;

            this.toasterService.pop('error', errorMessageTitle, UtilsService.getErrorText(error));
        } else {
            const errorMessageTitle = CustomToasterService.ERROR_TITLE_TRANSLATE_KEY;
            const errorMessageBody = CustomToasterService.UNKNOWN_TRANSLATE_KEY;

            this.toasterService.pop('error', errorMessageTitle, errorMessageBody);
        }
    }
}
