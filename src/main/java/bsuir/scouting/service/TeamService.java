package bsuir.scouting.service;

import bsuir.scouting.model.domain.Team;

public interface TeamService extends BaseService<Team, Long> {

    Team findByCountry(String country);
}
