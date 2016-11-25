package bsuir.scouting.service.impl;

import bsuir.scouting.domain.User;
import bsuir.scouting.repository.UserRepository;
import bsuir.scouting.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public void delete(User entity) {
        userRepository.delete(entity);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findOne(Long id) {
        return userRepository.findOne(id);
    }

    @Override
    public User save(User entity) {
        return userRepository.save(entity);
    }
}
