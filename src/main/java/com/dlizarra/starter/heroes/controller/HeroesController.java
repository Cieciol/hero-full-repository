package com.dlizarra.starter.heroes.controller;


import com.dlizarra.starter.heroes.model.Hero;
import com.dlizarra.starter.heroes.service.HeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api")
public class HeroesController {

    @Autowired
    HeroService heroService;

    @GetMapping(value = "/heroes", produces = "application/json")
    public Hero[] getAllHeroes() {
        return heroService.getAllHeroes();
    }

}
