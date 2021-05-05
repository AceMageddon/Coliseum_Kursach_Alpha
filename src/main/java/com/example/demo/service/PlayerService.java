package com.example.demo.service;

import com.example.demo.model.PlayerEntity;
import com.example.demo.repo.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlayerService{
    @Autowired
    PlayerRepository playerRepository;

    private PlayerEntity playerEntity;

    public PlayerEntity findPlayerById(long id) { return playerRepository.findById(id).get();
    }

    public void safePlayer(PlayerEntity test){ playerRepository.save(test);}

    public String getPlayerEmail(long id){return playerRepository.findById(id).get().getEmail();}
    public String getPlayerPassword(long id){return playerRepository.findById(id).get().getPassword();}
    public String getPlayerPlayername(long id){return playerRepository.findById(id).get().getPlayername();}
    public int getPlayerHealth(long id) { return playerRepository.findById(id).get().getHealth(); }
    public int getPlayerDamage(long id) {
        return playerRepository.findById(id).get().getDamage();
    }
    public int getPlayerAbostb(long id) {return playerRepository.findById(id).get().getAbsorb();}
    public int getPlayerRegen(long id) {return playerRepository.findById(id).get().getRegen();}
    public int getPlayerFire(long id) {return playerRepository.findById(id).get().getFire();}
    public int getPlayerFirestatus(long id){return playerRepository.findById(id).get().getFirestatus();}
    public int getPlayerInsight(long id){return playerRepository.findById(id).get().getInsight();}
    public int getPlayerUpgrades(long id){return playerRepository.findById(id).get().getUpgrades();}
    public int getPlayerShield(long id){return playerRepository.findById(id).get().getUpgrades();}
    public int getPlayerParry(long id){return playerRepository.findById(id).get().getParry();}




}