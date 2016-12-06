package bsuir.scouting.service.impl;

import bsuir.scouting.model.domain.Player;
import bsuir.scouting.repository.PlayerRepository;
import bsuir.scouting.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerServiceImpl implements PlayerService {

    @Autowired
    private PlayerRepository playerRepository;

    @Override
    public void delete(Long id) {
        Player player = playerRepository.findOne(id);
        playerRepository.delete(player);
    }

    @Override
    public List<Player> findAll() {
        return (List<Player>) playerRepository.findAll();
    }

    @Override
    public Player findOne(Long id) {
        return playerRepository.findOne(id);
    }

    @Override
    public Player save(Player entity) {
        return playerRepository.save(entity);
    }

    @Override
    public List<Player> findAll(Long teamId) {
        List<Player> players;
        if (teamId != null) {
            players = playerRepository.findByTeamByTeamId_TeamId(teamId);
        } else players = findAll();
        return players;
    }
}
