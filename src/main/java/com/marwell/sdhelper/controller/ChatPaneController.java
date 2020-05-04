/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marwell.sdhelper.controller;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author Eduardo Marwell
 */
public class ChatPaneController implements Initializable {

    @FXML
    private ImageView loadingGif;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        loadingGif.setOpacity(0.6);
        
        new Timer().schedule(
            new TimerTask() {

                @Override
                public void run() {
                    loadingGif.setOpacity(0.0);
                    teste();
                }
            }, 0, 5000);

        
    }
    
    public void teste (){
        try {
            Thread.sleep(2000L);
        } catch (Exception e) {
        }
        loadingGif.setOpacity(0.6);
    }
}
