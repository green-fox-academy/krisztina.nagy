package com.greenfoxacademy.reddit.repository;

import com.greenfoxacademy.reddit.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    User FindUserByIdEquals(long id);
}
