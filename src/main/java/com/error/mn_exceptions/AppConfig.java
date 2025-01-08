package com.error.mn_exceptions;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;

import com.error.mn_exceptions.Models.Domain.User;


public class AppConfig {

    @Bean
    public List<User> UserService(){
        List<User> users = new ArrayList<>();
        users.add(new User("Mila", "Altamirano",1));
        users.add(new User("Morci", "Altamirano",2));
        users.add(new User("Gigi", "Altamirano",3));
        return users;
    }
}
