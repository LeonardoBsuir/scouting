package bsuir.scouting.service.impl;


import bsuir.scouting.domain.Skills;
import bsuir.scouting.repository.SkillsRepository;
import bsuir.scouting.service.SkillsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SkillsServiceImpl implements SkillsService {

    @Autowired
    SkillsRepository skillsRepository;

    @Override
    public void delete(Skills entity) {
        skillsRepository.delete(entity);
    }

    @Override
    public List<Skills> findAll() {
        return skillsRepository.findAll();
    }

    @Override
    public Skills findOne(Long id) {
        return skillsRepository.findOne(id);
    }

    @Override
    public Skills save(Skills entity) {
        return skillsRepository.save(entity);
    }
}
