package com.dlizarra.starter.heroes.controller;


import com.dlizarra.starter.exceptions.HeroNotFoundException;
import com.dlizarra.starter.heroes.model.Hero;
import com.dlizarra.starter.heroes.service.HeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api")
public class HeroesController {

    @Autowired
    HeroService heroService;

    @GetMapping(value = "/heroes", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Hero>> getAllHeroes() {
        List<Hero> allHeroes = heroService.getAllHeroes();
        if (!allHeroes.isEmpty()) return new ResponseEntity<List<Hero>>(allHeroes, HttpStatus.OK);
        else return new ResponseEntity<List<Hero>>(HttpStatus.NO_CONTENT);
    }

    @GetMapping(value = "/heroes/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Hero> getHero(@PathVariable int id) {
        try {
            return new ResponseEntity<Hero>(heroService.getHeroById(id), HttpStatus.OK);
        } catch (HeroNotFoundException e) {
            return new ResponseEntity<Hero>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping(value = "/heroes/{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Hero> updateHero(@RequestBody Hero hero) {
        try {
            return new ResponseEntity<Hero>(heroService.updateHero(hero), HttpStatus.OK);
        } catch (HeroNotFoundException e) {
            e.printStackTrace();
            return new ResponseEntity<Hero>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(value = "/heroes/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Hero> deleteHero(@PathVariable int id) {
        try {
            return new ResponseEntity<Hero>(heroService.deleteHero(id), HttpStatus.OK);
        } catch (HeroNotFoundException e) {
            e.printStackTrace();
            return new ResponseEntity<Hero>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<Hero>(HttpStatus.EXPECTATION_FAILED);
        }
    }

}
