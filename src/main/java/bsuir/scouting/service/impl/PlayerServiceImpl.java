package bsuir.scouting.service.impl;

import bsuir.scouting.domain.Player;
import bsuir.scouting.repository.PlayerRepository;
import bsuir.scouting.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerServiceImpl implements PlayerService {

    @Autowired
    PlayerRepository playerRepository;

    @Override
    public void delete(Player entity) {
        playerRepository.delete(entity);
    }

    @Override
    public List<Player> findAll() {
        return playerRepository.findAll();
    }

    @Override
    public Player findOne(Long id) {
        return playerRepository.findOne(id);
    }

    @Override
    public Player save(Player entity) {
        return playerRepository.save(entity);
    }
}
