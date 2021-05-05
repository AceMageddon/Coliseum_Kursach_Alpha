package com.example.demo.repo;

import com.example.demo.model.PlayerEntity;
import com.example.demo.model.SafeplayerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SafeplayerRepository extends JpaRepository<SafeplayerEntity, Long> {
}
