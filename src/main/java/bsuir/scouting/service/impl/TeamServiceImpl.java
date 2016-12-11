package bsuir.scouting.service.impl;

import bsuir.scouting.model.domain.Player;
import bsuir.scouting.model.domain.Team;
import bsuir.scouting.repository.PlayerRepository;
import bsuir.scouting.repository.SkillsRepository;
import bsuir.scouting.repository.TeamRepository;
import bsuir.scouting.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TeamServiceImpl implements TeamService {

    private static final Long DEFAULT_SKILL = 99L;
    private static final Long DEFAULT_VALUE = 0L;

    @Autowired
    private TeamRepository teamRepository;

    @Autowired
    private SkillsRepository skillsRepository;

    @Autowired
    private PlayerRepository playerRepository;


    @Override
    public void delete(Long id) {
        Team team = teamRepository.findOne(id);
        teamRepository.delete(team);
    }

    @Override
    public List<Team> findAll() {
        List<Team> teams = (List<Team>) teamRepository.findAll();
        for (Team team : teams) {
            recalculateTeamSkills(team);
        }
        return (List<Team>) teamRepository.findAll();
    }

    @Override
    public Team findOne(Long id) {
        return teamRepository.findOne(id);
    }

    @Override
    public Team save(Team entity) {
        if (entity.getSkillsBySkillsId() == null) {
            entity.setSkillsBySkillsId(skillsRepository.findOne(DEFAULT_SKILL));
        }
        return teamRepository.save(entity);
    }

    private void recalculateTeamSkills(Team team) {
        List<Player> players = playerRepository.findByTeamByTeamId_TeamId(team.getTeamId());
        Integer playersCount = players.size();
        Long teamSkillsId = team.getSkillsBySkillsId().getSkillsId();
        Long shooting = DEFAULT_VALUE;
        Long passing = DEFAULT_VALUE;
        Long dribbling = DEFAULT_VALUE;
        Long defence = DEFAULT_VALUE;
        Long speed = DEFAULT_VALUE;
        Long energy = DEFAULT_VALUE;
        Long stamina = DEFAULT_VALUE;
        if (playersCount != 0) {
            for (Player player1 : players) {
                shooting += player1.getSkillsBySkillsId().getShooting();
                passing += player1.getSkillsBySkillsId().getPassing();
                dribbling += player1.getSkillsBySkillsId().getDribbling();
                defence += player1.getSkillsBySkillsId().getDefence();
                speed += player1.getSkillsBySkillsId().getSpeed();
                energy += player1.getSkillsBySkillsId().getEnergy();
                stamina += player1.getSkillsBySkillsId().getStamina();
            }
            shooting = shooting / playersCount;
            passing = passing / playersCount;
            dribbling = dribbling / playersCount;
            defence = defence / playersCount;
            speed = speed / playersCount;
            energy = energy / playersCount;
            stamina = stamina / playersCount;
        }
        skillsRepository.updateSkills(shooting, passing, dribbling, defence, speed, energy, stamina, teamSkillsId);

    }

    @Override
    public Team findByCountry(String country) {
        return teamRepository.findByCountryOrderByNameAsc(country);
    }
}
