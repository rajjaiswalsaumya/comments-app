package com.vodafone.app.repositories;

import com.vodafone.app.entities.User;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
  List<User> findAll();
}
