/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cfi028_pizzariacompleta_2024;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Usuario
 */
public class CFI028_PizzariaCompleta_2024 extends Application {
 
 @Override
 public void start(Stage stage) throws Exception {
  Parent root = FXMLLoader.load(getClass().getResource("TelaInicial.fxml"));

    Scene scene = new Scene(root);
    scene.getStylesheets().clear();
    stage.setScene(scene);
    stage.show();
 }

 /**
  * @param args the command line arguments
  */
 public static void main(String[] args) {
  launch(args);
 }
 
}
