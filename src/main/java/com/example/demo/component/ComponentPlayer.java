package com.example.demo.component;

import com.example.demo.data.Data;
import com.example.demo.model.PlayerEntity;
import com.example.demo.repo.PlayerRepository;
import com.example.demo.service.PlayerService;
import com.example.demo.service.SendEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ComponentPlayer {

    @Autowired
    PlayerService playerService;

    @Autowired
    PlayerRepository playerRepository;

    @Autowired
    SendEmailService sendEmailService;


    public void getplayer(){
        Data.pemail = playerService.getPlayerEmail(Data.pid);
        Data.ppassword = playerService.getPlayerPassword(Data.pid);
        Data.pplayername = playerService.getPlayerPlayername(Data.pid);
        Data.phealth = playerService.getPlayerHealth(Data.pid);
        Data.pdamage = playerService.getPlayerDamage(Data.pid);
        Data.pabsorb = playerService.getPlayerAbostb(Data.pid);
        Data.pregen = playerService.getPlayerRegen(Data.pid);
        Data.pfire = playerService.getPlayerFire(Data.pid);
        Data.pfirestatus = playerService.getPlayerFirestatus(Data.pid);
        Data.pinsight = playerService.getPlayerInsight(Data.pid);
        Data.pupgrades = playerService.getPlayerUpgrades(Data.pid);
        Data.pshield = playerService.getPlayerShield(Data.pid);
        Data.pparry = playerService.getPlayerParry(Data.pid);
        Data.result = playerRepository.existsById(Long.valueOf(1));
    }

    public void updateplayer(){
        PlayerEntity playerEntity = new PlayerEntity();
        playerEntity.setId(Data.pid);
        playerEntity.setEmail(Data.pemail);
        playerEntity.setPassword(Data.ppassword);
        playerEntity.setPlayername(Data.pplayername);
        playerEntity.setHealth(Data.phealth);
        playerEntity.setDamage(Data.pdamage);
        playerEntity.setAbsorb(Data.pabsorb);
        playerEntity.setRegen(Data.pregen);
        playerEntity.setFire(Data.pfire);
        playerEntity.setFirestatus(Data.pfirestatus);
        playerEntity.setInsight(Data.pinsight);
        playerEntity.setUpgrades(Data.pupgrades);
        playerEntity.setShield(Data.pshield);
        playerEntity.setParry(Data.pparry);
        playerRepository.save(playerEntity);
    }

    public void checkemail() {
        Data.emailcheck = playerRepository.findByEmail(Data.pemail);
    }

    public void checkname() {
        Data.namecheck = playerRepository.findByPlayername(Data.pplayername);
    }

    public void checkhighscorename() {
        Data.checkplayername = playerService.getPlayerPlayername(Data.check);
    }

    public void findidbyemail(){
        Data.pid = 1;
        int result = 0;
        String email = "";
        while (result == 0){
            email = playerService.getPlayerEmail(Data.pid);
            if (!email.equals(Data.pemail)){
                Data.pid++;
            }
            else{
                result = 1;
                Data.passwordcheck = playerService.getPlayerPassword(Data.pid);
            }
        }
    }

    public void getoriginalplayer(){
        Data.oplayername = playerService.getPlayerPlayername(1);
        Data.ohealth = playerService.getPlayerHealth(1);
        Data.odamage = playerService.getPlayerDamage(1);
        Data.oabsorb = playerService.getPlayerAbostb(1);
        Data.oregen = playerService.getPlayerRegen(1);
        Data.ofire = playerService.getPlayerFire(1);
        Data.ofirestatus = playerService.getPlayerFirestatus(1);
        Data.oinsight = playerService.getPlayerInsight(1);
        Data.oupgrades = playerService.getPlayerUpgrades(1);
        Data.oshield = playerService.getPlayerShield(1);
        Data.oparry = playerService.getPlayerParry(1);
    }

    public void createnewplayer(){
        Data.result = true;
        Data.pid = 1;
        while (Data.result == true){
            Data.pid++;
            Data.result = playerRepository.existsById(Data.pid);
        }
        PlayerEntity playerEntity = new PlayerEntity();
        playerEntity.setId(Data.pid);
        playerEntity.setEmail(Data.pemail);
        playerEntity.setPassword(Data.ppassword);
        playerEntity.setPlayername(Data.oplayername);
        playerEntity.setHealth(Data.ohealth);
        playerEntity.setDamage(Data.odamage);
        playerEntity.setAbsorb(Data.oabsorb);
        playerEntity.setRegen(Data.oregen);
        playerEntity.setFire(Data.ofire);
        playerEntity.setFirestatus(Data.ofirestatus);
        playerEntity.setInsight(Data.oinsight);
        playerEntity.setUpgrades(Data.oupgrades);
        playerEntity.setShield(Data.oshield);
        playerEntity.setParry(Data.oparry);
        playerRepository.save(playerEntity);
    }

    public void returnsafe(){
        PlayerEntity playerEntity = new PlayerEntity();
        playerEntity.setId(Data.pid);
        playerEntity.setEmail(Data.pemail);
        playerEntity.setPassword(Data.ppassword);
        playerEntity.setPlayername(Data.pplayername);
        playerEntity.setHealth(Data.ohealth);
        playerEntity.setDamage(Data.odamage);
        playerEntity.setAbsorb(Data.oabsorb);
        playerEntity.setRegen(Data.oregen);
        playerEntity.setFire(Data.ofire);
        playerEntity.setFirestatus(0);
        playerEntity.setInsight(0);
        playerEntity.setUpgrades(Data.pupgrades);
        playerEntity.setShield(0);
        playerEntity.setParry(0);
        playerRepository.save(playerEntity);
    }
    public void sendregistrationemail(){
        sendEmailService.sendEmail(Data.pemail, "Thank you for joining our Coliseum, Gladiator. To finish the registration process, please use the following code: "+Data.code,"Registration Code:");
    }
    public void sendpasswordemail(){
        sendEmailService.sendEmail(Data.pemail, "Here is your the code that you have to input to confirm your account, in order to change your password: "+Data.code,"New Password:");
    }
}
