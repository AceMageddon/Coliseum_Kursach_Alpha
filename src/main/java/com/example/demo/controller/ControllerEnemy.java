package com.example.demo.controller;

import com.example.demo.data.Data;
import com.example.demo.model.EnemyEntity;
import com.example.demo.repo.EnemyRepository;
import com.example.demo.service.EnemyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.Random;

@Controller
public class ControllerEnemy {
    @Autowired
    EnemyService enemyService;

    @Autowired
    EnemyRepository enemyRepository;


    public void createenemy(){
        Random r = new Random();
        Data.eid = r.nextInt(9)+1;
        Data.etitle = enemyService.getEnemyTitle(Data.eid);
        Data.ehealth = enemyService.getEnemyHealth(Data.eid) * Data.mlevel;
        Data.edamage = enemyService.getEnemyDamage(Data.eid) * Data.mlevel;
        Data.ehitch = enemyService.getEnemyHitch(Data.eid);
        Data.eattime = enemyService.getEnemyAttime(Data.eid);
        Data.ecritch = enemyService.getEnemyCritch(Data.eid);
        Data.ebreakch = enemyService.getEnemyBreakch(Data.eid);
        Data.ebody = enemyService.getEnemyBody(Data.eid);
        Data.ehead = enemyService.getEnemyHead(Data.eid);
        Data.earms = enemyService.getEnemyArms(Data.eid);
        Data.elegs = enemyService.getEnemyLegs(Data.eid);
        Data.elacrit = enemyService.getEnemyLacrit(Data.eid);
        Data.eracrit = enemyService.getEnemyRacrit(Data.eid);
        Data.ellcrit = enemyService.getEnemyLlcrit(Data.eid);
        Data.erlcrit = enemyService.getEnemyRlcrit(Data.eid);
        Data.eweapon = enemyService.getEnemyWeapon(Data.eid);
        int weak = 0;
        weak = r.nextInt(15)+0;
        if (weak == 1 || weak == 5 || weak == 6 || weak == 7 || weak == 11 || weak == 12 || weak == 13 || weak == 15){
            Data.elacrit = 1;
        }
        if (weak == 2 || weak == 5 || weak == 8 || weak == 9 || weak == 11 || weak == 13 || weak == 14 || weak == 15){
            Data.eracrit = 1;
        }
        if (weak == 3 || weak == 6 || weak == 8 || weak == 10 || weak == 11 || weak == 12 || weak == 14 || weak == 15){
            Data.ellcrit = 1;
        }
        if (weak == 4 || weak == 7 || weak == 9 || weak == 10 || weak == 12 || weak == 13 || weak == 14 || weak == 15){
            Data.erlcrit = 1;
        }
        Data.result = true;
        while (Data.result == true){
            Data.eid++;
            Data.result = enemyRepository.existsById(Data.eid);
        }
        updateenemy();
    }

    public void updateenemy(){
        EnemyEntity enemyEntity = new EnemyEntity();
        enemyEntity.setId(Data.eid);
        enemyEntity.setTitle(Data.etitle);
        enemyEntity.setHealth(Data.ehealth);
        enemyEntity.setDamage(Data.edamage);
        enemyEntity.setHitch(Data.ehitch);
        enemyEntity.setAttime(Data.eattime);
        enemyEntity.setCritch(Data.ecritch);
        enemyEntity.setBreakch(Data.ebreakch);
        enemyEntity.setBody(Data.ebody);
        enemyEntity.setHead(Data.ehead);
        enemyEntity.setArms(Data.earms);
        enemyEntity.setLegs(Data.elegs);
        enemyEntity.setLacrit(Data.elacrit);
        enemyEntity.setRacrit(Data.eracrit);
        enemyEntity.setLlcrit(Data.ellcrit);
        enemyEntity.setRlcrit(Data.erlcrit);
        enemyEntity.setWeapon(Data.eweapon);
        enemyRepository.save(enemyEntity);
    }

    public void getenemy(){
        Data.etitle = enemyService.getEnemyTitle(Data.eid);
        Data.ehealth = enemyService.getEnemyHealth(Data.eid) * Data.mlevel;
        Data.edamage = enemyService.getEnemyDamage(Data.eid) * Data.mlevel;
        Data.ehitch = enemyService.getEnemyHitch(Data.eid);
        Data.eattime = enemyService.getEnemyAttime(Data.eid);
        Data.ecritch = enemyService.getEnemyCritch(Data.eid);
        Data.ebreakch = enemyService.getEnemyBreakch(Data.eid);
        Data.ebody = enemyService.getEnemyBody(Data.eid);
        Data.ehead = enemyService.getEnemyHead(Data.eid);
        Data.earms = enemyService.getEnemyArms(Data.eid);
        Data.elegs = enemyService.getEnemyLegs(Data.eid);
        Data.elacrit = enemyService.getEnemyLacrit(Data.eid);
        Data.eracrit = enemyService.getEnemyRacrit(Data.eid);
        Data.ellcrit = enemyService.getEnemyLlcrit(Data.eid);
        Data.erlcrit = enemyService.getEnemyRlcrit(Data.eid);
        Data.eweapon = enemyService.getEnemyWeapon(Data.eid);
    }

    public void deleteenemy(){
        enemyRepository.deleteById(Data.eid);
    }
}
