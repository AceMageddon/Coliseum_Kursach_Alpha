package com.example.demo.service;

import com.example.demo.model.EnemyEntity;
import com.example.demo.repo.EnemyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EnemyService {
    @Autowired
    private EnemyRepository enemyRepository;

    public EnemyEntity findEnemyById(long id) {
        return enemyRepository.findById(id).get();
    }

    public void safeEnemy(EnemyEntity test){ enemyRepository.save(test); }

    public String getEnemyTitle(long id) { return enemyRepository.findById(id).get().getTitle();}
    public int getEnemyHealth(long id) {
        return enemyRepository.findById(id).get().getHealth();
    }
    public int getEnemyDamage(long id) {
        return enemyRepository.findById(id).get().getDamage();
    }
    public int getEnemyHitch(long id) {return enemyRepository.findById(id).get().getHitch();}
    public int getEnemyAttime(long id) {return enemyRepository.findById(id).get().getAttime();}
    public int getEnemyCritch(long id) {return enemyRepository.findById(id).get().getCritch();}
    public int getEnemyBreakch(long id) {return enemyRepository.findById(id).get().getBreakch();}
    public int getEnemyBody(long id) {return enemyRepository.findById(id).get().getBody();}
    public int getEnemyHead(long id) {return enemyRepository.findById(id).get().getHead();}
    public int getEnemyArms(long id) {return enemyRepository.findById(id).get().getArms();}
    public int getEnemyLegs(long id) {return enemyRepository.findById(id).get().getLegs();}
    public int getEnemyLacrit(long id) {return enemyRepository.findById(id).get().getLacrit();}
    public int getEnemyRacrit(long id) {return enemyRepository.findById(id).get().getRacrit();}
    public int getEnemyLlcrit(long id) {return enemyRepository.findById(id).get().getLlcrit();}
    public int getEnemyRlcrit(long id) {return enemyRepository.findById(id).get().getRlcrit();}
    public String getEnemyWeapon(long id){return enemyRepository.findById(id).get().getWeapon();}









}
