package com.xandy.workshopspringmongo.resources;


import com.xandy.workshopspringmongo.domains.User;
import com.xandy.workshopspringmongo.dto.UserDTO;
import com.xandy.workshopspringmongo.repository.UserRepository;
import com.xandy.workshopspringmongo.services.UserServices;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserResources {

    @Autowired
    private UserServices service;


    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<UserDTO>> findAll() {
        List<User> list = service.findAll();
        List<UserDTO> listDto = list.stream().map(x -> new UserDTO(x)).toList();
        return ResponseEntity.ok().body(listDto);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<UserDTO> findByUsername(@PathVariable("id") String id) {
        User obj = service.findById(id);
        return ResponseEntity.ok().body(new UserDTO(obj));


    }
}
