package com.marwell.sdhelper.controller;

import com.marwell.sdhelper.model.types.ClipboardEnum;
import com.marwell.sdhelper.utils.ClipboardUtil;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

/**
 * FXML Controller class
 *
 * @author Eduardo Marwell
 */
public class HelperPaneController implements Initializable {

    @FXML
    private Button btnSessaoAberta;
    
    @FXML
    private Button btnSessaoFechada;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) { 

    }
    
    public void sessaoAberta(){        
        if (ClipboardUtil.copiaBotao(btnSessaoAberta, 2000L, btnSessaoAberta.getText())) {
            ClipboardUtil.copiaClipboard(ClipboardEnum.SESSAOABERTA);
        }
    }
    
    public void sessaoFechada(){
        if (ClipboardUtil.copiaBotao(btnSessaoFechada, 2000L, btnSessaoFechada.getText())) {
            ClipboardUtil.copiaClipboard(ClipboardEnum.SESSAOFECHADA);
        }
    }
}
