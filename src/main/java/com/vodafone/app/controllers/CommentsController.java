package com.vodafone.app.controllers;

import com.vodafone.app.entities.Comment;
import com.vodafone.app.services.CommentsService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommentsController {

  @Autowired
  private CommentsService commentsService;

  @GetMapping("/api/comments")
  public List<Comment> getComments() {
    return this.commentsService.getComments();
  }

  @DeleteMapping("/api/comment/{id}")
  public ResponseEntity<HttpStatus> deleteComment(@PathVariable("id") Long id) {
    ResponseEntity entity;
    try {
      this.commentsService.deleteCommentById(id);
      entity = ResponseEntity.accepted().build();
    } catch (Exception ex) {
      entity = ResponseEntity.notFound().build();
    }
    return entity;
  }

  @PutMapping("/api/comment/{id}")
  public Comment editComment(@PathVariable("id") Long id, @RequestBody Comment comment) {
    return this.commentsService.updateComment(id, comment);
  }

  @PostMapping("/api/comment")
  public Comment addComment(Comment comment) {
    return this.commentsService.saveComment(comment);
  }

}
