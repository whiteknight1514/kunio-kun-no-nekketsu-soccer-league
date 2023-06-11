package com.goal3.kuniokunnonekketsusoccerleague.users;

import com.goal3.kuniokunnonekketsusoccerleague.utils.CustomRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Short>, CustomRepository<User, Short> {

    Optional<User> findByLogin(String login);
}
