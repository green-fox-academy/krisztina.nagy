package com.greenfoxacademy.reddit.Service;

import com.greenfoxacademy.reddit.model.User;
import com.greenfoxacademy.reddit.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    UserRepository repo;

    @Autowired
    public UserService(UserRepository repo){
        this.repo = repo;
    }

    public void addUser(User user){
        if(user != null){
            this.repo.save(user);
        }
    }

    public List<User> getAll(){
        List<User> users = new ArrayList<>();
        this.repo.findAll().forEach(users::add);
        return users;
    }

    public User findUserByUserName (String userName) {
        return repo.findUserByUserName(userName);
    }

    public User findUserByIdEquals(long id){
        return repo.findUserByIdEquals(id);
    }
}
