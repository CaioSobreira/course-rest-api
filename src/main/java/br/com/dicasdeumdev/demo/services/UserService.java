package br.com.dicasdeumdev.demo.services;

import br.com.dicasdeumdev.demo.domain.User;
import br.com.dicasdeumdev.demo.domain.dto.UserDTO;

import java.util.List;

public interface UserService {

    User findById(Integer id);
    List<User> findAll();
    User create(UserDTO obj);
    User update(UserDTO obj);
    void delete(Integer id);
}
