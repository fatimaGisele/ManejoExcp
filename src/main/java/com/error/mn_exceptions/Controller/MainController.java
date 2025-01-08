package com.error.mn_exceptions.Controller;

import org.springframework.web.bind.annotation.RestController;

import com.error.mn_exceptions.Exceptions.UserNotFoundException;
import com.error.mn_exceptions.Models.Domain.User;
import com.error.mn_exceptions.Service.IUserService;
//import com.error.mn_exceptions.Service.UserService;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("/")
public class MainController {

    @Autowired
    private IUserService user;

    @GetMapping
    public String init(){
        //int i = 100/0;
        int i = Integer.parseInt("5X0");
        System.out.println(i);
        return "ok 200";
    }

    @GetMapping("/init/{id}")
    public ResponseEntity<?> iniUser(@PathVariable(name = "id") int id){
        //User u = user.findById(id).orElseThrow(()-> new UserNotFoundException("El usuario no EXISTE"));
        Optional<User> u = user.findById(id);
        if(!u.isPresent()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(u.orElseThrow());
    }

}
