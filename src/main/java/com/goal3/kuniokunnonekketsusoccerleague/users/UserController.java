package com.goal3.kuniokunnonekketsusoccerleague.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.goal3.kuniokunnonekketsusoccerleague.KunioKunNoNekketsuSoccerLeagueApplication.API_BASE_PATH;

@RestController
@RequestMapping(API_BASE_PATH + "/users")
public class UserController {

    @Autowired
    UserService service;

    @GetMapping
    @PreAuthorize("hasAuthority('WRITE')")
    public List<User> getAll() {
        return service.getAll();
    }
}
