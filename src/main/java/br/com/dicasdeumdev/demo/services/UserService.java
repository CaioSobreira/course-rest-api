package br.com.dicasdeumdev.demo.services;

import br.com.dicasdeumdev.demo.domain.User;

import java.util.List;

public interface UserService {

    User findById(Integer id);
    List<User> findAll();
}
