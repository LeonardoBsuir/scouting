package bsuir.scouting.service.impl;

import bsuir.scouting.domain.Team;
import bsuir.scouting.repository.TeamRepository;
import bsuir.scouting.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamServiceImpl implements TeamService {

    @Autowired
    TeamRepository teamRepository;

    @Override
    public void delete(Team entity) {
        teamRepository.delete(entity);
    }

    @Override
    public List<Team> findAll() {
        return teamRepository.findAll();
    }

    @Override
    public Team findOne(Long id) {
        return teamRepository.findOne(id);
    }

    @Override
    public Team save(Team entity) {
        return teamRepository.save(entity);
    }
}
