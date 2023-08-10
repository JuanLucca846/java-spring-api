package com.example.firstcrud.repositories;

import com.example.firstcrud.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
