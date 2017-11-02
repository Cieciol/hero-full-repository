///<reference path="../../../node_modules/rxjs/add/operator/debounceTime.d.ts"/>
import {Component, OnInit} from '@angular/core';
import {Router} from '@angular/router';

import {Observable} from 'rxjs/Observable';
import {Subject} from 'rxjs/Subject';
import 'rxjs/add/observable/of';
import 'rxjs/add/operator/catch';
import 'rxjs/add/operator/debounceTime';
import 'rxjs/add/operator/distinctUntilChanged';
import 'rxjs/add/operator/switchMap';

import {HeroesSearchService} from './heroes-search.service';
import {Hero} from '../hero/hero';

@Component({
  selector: 'heroes-search',
  templateUrl: './heroes-search.component.html',
  styleUrls: ['./heroes-search.component.css'],
  providers: [HeroesSearchService]
})

export class HeroesSearchComponent implements OnInit {
  constructor(private heroSearchService: HeroesSearchService, private router: Router) {
  }

  heroes: Observable<Hero[]>;
  private searchTerms = new Subject<string>();


  ngOnInit(): void {
    this.heroes = this.searchTerms
      .debounceTime(300)
      .distinctUntilChanged()
      .switchMap(term => {
        return term ? this.heroSearchService.search(term) : Observable.of<Hero[]>([]);
      })
      .catch(error => {
        console.error('eror', error.message);
        return Observable.of<Hero[]>([]);
      });
  }

  search(terms: string): void {
    this.searchTerms.next(terms);
  }

  gotoDetail(hero: Hero): void {
    const link = ['/detail', hero.id];
    this.router.navigate(link);
  }
}
