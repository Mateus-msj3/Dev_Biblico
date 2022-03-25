import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './components/login/login.component';
import { HomeComponent } from './components/home/home.component';
import { FormsModule } from '@angular/forms';
import { AuthService } from './shared/services/auth.service';
import { HttpClientModule } from '@angular/common/http';
import { NavbarComponent } from './components/navbar/navbar.component';
import { FooterComponent } from './components/footer/footer.component';
import { IndexComponent } from './components/index/index.component';
import {CardModule} from 'primeng/card';
import {ChartModule} from 'primeng/chart';
import {ButtonModule} from 'primeng/button';
import { AdminAreaComponent } from './components/admin-area/admin-area.component';
import {PanelModule} from 'primeng/panel';
import {SplitterModule} from 'primeng/splitter';
import {CarouselModule} from 'primeng/carousel';
import { UserAreaComponent } from './components/admin-area/user-area/user-area.component';


@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    HomeComponent,
    NavbarComponent,
    FooterComponent,
    IndexComponent,
    AdminAreaComponent,
    UserAreaComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    CardModule,
    ButtonModule,
    ChartModule,
    PanelModule,
    SplitterModule,
    CarouselModule

  ],
  providers: [
    AuthService,
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
