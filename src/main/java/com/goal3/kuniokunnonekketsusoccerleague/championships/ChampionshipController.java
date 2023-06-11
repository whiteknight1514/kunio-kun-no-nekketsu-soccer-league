package com.goal3.kuniokunnonekketsusoccerleague.championships;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

import static com.goal3.kuniokunnonekketsusoccerleague.KunioKunNoNekketsuSoccerLeagueApplication.API_BASE_PATH;

@RestController
@RequestMapping(API_BASE_PATH + "/championships")
public class ChampionshipController {

    @Autowired
    private ChampionshipService service;

    @GetMapping
    public List<Championship> getAll() {
        return service.getAll();
    }

    @PostMapping
    public void create(@Valid @RequestBody Championship championship) {
        service.create(championship);
    }
}
