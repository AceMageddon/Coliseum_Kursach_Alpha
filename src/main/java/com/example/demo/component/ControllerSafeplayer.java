package com.example.demo.component;

import com.example.demo.data.Data;
import com.example.demo.model.SafeplayerEntity;
import com.example.demo.repo.PlayerRepository;
import com.example.demo.repo.SafeplayerRepository;
import com.example.demo.service.PlayerService;
import com.example.demo.service.SafeplayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

@Controller
public class ControllerSafeplayer {

    @Autowired
    SafeplayerService safeplayerService;

    @Autowired
    SafeplayerRepository safeplayerRepository;

    public void getsafeplayer(){
        Data.ohealth = safeplayerService.getSafeplayerHealth(Data.pid);
        Data.odamage = safeplayerService.getSafeplayerDamage(Data.pid);
        Data.oabsorb = safeplayerService.getSafeplayerAbostb(Data.pid);
        Data.oregen = safeplayerService.getSafeplayerRegen(Data.pid);
        Data.ofire = safeplayerService.getSafeplayerFire(Data.pid);
    }

    public void updatesafe(){
        SafeplayerEntity safeplayerEntity = new SafeplayerEntity();
        safeplayerEntity.setId(Data.pid);
        safeplayerEntity.setHealth(Data.phealth);
        safeplayerEntity.setDamage(Data.pdamage);
        safeplayerEntity.setAbsorb(Data.pabsorb);
        safeplayerEntity.setRegen(Data.pregen);
        safeplayerEntity.setFire(Data.pfire);
        safeplayerRepository.save(safeplayerEntity);
    }
}
