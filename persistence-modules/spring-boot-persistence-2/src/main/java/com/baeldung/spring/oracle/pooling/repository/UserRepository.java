package com.baeldung.spring.oracle.pooling.repository;

import com.baeldung.spring.oracle.pooling.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author nayanava
 */
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByPhoneNumber(String phoneNumber);
}
