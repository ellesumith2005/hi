package com.example.positive.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.positive.model.Users;

@Repository
public interface UserRepository extends JpaRepository<Users,Long>{
    Users findByusername(String name);

   
}
