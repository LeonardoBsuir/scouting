package bsuir.scouting.service.impl;

import bsuir.scouting.model.domain.Comment;
import bsuir.scouting.model.domain.Player;
import bsuir.scouting.repository.CommentRepository;
import bsuir.scouting.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Override
    public void delete(Long id) {
        Comment comment = commentRepository.findOne(id);
        commentRepository.delete(comment);
    }

    @Override
    public List<Comment> findAll() {
        return (List<Comment>) commentRepository.findAll();
    }

    @Override
    public Comment findOne(Long id) {
        return commentRepository.findOne(id);
    }

    @Override
    public Comment save(Comment entity) {
        return commentRepository.save(entity);
    }


    @Override
    public List<Comment> findAllCommentsByPlayer(Player player) {
        return commentRepository.findByPlayerByPlayerIdOrderByCommentIdDesc(player);
    }
}
