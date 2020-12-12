package com.bianeck.bookstoremanager.users.repository;

import com.bianeck.bookstoremanager.users.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
