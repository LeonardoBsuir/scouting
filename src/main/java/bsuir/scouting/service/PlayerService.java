package bsuir.scouting.service;


import bsuir.scouting.model.domain.Player;

import java.util.List;

public interface PlayerService extends BaseService<Player, Long> {

    List<Player> findAll(Long teamId);

    Player updatePlayer(Player player, Long id);

}


