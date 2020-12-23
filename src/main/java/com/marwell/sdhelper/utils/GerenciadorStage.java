package com.marwell.sdhelper.utils;

import com.marwell.sdhelper.controller.MainWindowController;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author Eduardo Marwell
 */
public final class GerenciadorStage {
    MainWindowController main = new MainWindowController();
    public double originalHeight = 240;
    public double originalWidth = 364;
    public double originalOpacity = 0.90;

    public GerenciadorStage(Stage stage,String title, String view) throws IOException {
        Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();
        Parent root = FXMLLoader.load(getClass().getResource("/view/" +view));
        Scene scene = new Scene(root);
        
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setOpacity(0.90);
        stage.setAlwaysOnTop(true);
        stage.setResizable(false);
        stage.setX(primaryScreenBounds.getMaxX() / 2 - (originalWidth / 2));
        stage.setY(primaryScreenBounds.getMinY());
        stage.setWidth(originalWidth);
        stage.setHeight(originalHeight);
        stage.setTitle(title);
        stage.setScene(scene);
        stage.show();
        
        stage.focusedProperty().addListener((event)->{
            if (stage.focusedProperty().getValue()) {
                System.out.println("GerenciadorStage - focused");
                stage.setWidth(originalWidth);
                stage.setHeight(originalHeight);
                stage.setOpacity(originalOpacity);
            } else {                             
                System.out.println("GerenciadorStage - defocused");
                stage.setWidth(calculaLogoWidth());
                stage.setHeight(calculaLogoHeigh());
                stage.setOpacity(originalOpacity - 0.3);
            }
        });

    }
    
    public double calculaLogoWidth(){
        double margin = 16.0;
        double widthMinimizado = main.widthLogo + margin;
        return widthMinimizado;
    }
    
    public double calculaLogoHeigh(){
        double margin = 8.0;
        double heighMinimizado = main.heightLogo + margin;
        return heighMinimizado;
    }
}
