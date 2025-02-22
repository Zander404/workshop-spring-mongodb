package com.xandy.workshopspringmongo.services;

import com.xandy.workshopspringmongo.domains.User;
import com.xandy.workshopspringmongo.dto.UserDTO;
import com.xandy.workshopspringmongo.repository.UserRepository;
import com.xandy.workshopspringmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServices {

    @Autowired
    private UserRepository repository;

    public List<User> findAll() {
        return repository.findAll();
    }

    public User findById(String id) {
        Optional<User> user = repository.findById(id);
        return user.orElseThrow(() -> new ObjectNotFoundException("Object not found"));
    }

    public User insert(User user) {
        return repository.insert(user);
    }

    public void delete(String id) {
        repository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Object not found"));
        repository.deleteById(id);
    }

    public User update(User obj) {
        User newObj = findById(obj.getId());
        updateData(newObj, obj);
        return repository.save(newObj);

    }

    public User fromDto(UserDTO objDto) {
        return new User(objDto.getId(), objDto.getName(), objDto.getEmail());

    }

    public void updateData(User newObj, User obj) {
        newObj.setName(obj.getName());
        newObj.setEmail(obj.getEmail());


    }


}
