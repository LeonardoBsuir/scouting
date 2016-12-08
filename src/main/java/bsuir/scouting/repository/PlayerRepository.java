package bsuir.scouting.repository;

import bsuir.scouting.model.domain.Player;

import java.util.List;


public interface PlayerRepository extends BaseRepository<Player, Long> {
    List<Player> findByTeamByTeamId_TeamId(Long teamId);

}
