import {Injectable} from '@angular/core';
import {HttpHeaders, HttpClient} from '@angular/common/http';

import {Hero} from './hero';
import {environment} from '../../environments/environment';

import 'rxjs/add/operator/toPromise';

@Injectable()
export class HeroService {
  private apiUrl = environment.API_URL;
  private heroesUrl = `${this.apiUrl}/api/heroes`;
  private headers = new HttpHeaders({'Content-Type': 'application/json'});


  constructor(private http: HttpClient) {
  }

  getHeroes(): Promise<Hero[]> {
    return this.http.get(this.heroesUrl)
      .toPromise()
      .then(response => response as Hero[])
      .catch(this.handleError);
  }

  getHero(id: number): Promise<Hero> {
    const url = `${ this.heroesUrl }/${ id }`;
    return this.http.get(url)
      .toPromise()
      .then(response => response as Hero)
      .catch(this.handleError);
  }

  update(hero: Hero): Promise<Hero> {
    const url = `${ this.heroesUrl }/${ hero.id }`;
    return this.http
      .put(url, JSON.stringify(hero), {headers: this.headers})
      .toPromise()
      .then(() => hero)
      .catch(this.handleError);
  }

  create(name: String): Promise<Hero> {
    return this.http
      .post(this.heroesUrl, JSON.stringify(name), {headers: this.headers})
      .toPromise()
      .then(res => res as Hero)
      .catch(this.handleError);
  }

  deleteHero(heroId: number): Promise<void> {
    const url = `${this.heroesUrl}/delete/${heroId}`;
    return this.http
      .delete(url, {headers: this.headers})
      .toPromise()
      .then(() => null)
      .catch(this.handleError);
  }

  private handleError(error: any): Promise<any> {
    console.error('An error occured: ', error);
    return Promise.reject(error.message || error);
  }
}
