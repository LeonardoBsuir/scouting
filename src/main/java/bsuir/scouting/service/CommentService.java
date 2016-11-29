package bsuir.scouting.service;


import bsuir.scouting.model.domain.Comment;
import bsuir.scouting.model.domain.Player;

import java.util.List;

public interface CommentService extends BaseService<Comment, Long> {

    List<Comment> findAllCommentsByPlayer(Player player);

}
