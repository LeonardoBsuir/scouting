package bsuir.scouting.service.impl;


import bsuir.scouting.model.domain.Skills;
import bsuir.scouting.repository.SkillsRepository;
import bsuir.scouting.service.SkillsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SkillsServiceImpl implements SkillsService {

    @Autowired
    private SkillsRepository skillsRepository;

    @Override
    public void delete(Long id) {
        Skills skills = skillsRepository.findOne(id);
        skillsRepository.delete(skills);
    }

    @Override
    public List<Skills> findAll() {
        return (List<Skills>) skillsRepository.findAll();
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
