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
        Player player = playerRepository.findOne(id);
        recalculateTeamSkills(player, false);
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
        if (entity.getSkillsBySkillsId().getSkillsId() == 0L) {
            skillsRepository.save(entity.getSkillsBySkillsId());
        }
        recalculateTeamSkills(entity, true);
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


    private void recalculateTeamSkills(Player player, boolean isInclude) {
        Long teamId = player.getTeamByTeamId().getTeamId();
        List<Player> players = findAll(teamId);
        if (isInclude) {
            players.add(player);
        } else {
            players.remove(player);
        }
        Long teamSkillsId = player.getTeamByTeamId().getSkillsBySkillsId().getSkillsId();
        Long shooting = DEFAULT_VALUE;
        Long passing = DEFAULT_VALUE;
        Long dribbling = DEFAULT_VALUE;
        Long defence = DEFAULT_VALUE;
        Long speed = DEFAULT_VALUE;
        Long energy = DEFAULT_VALUE;
        Long stamina = DEFAULT_VALUE;
        for (Player player1 : players) {
            shooting += player1.getSkillsBySkillsId().getShooting();
            passing += player1.getSkillsBySkillsId().getPassing();
            dribbling += player1.getSkillsBySkillsId().getDribbling();
            defence += player1.getSkillsBySkillsId().getDefence();
            speed += player1.getSkillsBySkillsId().getSpeed();
            energy += player1.getSkillsBySkillsId().getEnergy();
            stamina += player1.getSkillsBySkillsId().getStamina();
        }
        Integer playersCount = players.size();
        shooting = shooting / playersCount;
        passing = passing / playersCount;
        dribbling = dribbling / playersCount;
        defence = defence / playersCount;
        speed = speed / playersCount;
        energy = energy / playersCount;
        stamina = stamina / playersCount;
        skillsRepository.updateSkills(shooting, passing, dribbling, defence, speed, energy, stamina, teamSkillsId);
    }

}
