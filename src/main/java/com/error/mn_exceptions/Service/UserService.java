package com.error.mn_exceptions.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.error.mn_exceptions.Models.Domain.User;

@Service
public class UserService implements IUserService{
    
    @Autowired
    private List<User> users;

    public UserService(){}

    @Override
    public List<User> findAll() {
       return this.users;
    }

    @Override
    public Optional<User> findById(int id) {
       User u = new User();
       for (User user : users) {
        if(user.getId()==id){
            u=user;
            break;
        }
       }
       return Optional.ofNullable(u);

    }

}
