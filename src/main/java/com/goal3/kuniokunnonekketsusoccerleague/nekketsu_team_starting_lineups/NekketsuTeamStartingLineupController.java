package com.goal3.kuniokunnonekketsusoccerleague.nekketsu_team_starting_lineups;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
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
    @PreAuthorize("hasAuthority('WRITE')")
    public void create(@Valid @RequestBody NekketsuTeamStartingLineup nekketsuTeamStartingLineup) {
        service.create(nekketsuTeamStartingLineup);
    }

    @PutMapping
    @PreAuthorize("hasAuthority('WRITE')")
    public void edit(@Valid @RequestBody NekketsuTeamStartingLineup nekketsuTeamStartingLineup) {
        service.edit(nekketsuTeamStartingLineup);
    }

    @GetMapping("/generate")
    @PreAuthorize("hasAuthority('GENERATE')")
    public NekketsuTeamStartingLineup generate() {
        return service.generate();
    }
}
