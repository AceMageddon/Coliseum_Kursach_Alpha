package com.example.demo.component;

import com.example.demo.data.Data;
import com.example.demo.model.MemoryEntity;
import com.example.demo.repo.MemoryRepository;
import com.example.demo.service.MemoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ComponentMemory {

    @Autowired
    MemoryService memoryService;

    @Autowired
    MemoryRepository memoryRepository;


    public void getmemory(){
        Data.mparryammount = memoryService.getMemoryParryammount(Data.pid);
        Data.mhighscore = memoryService.getMemoryHighscore(Data.pid);
        Data.mbattlestatus = memoryService.getMemoryBattlestatus(Data.pid);
        Data.mlevel = memoryService.getMemoryLevel(Data.pid);
        Data.eid = memoryService.getMemoryEnemyid(Data.pid);
        Data.mstrike = memoryService.getMemoryStrike(Data.pid);
        Data.mplayernum = memoryService.getMemoryPlayernum(1);
    }

    public void updatememory(){
        MemoryEntity memoryEntity = new MemoryEntity();
        memoryEntity.setId(Data.pid);
        memoryEntity.setParryammount(Data.mparryammount);
        memoryEntity.setHighscore(Data.mhighscore);
        memoryEntity.setBattlestatus(Data.mbattlestatus);
        memoryEntity.setLevel(Data.mlevel);
        memoryEntity.setPlayerid(Data.pid);
        memoryEntity.setEnemyid(Data.eid);
        memoryEntity.setStrike(Data.mstrike);
        memoryEntity.setPlayernum(1);
        memoryRepository.save(memoryEntity);
    }

    public void updateplayernum() {
        MemoryEntity memoryEntity = new MemoryEntity();
        memoryEntity.setId(1);
        memoryEntity.setParryammount(Data.omparryammount);
        memoryEntity.setHighscore(Data.omhighscore);
        memoryEntity.setBattlestatus(Data.ombattlestatus);
        memoryEntity.setLevel(Data.omlevel);
        memoryEntity.setPlayerid(1);
        memoryEntity.setEnemyid(Data.eid);
        memoryEntity.setStrike(Data.omstrike);
        memoryEntity.setPlayernum(Data.mplayernum);
        memoryRepository.save(memoryEntity);
    }

    public void getoriginalmemory(){
     Data.omparryammount = memoryService.getMemoryParryammount(1);
     Data.omhighscore = memoryService.getMemoryHighscore(1);
     Data.ombattlestatus = memoryService.getMemoryBattlestatus(1);
     Data.omlevel = memoryService.getMemoryLevel(1);
     Data.eid = memoryService.getMemoryEnemyid(1);
     Data.omstrike = memoryService.getMemoryStrike(1);
     Data.mplayernum = memoryService.getMemoryPlayernum(1);
    }

    public void createnewmemory(){
        MemoryEntity memoryEntity = new MemoryEntity();
        memoryEntity.setId(Data.pid);
        memoryEntity.setParryammount(Data.omparryammount);
        memoryEntity.setHighscore(Data.omhighscore);
        memoryEntity.setBattlestatus(Data.ombattlestatus);
        memoryEntity.setLevel(Data.omlevel);
        memoryEntity.setPlayerid(Data.pid);
        memoryEntity.setEnemyid(Data.eid);
        memoryEntity.setStrike(Data.omstrike);
        memoryEntity.setPlayernum(Data.mplayernum);
        memoryRepository.save(memoryEntity);
    }

    public void gethighscore(){
        Data.checkhighscore = memoryService.getMemoryHighscore(Data.check);
    }
}
