package com.goal3.kuniokunnonekketsusoccerleague.players;

import com.goal3.kuniokunnonekketsusoccerleague.teams.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class PlayerService {

    @Autowired
    private PlayerRepository repository;

    public List<Player> getAllByTeamAndPlayerPosition(Team team, PlayerPosition playerPosition) {
        return repository.getAllByTeamAndPlayerPosition(team, playerPosition);
    }

    public Set<Player> getNonNekketsuTeamPlayers(Set<Player> players) {
        return repository.getNonNekketsuTeamPlayers(players);
    }
}
