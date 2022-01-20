package br.com.dicasdeumdev.demo.services.impl;

import br.com.dicasdeumdev.demo.domain.User;
import br.com.dicasdeumdev.demo.repositories.UserRepository;
import br.com.dicasdeumdev.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User findById(Integer id) {
        Optional<User> obj = userRepository.findById(id);
        return obj.orElse(null);
    }
}