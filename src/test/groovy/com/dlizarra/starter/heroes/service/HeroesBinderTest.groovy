package com.dlizarra.starter.heroes.service

import com.dlizarra.starter.heroes.model.Hero
import org.junit.BeforeClass
import spock.lang.Specification

class HeroesBinderTest extends Specification {
    public HeroService heroesBinder

    void setup() {
        heroesBinder = new HeroesBinder()
        deletAllHeroes()
        assert heroesBinder.allHeroes.size() == 0
    }

    def "GetAllHeroes"() {
    expect: heroesBinder.getAllHeroes().size() == 0

    }
    def deletAllHeroes(){
            heroesBinder.getAllHeroes().clear()
    }
}
