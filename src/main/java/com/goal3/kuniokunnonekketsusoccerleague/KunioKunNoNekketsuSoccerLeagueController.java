package com.goal3.kuniokunnonekketsusoccerleague;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.goal3.kuniokunnonekketsusoccerleague.KunioKunNoNekketsuSoccerLeagueApplication.API_BASE_PATH;

@RestController
@RequestMapping(API_BASE_PATH + "/home")
public class KunioKunNoNekketsuSoccerLeagueController {

    @GetMapping()
    public String home() {
        return "Kunio-kun no Nekketsu Soccer League (Goal 3)";
    }
}
