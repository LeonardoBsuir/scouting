package bsuir.scouting.service.impl;

import bsuir.scouting.model.domain.Team;
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

    @Autowired
    private TeamRepository teamRepository;

    @Autowired
    private SkillsRepository skillsRepository;

    @Override
    public void delete(Long id) {
        Team team = teamRepository.findOne(id);
        teamRepository.delete(team);
    }

    @Override
    public List<Team> findAll() {
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


    @Override
    public Team findByCountry(String country) {
        return teamRepository.findByCountryOrderByNameAsc(country);
    }
}
