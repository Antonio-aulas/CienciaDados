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
import sistemaimobiliaria.SistemaImobiliaria;

/**
 *
 * @author Usuario
 */
public class CadastroClientes extends Application {
  private static Stage stage;

  public static Stage getStage() {
    return stage;
  }

  public static void setStage(Stage stage) {
    CadastroClientes.stage = stage;
  }
  @Override
  public void start(Stage palco) throws Exception {
    Parent root = FXMLLoader.load(getClass().getResource("/view/TelaClientes.fxml"));
    Scene scene = new Scene(root);
    palco.setScene(scene);
    palco.show();
    setStage(palco);
  }
}
