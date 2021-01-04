import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class TestApiService {

    constructor(private httpClient: HttpClient) {
    }

    postFile(fileToUpload: File): Observable<any> {
        const formData: FormData = new FormData();
        formData.append('file', fileToUpload, fileToUpload.name);
        return this.httpClient.post(this.getUrl('/file'), formData);
    }

    getCountLinesInDb(): Observable<number> {
        return this.httpClient.get(this.getUrl('/count-lines')) as Observable<number>;
    }

    private getUrl = (path: string) => `/api/calculation${path}`;
}
