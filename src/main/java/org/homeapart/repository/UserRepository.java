package org.homeapart.repository;

import org.homeapart.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


public interface UserRepository extends CrudRepository<Long, User> {

   // List<User> search(String query);

   Optional <User> findByLogin(String login);
}
