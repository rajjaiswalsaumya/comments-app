package com.vodafone.app.repositories;

import com.vodafone.app.entities.Comment;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface CommentsRepository extends CrudRepository<Comment, Long> {

  List<Comment> findAll();

  Comment save(Comment comment);
}
