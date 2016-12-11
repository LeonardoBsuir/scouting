package bsuir.scouting.service.impl;

import bsuir.scouting.model.domain.Player;
import bsuir.scouting.repository.PlayerRepository;
import bsuir.scouting.repository.SkillsRepository;
import bsuir.scouting.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PlayerServiceImpl implements PlayerService {

    private static final Long DEFAULT_VALUE = 0L;

    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private SkillsRepository skillsRepository;

    @Override
    public void delete(Long id) {
        Player player = findOne(id);
        playerRepository.delete(player);
        skillsRepository.delete(player.getSkillsBySkillsId());
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
        if (entity.getSkillsBySkillsId().getSkillsId() == DEFAULT_VALUE) {
            skillsRepository.save(entity.getSkillsBySkillsId());
        }
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

    @Override
    public Player updatePlayer(Player player, Long id) {
        if (player.getSkillsBySkillsId().getSkillsId() == DEFAULT_VALUE) {
            skillsRepository.save(player.getSkillsBySkillsId());
        }
        return updatePlayerFromPlayer(player);
    }


    private Player updatePlayerFromPlayer(Player player) {
        playerRepository.updatePlayer(player.getFirstName(), player.getLastName(), player.getPosition(), player.getPhoto(), player.getBirthdate(), player.getWeight(), player.getHeight(), player.getSalary(), player.getCost(), player.getTeamByTeamId(), player.getFoot(), player.getPlayerId());
        return player;
    }

}
