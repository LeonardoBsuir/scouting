package bsuir.scouting.repository;

import bsuir.scouting.model.domain.Team;


public interface TeamRepository extends BaseRepository<Team, Long> {
    Team findByCountryOrderByNameAsc(String country);
}
