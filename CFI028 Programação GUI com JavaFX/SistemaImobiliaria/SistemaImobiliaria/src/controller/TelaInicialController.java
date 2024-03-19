/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import cadastro.CadastroClientes;
import cadastro.CadastroImoveis;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import sistemaimobiliaria.SistemaImobiliaria;

/**
 *
 * @author Usuario
 */
public class TelaInicialController implements Initializable {

  @FXML   private Button btnClientes;
  @FXML   private Button btnImoveis;
  @FXML   private Button btnSair;
 @FXML    private MenuItem mniClientes;
 @FXML    private MenuItem mniImoveis;
  
  @Override
  public void initialize(URL url, ResourceBundle rb) {
  }  

   @FXML
  private void btnSairClicked(MouseEvent event) {
    SistemaImobiliaria.getStage().close();
  }

 @FXML
 private void btnClientesClicked(ActionEvent event) { 
  CadastroClientes cadCli = new CadastroClientes();
    SistemaImobiliaria.getStage().close();
    try {
      cadCli.start(new Stage());
    } catch (Exception ex) {
      System.out.println("Erro ao carregar tela Clientes");
    }
 }

 @FXML
 private void btnImoveisClicked(ActionEvent event) {  CadastroImoveis cadIm= new CadastroImoveis();
    SistemaImobiliaria.getStage().close();
    try {
      cadIm.start(new Stage());
    } catch (Exception ex) {
      System.out.println("Erro ao carregar tela Imoveis");    }
   }

}
