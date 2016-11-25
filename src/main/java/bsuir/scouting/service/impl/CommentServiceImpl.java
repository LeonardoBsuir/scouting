package bsuir.scouting.service.impl;

import bsuir.scouting.domain.Comment;
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
    CommentRepository commentRepository;

    @Override
    public void delete(Comment entity) {
        commentRepository.delete(entity);
    }

    @Override
    public List<Comment> findAll() {
        return commentRepository.findAll();
    }

    @Override
    public Comment findOne(Long id) {
        return commentRepository.findOne(id);
    }

    @Override
    public Comment save(Comment entity) {
        return commentRepository.save(entity);
    }
}
