package com.goal3.kuniokunnonekketsusoccerleague.players;

import com.goal3.kuniokunnonekketsusoccerleague.teams.Team;
import com.goal3.kuniokunnonekketsusoccerleague.utils.CustomRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Short>, CustomRepository<Player, Short> {

    List<Player> getAllByTeamAndPlayerPosition(Team team, PlayerPosition playerPosition);

    @Query(
            value = "SELECT * FROM players WHERE id in ?1 AND NOT team_id IN (SELECT team_id FROM nekketsu_teams)",
            nativeQuery = true
    )
    Set<Player> getNonNekketsuTeamPlayers(Set<Player> players);
}
