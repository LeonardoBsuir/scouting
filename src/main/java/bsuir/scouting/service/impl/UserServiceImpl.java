package bsuir.scouting.service.impl;

import bsuir.scouting.model.domain.User;
import bsuir.scouting.repository.UserRepository;
import bsuir.scouting.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void delete(Long id) {
        User user = userRepository.findOne(id);
        userRepository.delete(user);
    }

    @Override
    public List<User> findAll() {
        return (List<User>) userRepository.findAll();
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
