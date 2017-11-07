import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {FormsModule} from '@angular/forms';
import {HttpModule} from '@angular/http';

import {HeroesComponent} from './heroes/heroes.component';
import {HeroDetailComponent} from './hero-detail/hero-detail.component';
import {AppComponent} from './app.component';
import {HeroService} from './hero/hero.service';
import {DashboardComponent} from './dashboard/dashboard.component';
import {AppRoutingModule} from './app-routing.module';
import {HttpClientModule} from '@angular/common/http';
import {HeroesSearchComponent} from './heroes-search/heroes-search.component';
//import {InMemoryDataService} from "./hero/in-memory-data.service";
import {InMemoryWebApiModule} from "angular-in-memory-web-api";
@NgModule({
  declarations: [
    AppComponent,
    HeroesComponent,
    HeroDetailComponent,
    DashboardComponent,
    HeroesSearchComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
     HttpClientModule,
 //   InMemoryWebApiModule.forRoot(InMemoryDataService),
    AppRoutingModule
  ],
  providers: [HeroService],
  bootstrap: [AppComponent]
})


export class AppModule {
}
