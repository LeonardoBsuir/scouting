package bsuir.scouting.repository;

import bsuir.scouting.model.domain.Player;
import bsuir.scouting.model.domain.Team;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.List;


public interface PlayerRepository extends BaseRepository<Player, Long> {
    List<Player> findByTeamByTeamId_TeamId(Long teamId);

    @Transactional
    @Modifying
    @Query("update Player s set s.firstName = :firstName, s.lastName = :lastName, s.position = :position, s.photo = :photo, s.birthdate = :birthdate, s.weight = :weight, s.height = :height, s.salary = :salary, s.cost = :cost, s.teamByTeamId = :team, s.foot = :foot  where s.playerId = :playerId")
    void updatePlayer(@Param("firstName") String firstName, @Param("lastName") String lastName, @Param("position") String position, @Param("photo") String photo, @Param("birthdate") Timestamp birthdate, @Param("weight") Long weight, @Param("height") Long height, @Param("salary") Long salary, @Param("cost") Long cost, @Param("team") Team team, @Param("foot") String foot, @Param("playerId") Long playerId);

}

