package com.example.demo.fxcontroller;

import com.example.demo.controller.*;
import com.example.demo.data.Data;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import org.springframework.stereotype.Controller;
import javafx.scene.control.*;
import javafx.scene.text.Text;

import java.io.IOException;
import java.util.Random;

@Controller
public class GameController {

    @FXML
    Text warning;

    @FXML
    TextField name;

    @FXML
    Button show;

    @FXML
    Text gold;

    @FXML
    Text silver;

    @FXML
    Text bronze;

    @FXML
    Text yourhs;

    @FXML
    Text responseup;

    @FXML
    Text noup;

    @FXML
    Button mainbegin;

    @FXML
    Button playerbegin;

    @FXML
    Button enemybegin;

    @FXML
    Text m1;

    @FXML
    Text m2;

    @FXML
    Text m3;

    @FXML
    Text m4;

    @FXML
    Text m5;

    @FXML
    Text m6;

    @FXML
    Text m7;

    @FXML
    Button opponentturn;

    @FXML
    Button enemyplayer;

    @FXML
    Text e1;

    @FXML
    Text e2;

    @FXML
    Text e3;

    @FXML
    Text e4;

    @FXML
    Text e5;

    @FXML
    Text e6;

    @FXML
    Text e7;

    @FXML
    Text e8;

    @FXML
    Text e9;

    @FXML
    Button playerenemy;

    @FXML
    Button playerturn;

    @FXML
    Button attack;

    @FXML
    Button block;

    @FXML
    Button heal;

    @FXML
    Button fire;

    @FXML
    Button head;

    @FXML
    Button body;

    @FXML
    Button rarm;

    @FXML
    Button larm;

    @FXML
    Button rleg;

    @FXML
    Button lleg;

    @FXML
    Text p1;

    @FXML
    Text p2;

    @FXML
    Text p3;

    @FXML
    Text p4;

    @FXML
    Text p5;

    @FXML
    Text p6;

    @FXML
    Text p7;

    @FXML
    Text p8;

    @FXML
    Text p9;

    @FXML
    Text p10;

    @FXML
    Text p11;

    @FXML
    Text p12;

    @FXML
    Button goback;

    @FXML
    Button youlost;

    @FXML
    Button youwon;

    @FXML
    Button showresult;

    @FXML
    Button backtohub;

    @FXML
    Text r1;

    @FXML
    Text r2;

    @FXML
    Text r3;

    @FXML
    Text r4;

    @FXML
    Text r5;

    @FXML
    Text r6;

    @FXML
    Text r7;

    @FXML
    Text r8;


    public void state(ActionEvent actionEvent) throws IOException {
        Data.pplayername = name.getText();
        ControllerPlayer controllerPlayer = (ControllerPlayer) SpringUtils.ctx.getBean(ControllerPlayer.class);
        controllerPlayer.checkname();
        if (Data.namecheck != null) {
            warning.setText("Such a name is already present here, state another.");
        } else {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/NameReact.fxml"));
            Parent root = fxmlLoader.load();
            Data.stage.setScene(new Scene(root, 1280, 720));
            Data.stage.setMinWidth(1280);
            Data.stage.setMinHeight(720);
            Data.stage.show();
        }
    }

    public void venture(ActionEvent actionEvent) throws IOException {
        ControllerPlayer controllerPlayer = (ControllerPlayer) SpringUtils.ctx.getBean(ControllerPlayer.class);
        ControllerEnemy controllerEnemy = (ControllerEnemy) SpringUtils.ctx.getBean(ControllerEnemy.class);
        ControllerMemory controllerMemory = (ControllerMemory) SpringUtils.ctx.getBean(ControllerMemory.class);
        controllerPlayer.updateplayer();
        controllerEnemy.createenemy();
        controllerMemory.updatememory();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/PrepBattle.fxml"));
        Parent root = fxmlLoader.load();
        Data.stage.setScene(new Scene(root, 1280, 720));
        Data.stage.setMinWidth(1280);
        Data.stage.setMinHeight(720);
        Data.stage.show();
    }


    public void upgrade(ActionEvent actionEvent) throws IOException {
        if (Data.pupgrades == 0) {
            noup.setText("‘I’m sorry, " + Data.pplayername + ", but I cannot make you stronger yet. Win some battles and come here with the rewards,’");
        } else {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/Upgrade.fxml"));
            Parent root = fxmlLoader.load();
            Data.stage.setScene(new Scene(root, 1280, 720));
            Data.stage.setMinWidth(1280);
            Data.stage.setMinHeight(720);
            Data.stage.show();
        }
    }

    public void highscore(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/Highscore.fxml"));
        Parent root = fxmlLoader.load();
        Data.stage.setScene(new Scene(root, 1280, 720));
        Data.stage.setMinWidth(1280);
        Data.stage.setMinHeight(720);
        Data.stage.show();

    }

    public void show(ActionEvent actionEvent) {
        ControllerPlayer controllerPlayer = (ControllerPlayer) SpringUtils.ctx.getBean(ControllerPlayer.class);
        ControllerMemory controllerMemory = (ControllerMemory) SpringUtils.ctx.getBean(ControllerMemory.class);
        Data.x1 = 0;
        Data.x2 = 0;
        Data.x3 = 0;
        Data.y1 = "";
        Data.y2 = "";
        Data.y3 = "";
        int repeat = 1;
        while (repeat != 4) {
            Data.check = 1;
            while (Data.check != Data.mplayernum + 1) {
                controllerMemory.gethighscore();
                controllerPlayer.checkhighscorename();
                if (Data.x1 < Data.checkhighscore && Data.checkhighscore > Data.x2 && Data.checkhighscore > Data.x3) {
                    Data.x1 = Data.checkhighscore;
                    Data.y1 = Data.checkplayername;
                }
                if (Data.x2 < Data.checkhighscore && Data.checkhighscore < Data.x1 && Data.checkhighscore > Data.x3) {
                    Data.x2 = Data.checkhighscore;
                    Data.y2 = Data.checkplayername;
                }
                if (Data.x3 < Data.checkhighscore && Data.checkhighscore < Data.x1 && Data.checkhighscore < Data.x2) {
                    Data.x3 = Data.checkhighscore;
                    Data.y3 = Data.checkplayername;
                }
                Data.check++;
            }
            repeat++;
        }
        show.setVisible(false);
        gold.setText("Gold: " + Data.y1 + ": " + Data.x1);
        silver.setText("Silver: " + Data.y2 + ": " + Data.x2);
        bronze.setText("Bronze: " + Data.y3 + ": " + Data.x3);
        yourhs.setText("Your highscore, " + Data.pplayername + ", is: " + Data.mhighscore);
    }

    public void back(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/Hub.fxml"));
        Parent root = fxmlLoader.load();
        Data.stage.setScene(new Scene(root, 1280, 720));
        Data.stage.setMinWidth(1280);
        Data.stage.setMinHeight(720);
        Data.stage.show();
        ControllerMemory controllerMemory = (ControllerMemory) SpringUtils.ctx.getBean(ControllerMemory.class);
        ControllerPlayer controllerPlayer = (ControllerPlayer) SpringUtils.ctx.getBean(ControllerPlayer.class);
        ControllerSafeplayer controllerSafeplayer = (ControllerSafeplayer) SpringUtils.ctx.getBean(ControllerSafeplayer.class);
        Data.mparryammount = 0;
        Data.mstrike = 0;
        controllerSafeplayer.getsafeplayer();
        controllerPlayer.returnsafe();
        Data.mbattlestatus = 0;
        controllerMemory.updatememory();
    }

    public void hitup(ActionEvent actionEvent) {
        if (Data.pupgrades == 0) {
            responseup.setText("‘I’m sorry, " + Data.pplayername + ", but I cannot make you stronger yet. Win some battles and come here with the rewards,’");
        } else {
            ControllerSafeplayer controllerSafeplayer = (ControllerSafeplayer) SpringUtils.ctx.getBean(ControllerSafeplayer.class);
            ControllerPlayer controllerPlayer = (ControllerPlayer) SpringUtils.ctx.getBean(ControllerPlayer.class);
            Data.pdamage = Data.pdamage * 5;
            Data.pupgrades--;
            Data.pshield = 0;
            controllerSafeplayer.updatesafe();
            controllerPlayer.updateplayer();
            responseup.setText("'Your hits have become stronger,'");
        }
    }

    public void healthup(ActionEvent actionEvent) {
        if (Data.pupgrades == 0) {
            responseup.setText("‘I’m sorry, " + Data.pplayername + ", but I cannot make you stronger yet. Win some battles and come here with the rewards,’");
        } else {
            ControllerSafeplayer controllerSafeplayer = (ControllerSafeplayer) SpringUtils.ctx.getBean(ControllerSafeplayer.class);
            ControllerPlayer controllerPlayer = (ControllerPlayer) SpringUtils.ctx.getBean(ControllerPlayer.class);
            Data.pabsorb++;
            Data.pupgrades--;
            Data.pshield = 0;
            controllerSafeplayer.updatesafe();
            controllerPlayer.updateplayer();
            responseup.setText("'Your shield will protect you from more harm,'");
        }
    }

    public void armup(ActionEvent actionEvent) {
        if (Data.pupgrades == 0) {
            responseup.setText("‘I’m sorry, " + Data.pplayername + ", but I cannot make you stronger yet. Win some battles and come here with the rewards,’");
        } else {
            ControllerSafeplayer controllerSafeplayer = (ControllerSafeplayer) SpringUtils.ctx.getBean(ControllerSafeplayer.class);
            ControllerPlayer controllerPlayer = (ControllerPlayer) SpringUtils.ctx.getBean(ControllerPlayer.class);
            Data.phealth = Data.phealth * 5;
            Data.pupgrades--;
            Data.pshield = 0;
            controllerSafeplayer.updatesafe();
            controllerPlayer.updateplayer();
            responseup.setText("'Your armor will be more durable in combat,'");
        }
    }

    public void medup(ActionEvent actionEvent) {
        if (Data.pupgrades == 0) {
            responseup.setText("‘I’m sorry, " + Data.pplayername + ", but I cannot make you stronger yet. Win some battles and come here with the rewards,’");
        } else {
            ControllerSafeplayer controllerSafeplayer = (ControllerSafeplayer) SpringUtils.ctx.getBean(ControllerSafeplayer.class);
            ControllerPlayer controllerPlayer = (ControllerPlayer) SpringUtils.ctx.getBean(ControllerPlayer.class);
            Data.pregen++;
            Data.pupgrades--;
            Data.pshield = 0;
            controllerSafeplayer.updatesafe();
            controllerPlayer.updateplayer();
            responseup.setText("'Your gourd has been expanded,'");
        }
    }

    public void fireup(ActionEvent actionEvent) {
        if (Data.pupgrades == 0) {
            responseup.setText("‘I’m sorry, " + Data.pplayername + ", but I cannot make you stronger yet. Win some battles and come here with the rewards,’");
        } else {
            ControllerSafeplayer controllerSafeplayer = (ControllerSafeplayer) SpringUtils.ctx.getBean(ControllerSafeplayer.class);
            ControllerPlayer controllerPlayer = (ControllerPlayer) SpringUtils.ctx.getBean(ControllerPlayer.class);
            Data.pfire++;
            Data.pupgrades--;
            Data.pshield = 0;
            controllerSafeplayer.updatesafe();
            controllerPlayer.updateplayer();
            responseup.setText("You have one more opportunity to make unleash your shield's true strength,'");
        }
    }

    public void mainbegin(ActionEvent actionEvent) {
        mainbegin.setVisible(false);
        Random r = new Random();
        m1.setText("You go there, to the Coliseum. From the tribunes, there are ghostly figures. ");
        if (Data.mlevel > 0 && Data.mlevel < 4) {
            m2.setText("Most of them are sadly cheering against you.");
        }
        if (Data.mlevel > 3 && Data.mlevel < 7) {
            m2.setText("Some are cheering against you, but others, to your surprise, for you.");
        }
        if (Data.mlevel > 6) {
            m2.setText("They are cheering for you, their champion. Better not disappoint them now, right?");
        }
        m3.setText("Against you stands " + Data.etitle + " with " + Data.eweapon + " ready for battle against you.");
        m4.setText("Fate tosses the coin to decide which of the Gladiators will begin the battle.");
        m5.setText("In the end...");
        ControllerMemory controllerMemory = (ControllerMemory) SpringUtils.ctx.getBean(ControllerMemory.class);
        int coin = r.nextInt(2) + 1;
        if (coin == 1) {
            m6.setText("It has chosen you to begin the battle. Lucky you.");
            m7.setText(Data.pplayername + " begins the battle!");
            playerbegin.setVisible(true);
        }
        if (coin == 2) {
            m6.setText("Your opponent will make his first turn. Be ready.");
            m7.setText(Data.etitle + " begins the battle!");
            enemybegin.setVisible(true);
        }
        Data.mbattlestatus = coin;
        controllerMemory.updatememory();
    }

    public void enemybegin(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/EnemyBattle.fxml"));
        Parent root = fxmlLoader.load();
        Data.stage.setScene(new Scene(root, 1280, 720));
        Data.stage.setMinWidth(1280);
        Data.stage.setMinHeight(720);
        Data.stage.show();
    }

    public void playerbegin(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/PlayerBattle.fxml"));
        Parent root = fxmlLoader.load();
        Data.stage.setScene(new Scene(root, 1280, 720));
        Data.stage.setMinWidth(1280);
        Data.stage.setMinHeight(720);
        Data.stage.show();
        Data.insightblock = 0;
        Data.turn = 0;
    }

    public void enemyattack(ActionEvent actionEvent) {
        opponentturn.setVisible(false);
        ControllerPlayer controllerPlayer = (ControllerPlayer) SpringUtils.ctx.getBean(ControllerPlayer.class);
        ControllerMemory controllerMemory = (ControllerMemory) SpringUtils.ctx.getBean(ControllerMemory.class);
        ControllerEnemy controllerEnemy = (ControllerEnemy) SpringUtils.ctx.getBean(ControllerEnemy.class);
        e1.setText(Data.etitle + " faces against you, preparing himself.");
        int ogattime = Data.eattime;
        Random r = new Random();
        while (Data.eattime > 0) {
            int hitch = r.nextInt(100) + 1;
            int parry = r.nextInt(100) + 1;
            if (hitch < Data.ehitch) {
                int critch = r.nextInt(100) + 1;
                int mod = 1;
                String info = " damage to you.";
                if (critch < Data.ecritch) {
                    mod = 2;
                    info = " some Critical damage towards you.";
                }
                if (Data.pshield == 1) {
                    mod = mod / Data.pabsorb;
                    if (parry < Data.ebreakch) {
                        Data.eattime = 0;
                        Data.pparry = 1;
                        Data.mparryammount++;
                        Data.ebody = Data.ebody + 10;
                        Data.ehead = Data.ehead + 10;
                        Data.earms = Data.earms + 10;
                        Data.ehead = Data.ehead + 10;
                        e7.setText("Your shield parried their attacked. Time for you to strike");
                    } else {
                        if (ogattime - Data.eattime == 0) {
                            e2.setText("The opponent has dealt " + Data.edamage * mod + info);
                        }
                        if (ogattime - Data.eattime == 1) {
                            e3.setText("The opponent has dealt " + Data.edamage * mod + info);
                        }
                        if (ogattime - Data.eattime == 2) {
                            e4.setText("The opponent has dealt " + Data.edamage * mod + info);
                        }
                        if (ogattime - Data.eattime == 3) {
                            e5.setText("The opponent has dealt " + Data.edamage * mod + info);
                        }
                        if (ogattime - Data.eattime == 4) {
                            e6.setText("The opponent has dealt " + Data.edamage * mod + info);
                        }
                        if (ogattime - Data.eattime == 5) {
                            e7.setText("The opponent has dealt " + Data.edamage * mod + info);
                        }
                        Data.phealth = Data.phealth - (Data.edamage * mod);
                    }
                } else {
                    if (ogattime - Data.eattime == 0) {
                        e2.setText("The opponent has dealt " + Data.edamage * mod + info);
                    }
                    if (ogattime - Data.eattime == 1) {
                        e3.setText("The opponent has dealt " + Data.edamage * mod + info);
                    }
                    if (ogattime - Data.eattime == 2) {
                        e4.setText("The opponent has dealt " + Data.edamage * mod + info);
                    }
                    if (ogattime - Data.eattime == 3) {
                        e5.setText("The opponent has dealt " + Data.edamage * mod + info);
                    }
                    if (ogattime - Data.eattime == 4) {
                        e6.setText("The opponent has dealt " + Data.edamage * mod + info);
                    }
                    if (ogattime - Data.eattime == 5) {
                        e7.setText("The opponent has dealt " + Data.edamage * mod + info);
                    }
                    Data.phealth = Data.phealth - (Data.edamage * mod);
                }
            } else {
                if (ogattime - Data.eattime == 0) {
                    e2.setText("The opponent missed his attack, while striking at you.");
                }
                if (ogattime - Data.eattime == 1) {
                    e3.setText("The opponent missed his attack, while striking at you.");
                }
                if (ogattime - Data.eattime == 2) {
                    e4.setText("The opponent missed his attack, while striking at you.");
                }
                if (ogattime - Data.eattime == 3) {
                    e5.setText("The opponent missed his attack, while striking at you.");
                }
                if (ogattime - Data.eattime == 4) {
                    e6.setText("The opponent missed his attack, while striking at you.");
                }
                if (ogattime - Data.eattime == 5) {
                    e7.setText("The opponent missed his attack, while striking at you.");
                }
            }
            Data.eattime--;
            controllerMemory.updatememory();
            controllerPlayer.updateplayer();
            controllerEnemy.updateenemy();
        }
        e8.setText("Your opponent seems tired out, leaving you with " + Data.phealth + " health left.");
        if (Data.phealth <= 0) {
            e9.setText("You have been defeated");
            Data.eattime = ogattime;
            Data.mbattlestatus=4;
            controllerMemory.updatememory();
            controllerEnemy.updateenemy();
            youlost.setVisible(true);
        } else {
            Data.eattime = ogattime;
            Data.mbattlestatus = 1;
            controllerMemory.updatememory();
            controllerPlayer.updateplayer();
            controllerEnemy.updateenemy();
            e9.setText("It is time for you to strike.");
            enemyplayer.setVisible(true);
            Data.insightblock = 0;
            Data.turn = 0;
        }
    }

    public void playerattack(ActionEvent actionEvent) {
        body.setVisible(false);
        rarm.setVisible(false);
        larm.setVisible(false);
        lleg.setVisible(false);
        rleg.setVisible(false);
        goback.setVisible(false);
        playerturn.setVisible(false);
        ControllerPlayer controllerPlayer = (ControllerPlayer) SpringUtils.ctx.getBean(ControllerPlayer.class);
        ControllerInfo controllerInfo = (ControllerInfo) SpringUtils.ctx.getBean(ControllerInfo.class);
        ControllerMemory controllerMemory = (ControllerMemory) SpringUtils.ctx.getBean(ControllerMemory.class);
        ControllerEnemy controllerEnemy = (ControllerEnemy) SpringUtils.ctx.getBean(ControllerEnemy.class);
        p9.setText("");
        p10.setText("");
        p11.setText("");
        p12.setText("");
        Random r = new Random();
        p1.setText("You, " + Data.pplayername + ", are facing a legendary opponent " + Data.etitle + ", who currently has +" + Data.ehealth + ".");
        p2.setText("It is your opportunity to strike, " + Data.pplayername + ".");
        if (Data.insightblock == 0) {
            if (Data.ellcrit == 1 || Data.erlcrit == 1 || Data.elacrit == 1 || Data.eracrit == 1) {
                int insight = r.nextInt(5) + 3;
                int result = 0;
                if (insight == Data.pinsight) {
                    while (result != 1) {
                        p3.setText("You noticed something peculiar about your opponent.");
                        int chooserandom = r.nextInt(4) + 1;
                        if (chooserandom == 1) {
                            if (Data.elacrit == 1) {
                                Data.iid = r.nextInt(10) + 6;
                                result = 1;
                            }
                        }
                        if (chooserandom == 2) {
                            if (Data.eracrit == 1) {
                                Data.iid = r.nextInt(5) + 1;
                                result = 1;
                            }
                        }
                        if (chooserandom == 3) {
                            if (Data.ellcrit == 1) {
                                Data.iid = r.nextInt(15) + 11;
                                result = 1;
                            }
                        }
                        if (chooserandom == 4) {
                            if (Data.erlcrit == 1) {
                                Data.iid = r.nextInt(20) + 16;
                                result = 1;
                            }
                        }
                    }
                    controllerInfo.getinfo();
                    p4.setText(Data.idata);
                } else {
                    p3.setText("You have not noticed anything in peculiar about your opponent.");
                    Data.pinsight++;
                    if (Data.pinsight == 6) {
                        Data.pinsight = 0;
                    }
                }
            } else {
                p3.setText("You have not noticed anything in peculiar about your opponent.");
            }
            Data.insightblock++;
        }
        Data.conf = 0;
        if (Data.ehealth <= 0) {
            Data.turn = 1;
        }
        p6.setText("What do you choose to do? ");
        attack.setVisible(true);
        block.setVisible(true);
        heal.setVisible(true);
        fire.setVisible(true);
        if (Data.pshield == 1) {
            p5.setText("You are no longer putting up a defensive position.");
            Data.pshield = 0;
            controllerPlayer.updateplayer();
        }
        if (Data.pfirestatus > 0) {
            Data.pfirestatus++;
            Data.pmod = 2;
            if (Data.pfirestatus == 6) {
                Data.pfirestatus = 0;
            }
        } else {
            Data.pmod = 1;
        }
        if (Data.turn == 1) {
            attack.setVisible(false);
            block.setVisible(false);
            heal.setVisible(false);
            fire.setVisible(false);
            head.setVisible(false);
            body.setVisible(false);
            rarm.setVisible(false);
            larm.setVisible(false);
            lleg.setVisible(false);
            rleg.setVisible(false);
            goback.setVisible(false);
            if (Data.ehealth <= 0) {
                youwon.setVisible(true);
                Data.mbattlestatus = 4;
            } else {
                if (Data.pparry == 1) {
                    p11.setText("The opponent comes back to their senses. Be warned.");
                    Data.pparry = 0;
                    Data.ebody = Data.ebody - 10;
                    Data.ehead = Data.ehead - 10;
                    Data.earms = Data.earms - 10;
                    Data.ehead = Data.ehead - 10;
                }
                Data.mbattlestatus = 2;
                p12.setText(Data.etitle + " will now strike.");
                playerenemy.setVisible(true);
            }
        }
        controllerMemory.updatememory();
        controllerPlayer.updateplayer();
        controllerEnemy.updateenemy();
    }

    public void attack(ActionEvent actionEvent) {
        p7.setText("You have decided to strike");
        Random r = new Random();
        attack.setVisible(false);
        block.setVisible(false);
        heal.setVisible(false);
        fire.setVisible(false);
        head.setVisible(true);
        body.setVisible(true);
        rarm.setVisible(true);
        larm.setVisible(true);
        lleg.setVisible(true);
        rleg.setVisible(true);
        goback.setVisible(true);
        p8.setText("Choose an area to target:");
        Data.hitch = r.nextInt(100) + 1;
    }

    public void block(ActionEvent actionEvent) {
        attack.setVisible(false);
        block.setVisible(false);
        heal.setVisible(false);
        fire.setVisible(false);
        ControllerPlayer controllerPlayer = (ControllerPlayer) SpringUtils.ctx.getBean(ControllerPlayer.class);
        ControllerMemory controllerMemory = (ControllerMemory) SpringUtils.ctx.getBean(ControllerMemory.class);
        ControllerEnemy controllerEnemy = (ControllerEnemy) SpringUtils.ctx.getBean(ControllerEnemy.class);
        p7.setText("Hopefully that shield can sustain the coming damage.");
        Data.pshield = 1;
        Data.turn = 1;
        if (Data.turn == 1) {
            attack.setVisible(false);
            block.setVisible(false);
            heal.setVisible(false);
            fire.setVisible(false);
            head.setVisible(false);
            body.setVisible(false);
            rarm.setVisible(false);
            larm.setVisible(false);
            lleg.setVisible(false);
            rleg.setVisible(false);
            goback.setVisible(false);
            if (Data.ehealth <= 0) {
                youwon.setVisible(true);
                Data.mbattlestatus = 4;
            } else {
                if (Data.pparry == 1) {
                    p11.setText("The opponent comes back to their senses. Be warned.");
                    Data.pparry = 0;
                    Data.ebody = Data.ebody - 10;
                    Data.ehead = Data.ehead - 10;
                    Data.earms = Data.earms - 10;
                    Data.ehead = Data.ehead - 10;
                }
                Data.mbattlestatus = 2;
                p12.setText(Data.etitle + " will now strike.");
                playerenemy.setVisible(true);
            }
        }
        controllerMemory.updatememory();
        controllerPlayer.updateplayer();
        controllerEnemy.updateenemy();
    }

    public void heal(ActionEvent actionEvent) {
        ControllerPlayer controllerPlayer = (ControllerPlayer) SpringUtils.ctx.getBean(ControllerPlayer.class);
        ControllerMemory controllerMemory = (ControllerMemory) SpringUtils.ctx.getBean(ControllerMemory.class);
        ControllerEnemy controllerEnemy = (ControllerEnemy) SpringUtils.ctx.getBean(ControllerEnemy.class);
        if (Data.pregen != 0) {
            attack.setVisible(false);
            block.setVisible(false);
            heal.setVisible(false);
            fire.setVisible(false);
            Data.pregen--;
            Data.phealth = Data.phealth + (150 * Data.mlevel / 3);
            p7.setText("You have restored " + Data.phealth / 3 + " health, and in total you currently have " + Data.phealth + " health. But remember that you can use your gourd only " + Data.pregen + "more times.");
            Data.turn = 1;
        } else {
            p7.setText("You do not have anything in the healing gourd left.");
        }
        if (Data.turn == 1) {
            attack.setVisible(false);
            block.setVisible(false);
            heal.setVisible(false);
            fire.setVisible(false);
            head.setVisible(false);
            body.setVisible(false);
            rarm.setVisible(false);
            larm.setVisible(false);
            lleg.setVisible(false);
            rleg.setVisible(false);
            goback.setVisible(false);
            if (Data.ehealth <= 0) {
                youwon.setVisible(true);
                Data.mbattlestatus = 4;
            } else {
                if (Data.pparry == 1) {
                    p11.setText("The opponent comes back to their senses. Be warned.");
                    Data.pparry = 0;
                    Data.ebody = Data.ebody - 10;
                    Data.ehead = Data.ehead - 10;
                    Data.earms = Data.earms - 10;
                    Data.ehead = Data.ehead - 10;
                }
                Data.mbattlestatus = 2;
                p12.setText(Data.etitle + " will now strike.");
                playerenemy.setVisible(true);
            }
        }
        controllerMemory.updatememory();
        controllerPlayer.updateplayer();
        controllerEnemy.updateenemy();
    }

    public void fire(ActionEvent actionEvent) {
        ControllerPlayer controllerPlayer = (ControllerPlayer) SpringUtils.ctx.getBean(ControllerPlayer.class);
        if (Data.pfirestatus == 0) {
            if (Data.pfire != 0) {
                Data.pfire--;
                Data.pfirestatus = 1;
                p7.setText("Show them the true strength of that shield!");
            } else {
                p7.setText("Your shield is out of its fuel.");
            }
        } else {
            p7.setText("The fuel is already in effect.");
        }
        controllerPlayer.updateplayer();
    }

    public void head(ActionEvent actionEvent) {
        Data.mstrike++;
        Random r = new Random();
        Data.hitch = r.nextInt(100) + 1;
        ControllerPlayer controllerPlayer = (ControllerPlayer) SpringUtils.ctx.getBean(ControllerPlayer.class);
        ControllerMemory controllerMemory = (ControllerMemory) SpringUtils.ctx.getBean(ControllerMemory.class);
        ControllerEnemy controllerEnemy = (ControllerEnemy) SpringUtils.ctx.getBean(ControllerEnemy.class);
        p9.setText("And the attack on the head...");
        if (Data.hitch <= Data.ehead) {
            if (Data.mbattlestatus == 1) {
                Data.pmod = Data.pmod * 4;
                p11.setText("They are having quiet a headache. A good opportunity to strike again.");
            }
            Data.pmod = Data.pmod * 2;
            p10.setText("Hits a total of " + Data.pdamage * Data.pmod + " damage!");
            Data.ehealth = Data.ehealth - (Data.pdamage * Data.pmod);
            controllerMemory.updatememory();
            controllerPlayer.updateplayer();
            controllerEnemy.updateenemy();
            if (Data.mbattlestatus == 3) {
                Data.turn = 1;
            } else {
                Data.mbattlestatus = 3;
                controllerMemory.updatememory();
                p12.setText("Fate has given you the opportunity to make another move. Do not waste it.");
            }
        } else {
            p10.setText("Misses!");
            Data.turn = 1;
        }
        if (Data.turn == 1) {
            attack.setVisible(false);
            block.setVisible(false);
            heal.setVisible(false);
            fire.setVisible(false);
            head.setVisible(false);
            body.setVisible(false);
            rarm.setVisible(false);
            larm.setVisible(false);
            lleg.setVisible(false);
            rleg.setVisible(false);
            goback.setVisible(false);
            if (Data.ehealth <= 0) {
                youwon.setVisible(true);
                Data.mbattlestatus = 4;
            } else {
                if (Data.pparry == 1) {
                    p11.setText("The opponent comes back to their senses. Be warned.");
                    Data.pparry = 0;
                    Data.ebody = Data.ebody - 10;
                    Data.ehead = Data.ehead - 10;
                    Data.earms = Data.earms - 10;
                    Data.ehead = Data.ehead - 10;
                }
                Data.mbattlestatus = 2;
                p12.setText(Data.etitle + " will now strike.");
                playerenemy.setVisible(true);
            }
        }
        controllerMemory.updatememory();
        controllerPlayer.updateplayer();
        controllerEnemy.updateenemy();
    }

    public void body(ActionEvent actionEvent) {
        Data.mstrike++;
        Random r = new Random();
        Data.hitch = r.nextInt(100) + 1;
        ControllerPlayer controllerPlayer = (ControllerPlayer) SpringUtils.ctx.getBean(ControllerPlayer.class);
        ControllerMemory controllerMemory = (ControllerMemory) SpringUtils.ctx.getBean(ControllerMemory.class);
        ControllerEnemy controllerEnemy = (ControllerEnemy) SpringUtils.ctx.getBean(ControllerEnemy.class);
        p9.setText("And the attack on the body...");
        if (Data.hitch <= Data.ebody) {
            p10.setText("Hits a total of " + Data.pdamage * Data.pmod + " damage!");
            Data.ehealth = Data.ehealth - (Data.pdamage * Data.pmod);
            controllerMemory.updatememory();
            controllerPlayer.updateplayer();
            controllerEnemy.updateenemy();
        } else {
            p10.setText("Misses!");
        }
        Data.turn = 1;
        if (Data.turn == 1) {
            attack.setVisible(false);
            block.setVisible(false);
            heal.setVisible(false);
            fire.setVisible(false);
            head.setVisible(false);
            body.setVisible(false);
            rarm.setVisible(false);
            larm.setVisible(false);
            lleg.setVisible(false);
            rleg.setVisible(false);
            goback.setVisible(false);
            if (Data.ehealth <= 0) {
                youwon.setVisible(true);
                Data.mbattlestatus = 4;
            } else {
                if (Data.pparry == 1) {
                    p11.setText("The opponent comes back to their senses. Be warned.");
                    Data.pparry = 0;
                    Data.ebody = Data.ebody - 10;
                    Data.ehead = Data.ehead - 10;
                    Data.earms = Data.earms - 10;
                    Data.ehead = Data.ehead - 10;
                }
                Data.mbattlestatus = 2;
                p12.setText(Data.etitle + " will now strike.");
                playerenemy.setVisible(true);
            }
        }
        controllerMemory.updatememory();
        controllerPlayer.updateplayer();
        controllerEnemy.updateenemy();
    }

    public void rarm(ActionEvent actionEvent) {
        Data.mstrike++;
        Random r = new Random();
        Data.hitch = r.nextInt(100) + 1;
        ControllerPlayer controllerPlayer = (ControllerPlayer) SpringUtils.ctx.getBean(ControllerPlayer.class);
        ControllerMemory controllerMemory = (ControllerMemory) SpringUtils.ctx.getBean(ControllerMemory.class);
        ControllerEnemy controllerEnemy = (ControllerEnemy) SpringUtils.ctx.getBean(ControllerEnemy.class);
        p9.setText("And the attack on the right arm...");
        if (Data.hitch <= Data.earms) {
            if (Data.eracrit == 1) {
                Data.ebody += 5;
                Data.ehead += 5;
                Data.earms += 5;
                Data.ecritch -= 10;
                Data.ehitch -= 10;
                Data.ebreakch += 10;
                Data.pmod = Data.pmod * 4;
                p11.setText("It seems that limb was weaken! Strike them again!");
            }
            p10.setText("Hits a total of " + Data.pdamage * Data.pmod + " damage!");
            Data.ehealth = Data.ehealth - (Data.pdamage * Data.pmod);
            controllerMemory.updatememory();
            controllerPlayer.updateplayer();
            controllerEnemy.updateenemy();
            if (Data.eracrit == 1) {
                Data.eracrit = 0;
                controllerEnemy.updateenemy();
                p12.setText("Fate has given you the opportunity to make another move. Do not waste it.");
            } else {
                Data.turn = 1;
            }
        } else {
            System.out.println("Misses!");
            Data.turn = 1;
        }
        if (Data.turn == 1) {
            attack.setVisible(false);
            block.setVisible(false);
            heal.setVisible(false);
            fire.setVisible(false);
            head.setVisible(false);
            body.setVisible(false);
            rarm.setVisible(false);
            larm.setVisible(false);
            lleg.setVisible(false);
            rleg.setVisible(false);
            goback.setVisible(false);
            if (Data.ehealth <= 0) {
                youwon.setVisible(true);
                Data.mbattlestatus = 4;
            } else {
                if (Data.pparry == 1) {
                    p11.setText("The opponent comes back to their senses. Be warned.");
                    Data.pparry = 0;
                    Data.ebody = Data.ebody - 10;
                    Data.ehead = Data.ehead - 10;
                    Data.earms = Data.earms - 10;
                    Data.ehead = Data.ehead - 10;
                }
                Data.mbattlestatus = 2;
                p12.setText(Data.etitle + " will now strike.");
                playerenemy.setVisible(true);
            }
        }
        controllerMemory.updatememory();
        controllerPlayer.updateplayer();
        controllerEnemy.updateenemy();
    }

    public void larm(ActionEvent actionEvent) {
        Data.mstrike++;
        Random r = new Random();
        Data.hitch = r.nextInt(100) + 1;
        ControllerPlayer controllerPlayer = (ControllerPlayer) SpringUtils.ctx.getBean(ControllerPlayer.class);
        ControllerMemory controllerMemory = (ControllerMemory) SpringUtils.ctx.getBean(ControllerMemory.class);
        ControllerEnemy controllerEnemy = (ControllerEnemy) SpringUtils.ctx.getBean(ControllerEnemy.class);
        p9.setText("And the attack on the left arm...");
        if (Data.hitch <= Data.earms) {
            if (Data.elacrit == 1) {
                Data.pmod = Data.pmod * 4;
                Data.ebody += 5;
                Data.ehead += 5;
                Data.earms += 5;
                Data.ecritch -= 10;
                Data.ehitch -= 10;
                Data.ebreakch += 10;
                p11.setText("You have dealt critical damage! You have cut their hand. Holding a weapon for them will be quiet a trouble now.");
            }
            p10.setText("Hits a total of " + Data.pdamage * Data.pmod + " damage!");
            Data.ehealth = Data.ehealth - (Data.pdamage * Data.pmod);
            controllerMemory.updatememory();
            controllerPlayer.updateplayer();
            controllerEnemy.updateenemy();
            if (Data.elacrit == 1) {
                Data.elacrit = 0;
                controllerEnemy.updateenemy();
                p12.setText("Fate has given you the opportunity to make another move. Do not waste it.");
            } else {
                Data.turn = 1;
            }
        } else {
            p10.setText("Misses!");
            Data.turn = 1;
        }
        if (Data.turn == 1) {
            attack.setVisible(false);
            block.setVisible(false);
            heal.setVisible(false);
            fire.setVisible(false);
            head.setVisible(false);
            body.setVisible(false);
            rarm.setVisible(false);
            larm.setVisible(false);
            lleg.setVisible(false);
            rleg.setVisible(false);
            goback.setVisible(false);
            if (Data.ehealth <= 0) {
                youwon.setVisible(true);
                Data.mbattlestatus = 4;
            } else {
                if (Data.pparry == 1) {
                    p11.setText("The opponent comes back to their senses. Be warned.");
                    Data.pparry = 0;
                    Data.ebody = Data.ebody - 10;
                    Data.ehead = Data.ehead - 10;
                    Data.earms = Data.earms - 10;
                    Data.ehead = Data.ehead - 10;
                }
                Data.mbattlestatus = 2;
                p12.setText(Data.etitle + " will now strike.");
                playerenemy.setVisible(true);
            }
        }
        controllerMemory.updatememory();
        controllerPlayer.updateplayer();
        controllerEnemy.updateenemy();
    }

    public void lleg(ActionEvent actionEvent) {
        Data.mstrike++;
        Random r = new Random();
        Data.hitch = r.nextInt(100) + 1;
        ControllerPlayer controllerPlayer = (ControllerPlayer) SpringUtils.ctx.getBean(ControllerPlayer.class);
        ControllerMemory controllerMemory = (ControllerMemory) SpringUtils.ctx.getBean(ControllerMemory.class);
        ControllerEnemy controllerEnemy = (ControllerEnemy) SpringUtils.ctx.getBean(ControllerEnemy.class);
        p9.setText("And the attack on the left leg...");
        if (Data.hitch <= Data.elegs) {
            if (Data.ellcrit == 1) {
                Data.ebody += 5;
                Data.ehead += 5;
                Data.elegs += 5;
                Data.ecritch -= 10;
                Data.ehitch -= 10;
                Data.ebreakch += 10;
                Data.pmod = Data.pmod * 4;
                p11.setText("Their leg was struck. Let us see how they can strike now.");
            }
            p10.setText("Hits a total of " + Data.pdamage * Data.pmod + " damage!");
            Data.ehealth = Data.ehealth - (Data.pdamage * Data.pmod);
            controllerMemory.updatememory();
            controllerPlayer.updateplayer();
            controllerEnemy.updateenemy();
            if (Data.ellcrit == 1) {
                Data.ellcrit = 0;
                controllerEnemy.updateenemy();
                p12.setText("Fate has given you the opportunity to make another move. Do not waste it.");
            } else {
                Data.turn = 1;
            }
        } else {
            p10.setText("Misses!");
            Data.turn = 1;
        }
        if (Data.turn == 1) {
            attack.setVisible(false);
            block.setVisible(false);
            heal.setVisible(false);
            fire.setVisible(false);
            head.setVisible(false);
            body.setVisible(false);
            rarm.setVisible(false);
            larm.setVisible(false);
            lleg.setVisible(false);
            rleg.setVisible(false);
            goback.setVisible(false);
            if (Data.ehealth <= 0) {
                youwon.setVisible(true);
                Data.mbattlestatus = 4;
            } else {
                if (Data.pparry == 1) {
                    p11.setText("The opponent comes back to their senses. Be warned.");
                    Data.pparry = 0;
                    Data.ebody = Data.ebody - 10;
                    Data.ehead = Data.ehead - 10;
                    Data.earms = Data.earms - 10;
                    Data.ehead = Data.ehead - 10;
                }
                Data.mbattlestatus = 2;
                p12.setText(Data.etitle + " will now strike.");
                playerenemy.setVisible(true);
            }
        }
        controllerMemory.updatememory();
        controllerPlayer.updateplayer();
        controllerEnemy.updateenemy();
    }

    public void rleg(ActionEvent actionEvent) {
        Data.mstrike++;
        Random r = new Random();
        Data.hitch = r.nextInt(100) + 1;
        ControllerPlayer controllerPlayer = (ControllerPlayer) SpringUtils.ctx.getBean(ControllerPlayer.class);
        ControllerMemory controllerMemory = (ControllerMemory) SpringUtils.ctx.getBean(ControllerMemory.class);
        ControllerEnemy controllerEnemy = (ControllerEnemy) SpringUtils.ctx.getBean(ControllerEnemy.class);
        p9.setText("And the attack on the right leg...");
        if (Data.hitch <= Data.elegs) {
            if (Data.erlcrit == 1) {
                Data.ebody += 5;
                Data.ehead += 5;
                Data.elegs += 5;
                Data.ecritch -= 10;
                Data.ehitch -= 10;
                Data.ebreakch += 10;
                Data.pmod = Data.pmod * 4;
                p11.setText("Their leg was struck. Let us see how they can strike now.");
            }
            p10.setText("Hits a total of " + Data.pdamage * Data.pmod + " damage!");
            Data.ehealth = Data.ehealth - (Data.pdamage * Data.pmod);
            controllerMemory.updatememory();
            controllerPlayer.updateplayer();
            controllerEnemy.updateenemy();
            if (Data.erlcrit == 1) {
                Data.erlcrit = 0;
                controllerEnemy.updateenemy();
                p12.setText("Fate has given you the opportunity to make another move. Do not waste it.");
            } else {
                Data.turn = 1;
            }
        } else {
            p9.setText("Misses!");
            Data.turn = 1;
        }
        if (Data.turn == 1) {
            attack.setVisible(false);
            block.setVisible(false);
            heal.setVisible(false);
            fire.setVisible(false);
            head.setVisible(false);
            body.setVisible(false);
            rarm.setVisible(false);
            larm.setVisible(false);
            lleg.setVisible(false);
            rleg.setVisible(false);
            goback.setVisible(false);
            if (Data.ehealth <= 0) {
                youwon.setVisible(true);
                Data.mbattlestatus = 4;
            } else {
                if (Data.pparry == 1) {
                    p11.setText("The opponent comes back to their senses. Be warned.");
                    Data.pparry = 0;
                    Data.ebody = Data.ebody - 10;
                    Data.ehead = Data.ehead - 10;
                    Data.earms = Data.earms - 10;
                    Data.ehead = Data.ehead - 10;
                }
                Data.mbattlestatus = 2;
                p12.setText(Data.etitle + " will now strike.");
                playerenemy.setVisible(true);
            }
        }
        controllerMemory.updatememory();
        controllerPlayer.updateplayer();
        controllerEnemy.updateenemy();
    }


    public void gotoresult(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/Results.fxml"));
        Parent root = fxmlLoader.load();
        Data.stage.setScene(new Scene(root, 1280, 720));
        Data.stage.setMinWidth(1280);
        Data.stage.setMinHeight(720);
        Data.stage.show();
    }

    public void showresult(ActionEvent actionEvent) {
        showresult.setVisible(false);
        ControllerMemory controllerMemory = (ControllerMemory) SpringUtils.ctx.getBean(ControllerMemory.class);
        ControllerEnemy controllerEnemy = (ControllerEnemy) SpringUtils.ctx.getBean(ControllerEnemy.class);
        int score = 0;
        if (Data.phealth <= 0) {
            r1.setText("YOU LOST!");
        } else {
            r1.setText("YOU WON!");
            if (Data.eid != 0) {
                Data.pupgrades++;
                Data.mlevel++;
            }
            r2.setText("You won a holy coin! Your current holy coin amount: " + Data.pupgrades);
            r3.setText("The amount of health left: " + Data.phealth);
            r4.setText("The amount of strikes:" + Data.mstrike);
            r5.setText("The amount of parrying: " + Data.mparryammount);
            r6.setText("The current level: " + Data.mlevel);
            score = Data.phealth * 1000 + (Data.mstrike + Data.mparryammount) * 10000 + Data.mlevel * 20000;
        }
        r7.setText("Your total score for this battle: " + score);
        if (score > Data.mhighscore) {
            Data.mhighscore = score;
        }
        r8.setText("Your current highscore: " + Data.mhighscore);
        if (Data.eid != 0) {
            controllerEnemy.deleteenemy();
            Data.eid = 0;
        }
        controllerMemory.updatememory();
        backtohub.setVisible(true);
    }
}



