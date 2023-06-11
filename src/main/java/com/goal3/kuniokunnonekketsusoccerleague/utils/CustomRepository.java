package com.goal3.kuniokunnonekketsusoccerleague.utils;

import org.webjars.NotFoundException;

import java.util.Optional;

public interface CustomRepository<T, ID> {
    Optional<T> findById(ID id);
    default T getIfExists(ID id) {
        return findById(id)
                .orElseThrow(
                        () -> new NotFoundException("Object with id '" + id + "' not found.")
                );
    }
}
