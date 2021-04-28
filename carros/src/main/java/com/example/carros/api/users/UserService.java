package com.example.carros.api.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository rep;

    public List<UserDTO> getUsers() {
        return rep.findAll().stream().map(UserDTO::create).collect(Collectors.toList());
    }

    public UserDTO insert(User user) {
        Assert.isNull(user.getId(), "Não foi possivel inserir o registro");
        return UserDTO.createUser(rep.save(user));
    }
}
