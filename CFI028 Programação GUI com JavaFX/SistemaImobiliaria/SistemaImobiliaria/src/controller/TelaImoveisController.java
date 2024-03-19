/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import cadastro.CadastroImoveis;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import sistemaimobiliaria.SistemaImobiliaria;

/**
 * FXML Controller class
 *
 * @author Usuario
 */
public class TelaImoveisController implements Initializable {

  @FXML
  private Button btnFechar;

  /**
   * Initializes the controller class.
   */
  @Override
  public void initialize(URL url, ResourceBundle rb) {
    // TODO
  }  

  @FXML
  private void btnFecharClicked(MouseEvent event) {
    SistemaImobiliaria sisIm = new SistemaImobiliaria();
    CadastroImoveis.getStage().close();
    try {
      sisIm.start(new Stage());
    } catch (Exception ex) {
      Logger.getLogger(TelaImoveisController.class.getName()).log(Level.SEVERE, null, ex);
    }
    
  }
  
}
