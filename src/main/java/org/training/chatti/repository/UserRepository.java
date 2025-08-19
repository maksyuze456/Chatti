package org.training.chatti.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.training.chatti.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {

    public User findByUsername(String username);
}
