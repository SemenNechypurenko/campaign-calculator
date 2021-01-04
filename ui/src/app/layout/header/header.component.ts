import {UserblockService} from '../sidebar/userblock/userblock.service';
import {SettingsService} from '../../core/settings/settings.service';
import {Component, Injector, OnInit, ViewChild} from '@angular/core';
import {Router} from '@angular/router';

@Component({
    selector: 'app-header',
    templateUrl: './header.component.html',
    styleUrls: ['./header.component.scss']
})
export class HeaderComponent implements OnInit {
    navCollapsed = true; // for horizontal layout

    router: Router;

    year: number;

    isNavSearchVisible: boolean;
    @ViewChild('fsbutton', {static: true}) fsbutton;  // the fullscreen button

    constructor(public userBlockService: UserblockService,
                public settings: SettingsService,
                public injector: Injector) {

    }

    ngOnInit() {
        this.isNavSearchVisible = false;

        const ua = window.navigator.userAgent;
        if (ua.indexOf('MSIE ') > 0 || !!ua.match(/Trident.*rv\:11\./)) { // Not supported under IE
            this.fsbutton.nativeElement.style.display = 'none';
        }

        // Switch fullscreen icon indicator
        // const el = this.fsbutton.nativeElement.firstElementChild;
        // screenfull.on('change', () => {
        //     if (el) {
        //         el.className = screenfull.isFullscreen ? 'fa fa-compress' : 'fa fa-expand';
        //     }
        // });

        this.router = this.injector.get(Router);

        // Autoclose navbar on mobile when route change
        this.router.events.subscribe((val) => {
            // scroll view to top
            window.scrollTo(0, 0);
            // close collapse menu
            this.navCollapsed = true;
        });

    }


    toggleUserBlock(event) {
        event.preventDefault();
        this.userBlockService.toggleVisibility();
    }

    openNavSearch(event) {
        event.preventDefault();
        event.stopPropagation();
        this.setNavSearchVisible(true);
    }

    setNavSearchVisible(stat: boolean) {
        // console.log(stat);
        this.isNavSearchVisible = stat;
    }

    getNavSearchVisible() {
        return this.isNavSearchVisible;
    }

    toggleOffsidebar() {
        this.settings.toggleLayoutSetting('offsidebarOpen');
    }

    toggleCollapsedSideabar() {
        this.settings.toggleLayoutSetting('isCollapsed');
    }

    isCollapsedText() {
        return this.settings.getLayoutSetting('isCollapsedText');
    }


}

