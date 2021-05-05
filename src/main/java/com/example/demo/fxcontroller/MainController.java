package com.example.demo.fxcontroller;

import com.example.demo.component.*;
import com.example.demo.data.Data;
import com.example.demo.hub.Menu;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import org.springframework.stereotype.Component;
import javafx.scene.control.*;

import java.io.IOException;
import java.util.Objects;


@Component
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
        ComponentPlayer componentPlayer = (ComponentPlayer) SpringUtils.ctx.getBean(ComponentPlayer.class);
        componentPlayer.checkemail();
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
        ComponentSafeplayer componentSafeplayer = (ComponentSafeplayer) SpringUtils.ctx.getBean(ComponentSafeplayer.class);
        ComponentPlayer componentPlayer = (ComponentPlayer) SpringUtils.ctx.getBean(ComponentPlayer.class);
        ComponentMemory componentMemory = (ComponentMemory) SpringUtils.ctx.getBean(ComponentMemory.class);
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
            componentPlayer.getoriginalplayer();
            componentPlayer.createnewplayer();
            componentPlayer.getplayer();
            componentMemory.getoriginalmemory();
            Data.mplayernum++;
            componentMemory.createnewmemory();
            componentMemory.updateplayernum();
            componentMemory.getmemory();
            componentSafeplayer.updatesafe();
        }
    }

    public void gotohub(ActionEvent actionEvent) throws IOException {
        Data.pemail = logemail.getText();
        ComponentPlayer componentPlayer = (ComponentPlayer) SpringUtils.ctx.getBean(ComponentPlayer.class);
        ComponentMemory componentMemory = (ComponentMemory) SpringUtils.ctx.getBean(ComponentMemory.class);
        ComponentEnemy componentEnemy = (ComponentEnemy) SpringUtils.ctx.getBean(ComponentEnemy.class);
        if (showpassword1.isSelected()) {
            Data.ppassword = logshowpassword.getText();
        }else{
            Data.ppassword = logpassword.getText();
        }
        componentPlayer.checkemail();
        if (Data.emailcheck == null) {
            logerror.setText("Our apologies, but the email that you have input does not exist in our database.");
        }
        if (Data.emailcheck != null){
            componentPlayer.findidbyemail();
            if (!Objects.equals(Data.passwordcheck, Data.ppassword)){
                logerror.setText("The password you've input is incorrect. Please check if your password again or reset it with the option below");
            }
            if (Objects.equals(Data.passwordcheck, Data.ppassword)){
                componentPlayer.getplayer();
                componentMemory.getmemory();
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
                    componentEnemy.getenemy();
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/PlayerBattle.fxml"));
                    Parent root = fxmlLoader.load();
                    Data.stage.setScene(new Scene(root, 1280, 720));
                    Data.stage.setMinWidth(1280);
                    Data.stage.setMinHeight(720);
                    Data.stage.show();
                }
                if (Data.mbattlestatus == 2){
                    componentEnemy.getenemy();
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/EnemyBattle.fxml"));
                    Parent root = fxmlLoader.load();
                    Data.stage.setScene(new Scene(root, 1280, 720));
                    Data.stage.setMinWidth(1280);
                    Data.stage.setMinHeight(720);
                    Data.stage.show();
                }
                if (Data.mbattlestatus == 4){
                    if (Data.eid != 0) {
                        componentEnemy.getenemy();
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
        ComponentPlayer componentPlayer = (ComponentPlayer) SpringUtils.ctx.getBean(ComponentPlayer.class);
        componentPlayer.getplayer();
        if (showpass.isSelected()) {
            Data.ppassword = newshowpassword.getText();
        }else{
            Data.ppassword = newpassword.getText();
        }
        componentPlayer.updateplayer();
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
        ComponentPlayer componentPlayer = (ComponentPlayer) SpringUtils.ctx.getBean(ComponentPlayer.class);
        Data.pemail = emailfield.getText();
        componentPlayer.checkemail();
        if (Data.emailcheck == null){
            emailerror.setText("You've input an incorrect email. Please input a correct email adress.");
        }else{
            componentPlayer.findidbyemail();
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

