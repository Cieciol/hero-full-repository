package com.dlizarra.starter.heroes.service;

import com.dlizarra.starter.exceptions.HeroNotFoundException;
import com.dlizarra.starter.heroes.model.Hero;

import java.util.List;

public interface HeroService {
    List<Hero> getAllHeroes();
    Hero getHeroById(int id) throws HeroNotFoundException;
    Hero updateHero(Hero hero) throws HeroNotFoundException;
    Hero deleteHero(int id) throws HeroNotFoundException, Exception;
    Hero addHero(String heroName)throws Exception;
}
