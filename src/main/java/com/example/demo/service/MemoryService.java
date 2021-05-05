package com.example.demo.service;

import com.example.demo.model.MemoryEntity;
import com.example.demo.repo.MemoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemoryService {
    @Autowired
    private MemoryRepository memoryRepository;

    public MemoryEntity findMemoryById(long id) {
        return memoryRepository.findById(id).get();
    }

    public void safeMemory(MemoryEntity test) {
        memoryRepository.save(test);
    }

    public int getMemoryParryammount(long id) { return memoryRepository.findById(id).get().getParryammount(); }
    public int getMemoryHighscore(long id) { return memoryRepository.findById(id).get().getHighscore(); }
    public int getMemoryBattlestatus(long id) { return memoryRepository.findById(id).get().getBattlestatus(); }
    public int getMemoryLevel(long id) { return memoryRepository.findById(id).get().getLevel(); }
    public long getMemoryEnemyid(long id) { return memoryRepository.findById(id).get().getEnemyid(); }
    public int getMemoryStrike(long id){return memoryRepository.findById(id).get().getStrike();}
    public int getMemoryPlayernum(long id){return memoryRepository.findById(id).get().getPlayernum();}
}
