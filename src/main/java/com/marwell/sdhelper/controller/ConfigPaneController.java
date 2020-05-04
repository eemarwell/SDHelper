package com.marwell.sdhelper.controller;

import com.marwell.sdhelper.utils.GerenciadorStage;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Eduardo Marwell
 */
public class ConfigPaneController implements Initializable {
    
    @FXML
    private Button newAgent;

    @FXML
    private Button editAgent;
    
    @FXML
    private Button delAgent;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }
    
    public void deletarAgente() {
        System.out.println("deletado");
    }
    
    public void editarAgente() throws IOException {
        GerenciadorStage iniciador;
        iniciador = new GerenciadorStage(new Stage(),"Editar Agente","agents/EditAgent.fxml");
    }
    
    public void novoAgente() {
        System.out.println("novo");
    }
    
}
