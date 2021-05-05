package com.example.demo.repo;

import com.example.demo.model.PlayerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository extends JpaRepository<PlayerEntity, Long> {
    public PlayerEntity findByEmail(String email);
    public PlayerEntity findByPlayername(String playername);
}