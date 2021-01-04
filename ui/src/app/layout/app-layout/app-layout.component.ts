import {Component, OnInit} from '@angular/core';
import {Router} from '@angular/router';


@Component({
    selector: 'app-app-layout',
    templateUrl: './app-layout.component.html',
    styleUrls: ['./app-layout.component.scss']
})
export class AppLayoutComponent implements OnInit {

    min = false;

    constructor(private router: Router) {
    }

    ngOnInit() {


    }

    changeStatusMin() {
        this.min = !this.min;

        const body = document.getElementsByTagName('body')[0];

        if (this.min) {
            body.classList.add('mini-navbar');
        } else {
            body.classList.remove('mini-navbar');
        }
    }

    activeRoute(routename: string): boolean {
        return this.router.url.indexOf(routename) > -1;
    }

    }

