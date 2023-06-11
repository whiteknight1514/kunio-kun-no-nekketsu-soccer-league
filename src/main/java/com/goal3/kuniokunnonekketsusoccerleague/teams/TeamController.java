package com.goal3.kuniokunnonekketsusoccerleague.teams;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.goal3.kuniokunnonekketsusoccerleague.KunioKunNoNekketsuSoccerLeagueApplication.API_BASE_PATH;

@RestController
@RequestMapping(API_BASE_PATH + "/teams")
public class TeamController {

    @Autowired
    private TeamService service;

    @GetMapping
    public List<Team> getAll() {
        return service.getAll();
    }

    @GetMapping("/{name}")
    public Team getByName(@PathVariable String name) {
        return service.getByName(name);
    }
}
