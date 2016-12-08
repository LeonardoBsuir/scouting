package bsuir.scouting.web.controller;

import bsuir.scouting.model.domain.Skills;
import bsuir.scouting.service.SkillsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/skills")
public class SkillsController {

    @Autowired
    private SkillsService skillsService;

    @GetMapping
    public List<Skills> findAll() {
        return skillsService.findAll();
    }

    @GetMapping("/{id}")
    public Skills findOne(@PathVariable Long id) {
        return skillsService.findOne(id);
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Skills save(@RequestBody @Valid Skills skills) {
        return skillsService.save(skills);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteSkills(@PathVariable Long id) {
        skillsService.delete(id);
    }

}
