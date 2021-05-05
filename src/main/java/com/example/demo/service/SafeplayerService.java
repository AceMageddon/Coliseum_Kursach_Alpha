package com.example.demo.service;

import com.example.demo.repo.SafeplayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SafeplayerService {

    @Autowired
    SafeplayerRepository safeplayerRepository;

    public int getSafeplayerHealth(long id) { return safeplayerRepository.findById(id).get().getHealth(); }
    public int getSafeplayerDamage(long id) {
        return safeplayerRepository.findById(id).get().getDamage();
    }
    public int getSafeplayerAbostb(long id) {return safeplayerRepository.findById(id).get().getAbsorb();}
    public int getSafeplayerRegen(long id) {return safeplayerRepository.findById(id).get().getRegen();}
    public int getSafeplayerFire(long id) {return safeplayerRepository.findById(id).get().getFire();}
}
