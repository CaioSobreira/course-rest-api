package br.com.dicasdeumdev.demo.services.impl;

import br.com.dicasdeumdev.demo.domain.User;
import br.com.dicasdeumdev.demo.domain.dto.UserDTO;
import br.com.dicasdeumdev.demo.repositories.UserRepository;
import br.com.dicasdeumdev.demo.services.UserService;
import br.com.dicasdeumdev.demo.services.exceptions.DataIntegrityViolationException;
import br.com.dicasdeumdev.demo.services.exceptions.ObjectNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper mapper;

    @Override
    public User findById(Integer id) {
        Optional<User> obj = userRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Object not found"));
    }

    @Override
    public List<User> findAll(){
        return userRepository.findAll();
    }

    @Override
    public User create(UserDTO obj) {
        findByEmail(obj);
        return userRepository.save(mapper.map(obj, User.class));
    }

    @Override
    public User update(UserDTO obj) {
        findByEmail(obj);
        return userRepository.save(mapper.map(obj, User.class));
    }

    private void findByEmail(UserDTO obj){
        Optional<User> user = userRepository.findByEmail(obj.getEmail());
        if(user.isPresent() && !user.get().getId().equals(obj.getId())){
            throw new DataIntegrityViolationException("E-mail already in use");
        }
    }
}
