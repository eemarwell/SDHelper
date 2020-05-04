package com.marwell.sdhelper.controller;

import com.marwell.sdhelper.Main;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Tab;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Eduardo Marwell
 */
public class MainWindowController implements Initializable {
    
    @FXML
    private Stage stage;
    
    @FXML
    private ResourceBundle resources;
    
    @FXML
    private ImageView logo;
    
    public final double widthLogo = 155.0;
    public final double heightLogo = 30.0;
    
    private Image logoImage;
    
    @FXML
    private Tab configuracoesTab;

    @FXML
    private URL location;

    @FXML
    public AnchorPane mainPane;
    
    @FXML
    private AnchorPane alertPane;
    
    @FXML
    private AnchorPane chatPane;
    
    @FXML
    private AnchorPane backlogPane;
    
    @FXML
    private AnchorPane configPane;

    @FXML
    private Button exitButton;

    @FXML
    private Button minButton;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //configuracoesTab.setDisable(true);
        logoImage = new Image("/res/icon.png");
        logo.setImage(logoImage);
        logo.setFitWidth(widthLogo);
        logo.setFitHeight(heightLogo);
        
        exitButton.setOnAction((ActionEvent event) -> {
            mainPane.setStyle("-fx-background-color: #000");
            Main.getPrimaryStage().setOpacity(1.0);
            Image logoutImage = new Image("/res/logout.png");
            logo.setImage(logoutImage);
            Alert alert = new Alert(AlertType.CONFIRMATION);
            alert.setTitle("Confirme sua escolha");
            alert.setHeaderText("Já está mesmo na hora de ir?");
            alert.setContentText("Lembre-se que ao fechar este programa, será marcado como offline.");
            alert.setResizable(false);
            Optional<ButtonType> result = alert.showAndWait();
            
            if ((result.isPresent()) && (result.get() == ButtonType.OK)) {
                Platform.exit();
                System.exit(0);
            } else {
                mainPane.setStyle("-fx-background-color: rgba(0, 96, 0, 0.0)");
                logo.setImage(logoImage);
            }
        });
        
        //loadWebviews();
        //minButton.setOnAction(e -> {
        //((Stage)((Button)e.getSource()).getScene().getWindow()).setIconified(true);
        //});<Button fx:id="minButton" layoutX="280.0" layoutY="6.0" mnemonicParsing="false" text="-" />
    }
}
