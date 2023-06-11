package com.goal3.kuniokunnonekketsusoccerleague.championships;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChampionshipService {

    @Autowired
    private ChampionshipRepository repository;

    public List<Championship> getAll() {
        return repository.findAll();
    }

    public void create(Championship championship) {
        repository.save(championship);
    }
}
