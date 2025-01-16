package com.xandy.workshopspringmongo.services;

import com.xandy.workshopspringmongo.domains.User;
import com.xandy.workshopspringmongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServices {

    @Autowired
    private UserRepository repository;

    public List<User> findAll() {
        return repository.findAll();
    }


}
