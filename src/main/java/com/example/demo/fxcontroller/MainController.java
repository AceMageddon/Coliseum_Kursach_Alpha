package com.example.demo.fxcontroller;

import com.example.demo.controller.*;
import com.example.demo.data.Data;
import com.example.demo.hub.Menu;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import org.springframework.stereotype.Controller;
import javafx.scene.control.*;

import java.io.IOException;
import java.util.Objects;


@Controller
public class MainController {
    @FXML
    Button button1;

    @FXML
    CheckBox showpassword;

    @FXML
    CheckBox showpassword1;

    @FXML
    PasswordField regpassword;

    @FXML
    TextField regshowpassword;

    @FXML
    TextField regemail;

    @FXML
    Text regerror;

    @FXML
    TextField regcode;

    @FXML
    Text coderror;

    @FXML
    PasswordField logpassword;

    @FXML
    TextField logshowpassword;

    @FXML
    TextField logemail;

    @FXML
    Text logerror;

    @FXML
    Text coderror1;

    @FXML
    TextField logcode;

    @FXML
    PasswordField newpassword;

    @FXML
    TextField newshowpassword;

    @FXML
    CheckBox showpass;

    @FXML
    TextField emailfield;

    @FXML
    Text emailerror;

    public void signup(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/Registration.fxml"));
        Parent root = fxmlLoader.load();
        Data.stage.setScene(new Scene(root, 1280, 720));
        Data.stage.setMinWidth(1280);
        Data.stage.setMinHeight(720);
        Data.stage.show();
    }

    public void signin(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/Login.fxml"));
        Parent root = fxmlLoader.load();
        Data.stage.setScene(new Scene(root, 1280, 720));
        Data.stage.setMinWidth(1280);
        Data.stage.setMinHeight(720);
        Data.stage.show();
    }

    public void showpassword(ActionEvent actionEvent) {
        if (showpassword.isSelected()) {
            regshowpassword.setText(regpassword.getText());
            regpassword.setVisible(false);
            regshowpassword.setVisible(true);
        } else {
            regpassword.setText(regshowpassword.getText());
            regpassword.setVisible(true);
            regshowpassword.setVisible(false);
        }
    }

    public void gotocode(ActionEvent actionEvent) throws IOException {
        Data.reset = 0;
        Data.pemail = regemail.getText();
        if (showpassword.isSelected()) {
            Data.ppassword = regshowpassword.getText();
        }else{
            Data.ppassword = regpassword.getText();
        }
        ControllerPlayer controllerPlayer = (ControllerPlayer) SpringUtils.ctx.getBean(ControllerPlayer.class);
        controllerPlayer.checkemail();
        if (Data.emailcheck != null) {
            regerror.setText("It seems that a user with that email is already registered. Please enter another email.");
        }
        if (Data.emailcheck == null) {
            if (Data.pemail == ""){
                regerror.setText("Please input an email address.");
            }
            else if (Data.ppassword == ""){
                regerror.setText("Please input a password.");
            }
            else {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/Code.fxml"));
                Parent root = fxmlLoader.load();
                Data.stage.setScene(new Scene(root, 1280, 720));
                Data.stage.setMinWidth(1280);
                Data.stage.setMinHeight(720);
                Data.stage.show();
                Menu.codegenerator();
            }
        }
    }

    public void regfinish(ActionEvent actionEvent) throws IOException {
        ControllerSafeplayer controllerSafeplayer = (ControllerSafeplayer) SpringUtils.ctx.getBean(ControllerSafeplayer.class);
        ControllerPlayer controllerPlayer = (ControllerPlayer) SpringUtils.ctx.getBean(ControllerPlayer.class);
        ControllerMemory controllerMemory = (ControllerMemory) SpringUtils.ctx.getBean(ControllerMemory.class);
        String rez = regcode.getText();
        if (!Objects.equals(rez, Data.code)) {
            coderror.setText("I'm sorry, you've input an incorrect code, please try again.");
        }
        else {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/Success.fxml"));
            Parent root = fxmlLoader.load();
            Data.stage.setScene(new Scene(root, 1280, 720));
            Data.stage.setMinWidth(1280);
            Data.stage.setMinHeight(720);
            Data.stage.show();
            controllerPlayer.getoriginalplayer();
            controllerPlayer.createnewplayer();
            controllerPlayer.getplayer();
            controllerMemory.getoriginalmemory();
            Data.mplayernum++;
            controllerMemory.createnewmemory();
            controllerMemory.updateplayernum();
            controllerMemory.getmemory();
            controllerSafeplayer.updatesafe();
        }
    }

    public void gotohub(ActionEvent actionEvent) throws IOException {
        Data.pemail = logemail.getText();
        ControllerPlayer controllerPlayer = (ControllerPlayer) SpringUtils.ctx.getBean(ControllerPlayer.class);
        ControllerMemory controllerMemory = (ControllerMemory) SpringUtils.ctx.getBean(ControllerMemory.class);
        ControllerEnemy controllerEnemy = (ControllerEnemy) SpringUtils.ctx.getBean(ControllerEnemy.class);
        if (showpassword1.isSelected()) {
            Data.ppassword = logshowpassword.getText();
        }else{
            Data.ppassword = logpassword.getText();
        }
        controllerPlayer.checkemail();
        if (Data.emailcheck == null) {
            logerror.setText("Our apologies, but the email that you have input does not exist in our database.");
        }
        if (Data.emailcheck != null){
            controllerPlayer.findidbyemail();
            if (!Objects.equals(Data.passwordcheck, Data.ppassword)){
                logerror.setText("The password you've input is incorrect. Please check if your password again or reset it with the option below");
            }
            if (Objects.equals(Data.passwordcheck, Data.ppassword)){
                controllerPlayer.getplayer();
                controllerMemory.getmemory();
                if (Data.mbattlestatus == 0) {
                    if (Objects.equals(Data.pplayername, "none")){
                        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/FirstMeeting.fxml"));
                        Parent root = fxmlLoader.load();
                        Data.stage.setScene(new Scene(root, 1280, 720));
                        Data.stage.setMinWidth(1280);
                        Data.stage.setMinHeight(720);
                        Data.stage.show();
                    }else{
                        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/Hub.fxml"));
                        Parent root = fxmlLoader.load();
                        Data.stage.setScene(new Scene(root, 1280, 720));
                        Data.stage.setMinWidth(1280);
                        Data.stage.setMinHeight(720);
                        Data.stage.show();
                    }
                }
                if (Data.mbattlestatus == 1 || Data.mbattlestatus == 3){
                    controllerEnemy.getenemy();
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/PlayerBattle.fxml"));
                    Parent root = fxmlLoader.load();
                    Data.stage.setScene(new Scene(root, 1280, 720));
                    Data.stage.setMinWidth(1280);
                    Data.stage.setMinHeight(720);
                    Data.stage.show();
                }
                if (Data.mbattlestatus == 2){
                    controllerEnemy.getenemy();
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/EnemyBattle.fxml"));
                    Parent root = fxmlLoader.load();
                    Data.stage.setScene(new Scene(root, 1280, 720));
                    Data.stage.setMinWidth(1280);
                    Data.stage.setMinHeight(720);
                    Data.stage.show();
                }
                if (Data.mbattlestatus == 4){
                    if (Data.eid != 0) {
                        controllerEnemy.getenemy();
                    }
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/Results.fxml"));
                    Parent root = fxmlLoader.load();
                    Data.stage.setScene(new Scene(root, 1280, 720));
                    Data.stage.setMinWidth(1280);
                    Data.stage.setMinHeight(720);
                    Data.stage.show();
                }
            }
        }
    }

    public void forgotaction(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/Email.fxml"));
        Parent root = fxmlLoader.load();
        Data.stage.setScene(new Scene(root, 1280, 720));
        Data.stage.setMinWidth(1280);
        Data.stage.setMinHeight(720);
        Data.stage.show();
    }

    public void showpassword1(ActionEvent actionEvent) {
        if (showpassword1.isSelected()) {
            logshowpassword.setText(logpassword.getText());
            logpassword.setVisible(false);
            logshowpassword.setVisible(true);
        } else {
            logpassword.setText(logshowpassword.getText());
            logpassword.setVisible(true);
            logshowpassword.setVisible(false);
        }
    }

    public void pascheck(ActionEvent actionEvent) throws IOException {
        String rez = logcode.getText();
        if (!Objects.equals(rez, Data.code)) {
            coderror1.setText("I'm sorry, you've input an incorrect code, please try again.");
        }
        else {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/Password.fxml"));
            Parent root = fxmlLoader.load();
            Data.stage.setScene(new Scene(root, 1280, 720));
            Data.stage.setMinWidth(1280);
            Data.stage.setMinHeight(720);
            Data.stage.show();
        }
    }


    public void reset(ActionEvent actionEvent) throws IOException {
        ControllerPlayer controllerPlayer = (ControllerPlayer) SpringUtils.ctx.getBean(ControllerPlayer.class);
        controllerPlayer.getplayer();
        if (showpass.isSelected()) {
            Data.ppassword = newshowpassword.getText();
        }else{
            Data.ppassword = newpassword.getText();
        }
        controllerPlayer.updateplayer();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/ResetSuccess.fxml"));
        Parent root = fxmlLoader.load();
        Data.stage.setScene(new Scene(root, 1280, 720));
        Data.stage.setMinWidth(1280);
        Data.stage.setMinHeight(720);
        Data.stage.show();
    }

    public void showpass(ActionEvent actionEvent) {
        if (showpass.isSelected()) {
            newshowpassword.setText(newpassword.getText());
            newpassword.setVisible(false);
            newshowpassword.setVisible(true);
        } else {
            newpassword.setText(newshowpassword.getText());
            newpassword.setVisible(true);
            newshowpassword.setVisible(false);
        }
    }

    public void send(ActionEvent actionEvent) throws IOException {
        ControllerPlayer controllerPlayer = (ControllerPlayer) SpringUtils.ctx.getBean(ControllerPlayer.class);
        Data.pemail = emailfield.getText();
        controllerPlayer.checkemail();
        if (Data.emailcheck == null){
            emailerror.setText("You've input an incorrect email. Please input a correct email adress.");
        }else{
            controllerPlayer.findidbyemail();
            Data.reset = 1;
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/Reset.fxml"));
            Parent root = fxmlLoader.load();
            Data.stage.setScene(new Scene(root, 1280, 720));
            Data.stage.setMinWidth(1280);
            Data.stage.setMinHeight(720);
            Data.stage.show();
            Menu.codegenerator();
        }
    }
}



