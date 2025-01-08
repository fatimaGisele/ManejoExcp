package com.error.mn_exceptions.Service;

import java.util.List;
import java.util.Optional;

import com.error.mn_exceptions.Models.Domain.User;

public interface IUserService {

    List<User> findAll();
    Optional<User> findById(int id);

}
