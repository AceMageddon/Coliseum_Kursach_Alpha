package com.example.demo;

import com.example.demo.data.Data;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;


@SpringBootApplication
public class DemoApplication extends Application {
    private ConfigurableApplicationContext springContext;
    private Parent rootNode;

    @FXML
    Button button1;

    public static void main(String[] args) {
        Data.pemail = "";
        Data.ppassword = "";
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setScene(new Scene(rootNode, 1280, 720));
        stage.setMinWidth(1280);
        stage.setMinHeight(720);
        stage.show();
        Data.stage = stage;
    }

    @Override
    public void init() throws Exception{
        springContext = SpringApplication.run(DemoApplication.class);
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/MainWindow.fxml"));
        fxmlLoader.setControllerFactory(springContext::getBean);
        rootNode = fxmlLoader.load();
    }


    public void stop() throws Exception{
        springContext.close();
    }




}