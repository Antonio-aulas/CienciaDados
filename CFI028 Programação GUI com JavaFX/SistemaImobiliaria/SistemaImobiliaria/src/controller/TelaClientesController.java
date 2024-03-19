/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import cadastro.CadastroClientes;
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
public class TelaClientesController implements Initializable {
  @FXML
  private Button btnFechar;
  @Override
  public void initialize(URL url, ResourceBundle rb) {
 }  

  @FXML
  private void btnFecharClicked(MouseEvent event) {
    SistemaImobiliaria sisIm = new SistemaImobiliaria();
    CadastroClientes.getStage().close();
    try {
      sisIm.start(new Stage());
    } catch (Exception ex) {
      System.out.println("Não foi possivel fechar a ela Clientes");;
    }
  }
  
}
