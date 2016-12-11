package bsuir.scouting.service;


import bsuir.scouting.model.domain.Skills;

public interface SkillsService extends BaseService<Skills, Long> {
    Skills update(Skills skills);
}
