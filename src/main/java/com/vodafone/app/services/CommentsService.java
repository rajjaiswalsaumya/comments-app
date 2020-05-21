package com.vodafone.app.services;

import com.vodafone.app.entities.Comment;
import com.vodafone.app.repositories.CommentsRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentsService {

  @Autowired
  private CommentsRepository commentsRepository;

  public List<Comment> getComments() {
    return this.commentsRepository.findAll();
  }

  public Comment saveComment(Comment comment) {
    return this.commentsRepository.save(comment);
  }

  public Comment updateComment(Long id, Comment model) {
    Optional<Comment> commentbyId = this.commentsRepository.findById(id);

    Comment entity = null;
    if (commentbyId.isPresent()) {
      entity = commentbyId.get();
      entity.setMsg(model.getMsg());
    }
    return this.commentsRepository.save(entity);
  }

  public void deleteCommentById(Long id) {
    this.commentsRepository.deleteById(id);
  }

  public void deleteComment(Comment comment) {
    this.commentsRepository.delete(comment);
  }
}
