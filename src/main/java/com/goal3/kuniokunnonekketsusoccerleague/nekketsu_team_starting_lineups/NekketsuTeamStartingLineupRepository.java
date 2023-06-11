package com.goal3.kuniokunnonekketsusoccerleague.nekketsu_team_starting_lineups;

import com.goal3.kuniokunnonekketsusoccerleague.utils.CustomRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NekketsuTeamStartingLineupRepository extends
        JpaRepository<NekketsuTeamStartingLineup, Short>,
        CustomRepository<NekketsuTeamStartingLineup, Short> {
}
