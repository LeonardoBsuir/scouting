package bsuir.scouting.web.controller;

import bsuir.scouting.model.domain.Comment;
import bsuir.scouting.model.domain.Player;
import bsuir.scouting.service.CommentService;
import bsuir.scouting.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/players/{playerId}/comments")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @Autowired
    private PlayerService playerService;

    @GetMapping
    public List<Comment> findAll(@PathVariable Long playerId) {
        Player player = playerService.findOne(playerId);
        return commentService.findAllCommentsByPlayer(player);
    }

    @GetMapping("/{id}")
    public Comment findOne(@PathVariable Long id) {
        return commentService.findOne(id);
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Comment save(@RequestBody @Valid Comment comment) {
        return commentService.save(comment);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteNews(@PathVariable Long id) {
        commentService.delete(id);
    }
}
