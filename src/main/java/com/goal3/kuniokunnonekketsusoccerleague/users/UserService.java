package com.goal3.kuniokunnonekketsusoccerleague.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository repository;

    public List<User> getAll() {
        return repository.findAll();
    }
}
