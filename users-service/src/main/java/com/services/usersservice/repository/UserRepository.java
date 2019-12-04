package com.services.usersservice.repository;

import com.services.usersservice.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Repository layer for user-service.
 */
@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

    @Override
    List<User> findAll();

    /**
     * Provides ability to retrieve user by email.
     *
     * @param email search parameter
     * @return {@link User} entity
     */
    Optional<User> findUserByEmail(String email);
}
