package com.example.duolingo_biblico.repositories;

import com.example.duolingo_biblico.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Long> { }
