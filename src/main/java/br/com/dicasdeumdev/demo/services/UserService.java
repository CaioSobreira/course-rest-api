package br.com.dicasdeumdev.demo.services;

import br.com.dicasdeumdev.demo.domain.User;

public interface UserService {

    User findById(Integer id);
}
