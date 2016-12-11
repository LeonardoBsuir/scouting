package bsuir.scouting.repository;


import bsuir.scouting.model.domain.User;

import java.util.List;


public interface UserRepository extends BaseRepository<User, Long> {
    List<User> findByTeamByTeamId_TeamId(Long teamId);


}
