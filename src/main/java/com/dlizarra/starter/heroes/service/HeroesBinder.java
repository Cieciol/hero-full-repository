package com.dlizarra.starter.heroes.service;

import com.dlizarra.starter.heroes.model.Hero;
import org.springframework.stereotype.Service;

@Service("heroService")
public class HeroesBinder implements HeroService{

    public Hero[] getAllHeroes() {
        Hero[] heroes = {
                new Hero(0, "zero"),
                new Hero(1, "Adam"),
                new Hero(2, "Joanna"),
                new Hero(3, "Kamil"),
                new Hero(4, "Kinga"),
                new Hero(5, "Adrian"),
        };
        return heroes;
    }
}
