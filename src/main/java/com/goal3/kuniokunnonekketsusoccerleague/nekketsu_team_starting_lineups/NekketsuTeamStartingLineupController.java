package com.goal3.kuniokunnonekketsusoccerleague.nekketsu_team_starting_lineups;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import static com.goal3.kuniokunnonekketsusoccerleague.KunioKunNoNekketsuSoccerLeagueApplication.API_BASE_PATH;

@RestController
@RequestMapping(API_BASE_PATH + "/nekketsu-team-starting-lineups")
public class NekketsuTeamStartingLineupController {

    @Autowired
    private NekketsuTeamStartingLineupService service;

    @PostMapping
    public void create(@Valid @RequestBody NekketsuTeamStartingLineup nekketsuTeamStartingLineup) {
        service.create(nekketsuTeamStartingLineup);
    }

    @PutMapping
    public void edit(@Valid @RequestBody NekketsuTeamStartingLineup nekketsuTeamStartingLineup) {
        service.edit(nekketsuTeamStartingLineup);
    }

    @GetMapping("/generate")
    public NekketsuTeamStartingLineup generate() {
        return service.generate();
    }
}
