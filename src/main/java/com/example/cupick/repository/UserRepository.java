package com.example.cupick.repository;

import com.example.cupick.model.User;
import lombok.Data;
import lombok.Getter;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByEmail(String email);
    Optional<User> findByPhoneNumber(String phoneNumber);
    Optional<User> findByInstaId(String instaId);

    @Query("SELECT COUNT(u) FROM User u WHERE u.cupid = true")
    int countByCupidTrue();

}
