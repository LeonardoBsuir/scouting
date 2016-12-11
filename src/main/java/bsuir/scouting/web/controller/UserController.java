package bsuir.scouting.web.controller;

import bsuir.scouting.model.domain.User;
import bsuir.scouting.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> findAll(@RequestParam(value = "teamId", required = false) Long teamId) {
        return userService.findAll(teamId);
    }

    @GetMapping("/{id}")
    public User findOne(@PathVariable Long id) {
        return userService.findOne(id);
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public User save(@RequestBody @Valid User user) {
        return userService.save(user);
    }

    @PostMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public void addPlayerToUser(@RequestBody @Valid User user, @PathVariable Long id) {
        userService.addPlayerToUser(id, user.getUserId());
        List<User> users = userService.findAll(user.getTeamByTeamId().getTeamId());
        for (User coach : users) {
            if (coach.getRoleByRoleId().getType().equals("coach")) {
                userService.addPlayerToUser(id, coach.getUserId());
            }
        }

    }

    @DeleteMapping(value = "/{id}/{playerId}")
    @ResponseStatus(HttpStatus.CREATED)
    public void delPlayerToUser(@PathVariable Long id, @PathVariable Long playerId) {
        userService.delPlayerToUser(playerId, id);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable Long id) {
        userService.delete(id);
    }
}
