package com.goal3.kuniokunnonekketsusoccerleague;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class KunioKunNoNekketsuSoccerLeagueApplication {

    public static final String API_BASE_PATH = "/api/v1"; //используется во всех контроллерах как базовая часть пути API

    public static void main(String[] args) {
        SpringApplication.run(KunioKunNoNekketsuSoccerLeagueApplication.class, args);
    }
}
