package bsuir.scouting.service.impl;

import bsuir.scouting.model.domain.Player;
import bsuir.scouting.model.domain.User;
import bsuir.scouting.repository.PlayerRepository;
import bsuir.scouting.repository.UserRepository;
import bsuir.scouting.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PlayerRepository playerRepository;

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
    public List<User> findAll(Long teamId) {
        List<User> users;
        if (teamId != null) {
            users = userRepository.findByTeamByTeamId_TeamId(teamId);
        } else users = findAll();
        return users;
    }

    @Override
    public void addPlayerToUser(Long playerId, Long userId) {
        Player player = playerRepository.findOne(playerId);
        User user = userRepository.findOne(userId);
        user.getPlayers().add(player);
        player.getUsers().add(user);
        userRepository.save(user);
        playerRepository.save(player);
    }

    @Override
    public void delPlayerToUser(Long playerId, Long userId) {
        Player player = playerRepository.findOne(playerId);
        User user = userRepository.findOne(userId);
        user.getPlayers().remove(player);
        player.getUsers().remove(user);
        userRepository.save(user);
        playerRepository.save(player);
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
