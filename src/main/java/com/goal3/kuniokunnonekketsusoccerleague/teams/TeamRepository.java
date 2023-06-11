package com.goal3.kuniokunnonekketsusoccerleague.teams;

import com.goal3.kuniokunnonekketsusoccerleague.utils.CustomRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamRepository extends JpaRepository<Team, Short>, CustomRepository<Team, Short> {

    Team getByName(String name);

    Team getFirstByNekketsuTeamNotNull();
}
