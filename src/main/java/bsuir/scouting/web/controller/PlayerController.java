package bsuir.scouting.web.controller;


import bsuir.scouting.model.domain.Player;
import bsuir.scouting.service.PlayerService;
import bsuir.scouting.service.SkillsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/players")
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    @Autowired
    private SkillsService skillsService;

    @GetMapping
    public List<Player> findAll(@RequestParam(value = "teamId", required = false) Long teamId) {
        return playerService.findAll(teamId);
    }

    @GetMapping("/{id}")
    public Player findOne(@PathVariable Long id) {
        return playerService.findOne(id);
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Player save(@RequestBody @Valid Player player) {
        return playerService.save(player);
    }

    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Player update(@RequestBody @Valid Player player, @PathVariable Long id) {
        skillsService.update(player.getSkillsBySkillsId());
        return playerService.updatePlayer(player, id);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePlayer(@PathVariable Long id) {
        playerService.delete(id);
    }
}
