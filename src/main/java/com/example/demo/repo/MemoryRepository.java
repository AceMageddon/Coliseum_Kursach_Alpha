package com.example.demo.repo;

import com.example.demo.model.MemoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemoryRepository extends JpaRepository<MemoryEntity, Long> {
    public MemoryEntity findByHighscore(int highscore);
}
