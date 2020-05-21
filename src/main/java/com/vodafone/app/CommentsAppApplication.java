package com.vodafone.app;

import com.vodafone.app.entities.Comment;
import com.vodafone.app.entities.Tag;
import com.vodafone.app.entities.User;
import com.vodafone.app.repositories.CommentsRepository;
import com.vodafone.app.repositories.UserRepository;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CommentsAppApplication implements CommandLineRunner {

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private CommentsRepository commentsRepository;

  public static void main(String[] args) {
    SpringApplication.run(CommentsAppApplication.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
    Stream.of(
        new User("rohit@vodafone.in"),
        new User("sam2389@gmail.com")
    ).forEach(userRepository::save);
    List<User> users = userRepository.findAll();
    Comment comment = new Comment("comment1", users.get(0));
    List<Tag> tags = new ArrayList<>();
    tags.addAll(users.stream()
        .map(u -> new Tag("DisplayTag" + u.getId(), u.getId(), comment)).collect(Collectors.toList()));
    comment.setTags(tags);
    this.commentsRepository.save(comment);
  }
}
