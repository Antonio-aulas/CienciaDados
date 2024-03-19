/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cadastro;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Usuario
 */
public class CadastroImoveis extends Application {
  private static Stage stage;

  public static Stage getStage() {
    return stage;
  }

  public static void setStage(Stage stage) {
    CadastroImoveis.stage = stage;
  }
  @Override
  public void start(Stage palco) throws Exception {
    Parent root = FXMLLoader.load(getClass().getResource("/view/TelaImoveis.fxml"));
    Scene scene = new Scene(root);
    palco.setScene(scene);
    palco.show();
    setStage(palco);
  }
}
