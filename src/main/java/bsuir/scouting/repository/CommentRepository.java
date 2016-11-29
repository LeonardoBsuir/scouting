package bsuir.scouting.repository;


import bsuir.scouting.model.domain.Comment;
import bsuir.scouting.model.domain.Player;

import java.util.List;

public interface CommentRepository extends BaseRepository<Comment, Long> {
    List<Comment> findByPlayerByPlayerIdOrderByCommentIdDesc(Player player);
}
