package bsuir.scouting.web.controller;

import bsuir.scouting.model.domain.Team;
import bsuir.scouting.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/teams")
public class TeamController {

    @Autowired
    private TeamService teamService;

    @GetMapping
    public List<Team> findAll() {
        return teamService.findAll();
    }

    @GetMapping("/{id}")
    public Team findOne(@PathVariable Long id) {
        return teamService.findOne(id);
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Team save(@RequestBody @Valid Team team) {
        return teamService.save(team);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteNews(@PathVariable Long id) {
        teamService.delete(id);
    }
}
