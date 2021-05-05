package com.example.demo.repo;

import com.example.demo.model.EnemyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnemyRepository extends JpaRepository<EnemyEntity, Long> {
}
