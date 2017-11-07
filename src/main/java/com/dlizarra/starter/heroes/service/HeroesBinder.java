package com.dlizarra.starter.heroes.service;

import com.dlizarra.starter.exceptions.HeroNotFoundException;
import com.dlizarra.starter.heroes.model.Hero;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@Service("heroService")
public class HeroesBinder implements HeroService {
    private List<Hero> heroes =new LinkedList<>(Arrays.asList(
            new Hero(0, "zero"),
            new Hero(1, "Adam"),
            new Hero(2, "Joanna"),
            new Hero(3, "Kamil"),
            new Hero(4, "Kinga"),
            new Hero(5, "Adrian")));

    public List<Hero> getAllHeroes() {
        return heroes;
    }

    @Override
    public Hero getHeroById(int id) throws HeroNotFoundException {
        Hero returnedHero = heroes.stream()
                .filter(hero -> hero.getId() == id)
                .collect(Collectors.toList()).get(0);
        if (returnedHero == null) throw new HeroNotFoundException();
        else return returnedHero;

    }

    @Override
    public Hero updateHero(Hero hero) throws HeroNotFoundException {
            Hero updated = this.getHeroById(hero.getId());
        updated.setName(hero.getName());
        return updated;
    }

    @Override
    public Hero deleteHero(int id) throws HeroNotFoundException, Exception {
        Hero deletedHero = this.getHeroById(id);
        if(!heroes.remove(deletedHero))throw new Exception("problems with deleting hero occured");
        return deletedHero;
    }
}