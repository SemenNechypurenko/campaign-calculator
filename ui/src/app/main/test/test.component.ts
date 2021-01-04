import {Component, ElementRef, OnInit, ViewChild} from '@angular/core';
import {RequestStatuses} from '../../components/RequestStatuses';
import {ActivatedRoute, Router} from '@angular/router';
import {FormBuilder} from '@angular/forms';
import {CustomToasterService} from '../../components/custom-toaster.service';
import {TestApiService} from './test-api.service';
import {finalize} from 'rxjs/operators';
import {HttpErrorResponse} from '@angular/common/http';

@Component({
    selector: 'app-test',
    templateUrl: './test.component.html',
    styleUrls: ['./test.component.scss']
})
export class TestComponent implements OnInit {
    @ViewChild('fileImport') fileImportElement: ElementRef;

    getCountLinesInDbRequestStatuses = RequestStatuses.new();

    countLinesInDb: number;


    constructor(private router: Router,
                private route: ActivatedRoute,
                private formBuilder: FormBuilder,
                private customToasterService: CustomToasterService,
                private testApiService: TestApiService
    ) {
    }

    ngOnInit(): void {
        this.updateCountLinesInDb();
    }

    updateCountLinesInDb() {
        this.getCountLinesInDbRequestStatuses.addCheckStat(this.testApiService.getCountLinesInDb())
            .subscribe(value => {
                    this.countLinesInDb = value;
                },
                error => {
                    if (error instanceof HttpErrorResponse) {
                        const err = error as HttpErrorResponse;
                        this.customToasterService.popHttpErrorResponse(err);
                    }
                }
            );
    }


    uploadFile(files: any) {
        this.testApiService.postFile(files.item(0)).pipe(
            finalize(() => this.fileImportElement.nativeElement.value = '')
        ).subscribe(res => {
            this.customToasterService.popSuccess('File upload');
            this.updateCountLinesInDb();
        }, error => {
            if (error.status === 406 || error.status === 404) {
                this.customToasterService.popError('File not upload');
            } else {
                this.customToasterService.popHttpErrorResponse(error);
            }
        });
    }
}
