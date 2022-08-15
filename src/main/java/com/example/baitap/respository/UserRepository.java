package com.example.baitap.respository;

import com.example.baitap.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    List<User> findAllByName(String name);
    List<User> findAllByNameContainsIgnoreCase(String name);
    List<User> findAllByNameAndEmail(String name, String email);
    List<User> findAllByNameOrderByEmailAsc(String name);
}