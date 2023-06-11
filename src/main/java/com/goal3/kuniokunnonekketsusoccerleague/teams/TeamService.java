package com.goal3.kuniokunnonekketsusoccerleague.teams;

import com.goal3.kuniokunnonekketsusoccerleague.exceptions.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamService {

    @Autowired
    private TeamRepository repository;

    public List<Team> getAll() {
        return repository.findAll();
    }

    public Team getByName(String name) {
        return repository.getByName(name);
    }

    public Team getNekketsuTeam() {
        Team nekketsuTeam = repository.getFirstByNekketsuTeamNotNull();

        if (nekketsuTeam == null) {
            throw new ValidationException("Nekketsu team", "Nekketsu team not found.")
                    .setStatus(HttpStatus.NOT_FOUND);
        }

        return nekketsuTeam;
    }
}
