/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemaimobiliaria;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Usuario
 */
public class SistemaImobiliaria extends Application {
  private static Stage stage;

  public static Stage getStage() {
    return stage;
  }

  public static void setStage(Stage stage) {
    SistemaImobiliaria.stage = stage;
  }
  @Override
  public void start(Stage palco) throws Exception {
    Parent root = FXMLLoader.load(getClass().getResource("/view/TelaInicial.fxml"));
    Scene scene = new Scene(root);
    palco.setScene(scene);
    palco.show();
    setStage(palco);
  }

 
  public static void main(String[] args) {
    launch(args);
  }
  
}
