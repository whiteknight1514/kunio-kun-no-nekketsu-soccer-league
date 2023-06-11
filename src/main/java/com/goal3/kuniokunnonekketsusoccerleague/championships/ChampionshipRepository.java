package com.goal3.kuniokunnonekketsusoccerleague.championships;

import com.goal3.kuniokunnonekketsusoccerleague.utils.CustomRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChampionshipRepository extends
        JpaRepository<Championship, Short>,
        CustomRepository<Championship, Short> {
}
