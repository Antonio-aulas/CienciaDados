package cfi028_pizzariacompleta_2024;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.InvalidationListener;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;

import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.effect.Reflection;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class TelaInicialController implements Initializable {

 @FXML
 private ComboBox<String> cbSabores;
 @FXML
 private CheckBox chkQueijo;
 @FXML
 private CheckBox chkPresunto;
 @FXML
 private CheckBox chkCatupiry;
 @FXML
 private RadioButton rbRecheada;
 @FXML
 private RadioButton rbNormal;
 @FXML
 private RadioButton rbFina;
 @FXML
 private TextField txtNome;
 @FXML
 private ToggleButton btnCadastrar;
 @FXML
 private ListView<Pedidos> lstResumo;
 @FXML
 private ToggleGroup tgSO;
 @FXML
 private ToggleButton btnLimparComponentes;
 @FXML
 private ToggleButton btnApagar;
 @FXML
 private Label lblTotal;
 @FXML
 private Label lblTroco;
 @FXML
 private ToggleButton btnReinicializar;
 @FXML
 private ToggleButton btnTroco;
 @FXML
 private TextField txtTroco;

 ObservableList<Pedidos> obsPedidos = FXCollections.observableArrayList();
 Double preco = 0.0;

 Double[] precoSabor = {45.0, 41.0, 38.00, 51.0, 54.0};
 @FXML
 private AnchorPane containerPrincipal;

 @Override
 public void initialize(URL url, ResourceBundle rb) {
  inicializaComponentes();
 }

 @FXML
 private void btnCadastrarClick(ActionEvent event) {
  if (!cbSabores.getSelectionModel().isEmpty()) {
   int posicao = cbSabores.getSelectionModel().getSelectedIndex();
   preco = precoSabor[posicao];
   RadioButton rbSabores = (RadioButton) tgSO.getSelectedToggle();
   String texto = "";
   String Sabores;
   String nome = txtNome.getText();
   if (nome.isEmpty()) {
    alerta("Verifique o nome digitado !");
    txtNome.requestFocus();
   } else {
    texto = texto + cbSabores.getValue().toUpperCase() + ", ";
    if (chkQueijo.isSelected()) {
     preco = preco + 20.0;
     texto = texto + "Queijo, ";
    }
    if (chkPresunto.isSelected()) {
     texto = texto + "Presunto, ";
     preco = preco + 10.0;
    }
    if (chkCatupiry.isSelected()) {
     texto = texto + "Catupiry, ";
     preco = preco + 18.50;
    }
    Sabores = rbSabores.getText();
    texto = texto + Sabores + ".";
    Pedidos p = new Pedidos(nome, texto, preco);
    obsPedidos.add(p);
    System.out.println("aqui");
    lblTotal.setText(String.format("%.2f", preco));
    btnApagar.setDisable(false);
    limpar();
   }
  } else {
   alerta("Selecione um tipo de pizza");
  }
 }

 @FXML
 private void btnLimparComponentesClick(ActionEvent event) {
  limpar();
 }

 @FXML
 private void btnApagarClick(ActionEvent event) {
  // recebendo a posicao clicada no listview. Se -1, não foi clicado nennhum item
  int posicao = lstResumo.getSelectionModel().getSelectedIndex();
  if (posicao >= 0) {
   obsPedidos.remove(posicao);
  }
  if (obsPedidos.isEmpty()) {
   btnApagar.setDisable(true);
  }
 }

 public void inicializaComponentes() {
  lstResumo.setItems(obsPedidos);
  cbSabores.getItems().addAll(
   "Calabresa", "Presunto", "Queijo", "Napolitana", "Frango");

  btnApagar.setDisable(true);
  btnTroco.setDisable(true);

  txtTroco.textProperty().addListener((observable, oldValue, newValue) -> {
   if (newValue.isEmpty()) {
    // Se o texto estiver vazio, desabilitar o botão
    btnTroco.setDisable(true);
   } else {
    // Caso contrário, habilitar o botão
    btnTroco.setDisable(false);
   }
  });

  tgSO.selectToggle(rbFina);
  cbSabores.getSelectionModel().selectFirst();
  txtNome.requestFocus();

 }

 public void limpar() {
  txtNome.clear();
  lblTotal.setText("");
  tgSO.selectToggle(rbFina);
  cbSabores.setValue("Sabores de pizza");

  for (Node node : containerPrincipal.getChildren()) {
   if (node instanceof CheckBox) {
    // Se o nó for um CheckBox, imprime seu texto e desabilita
    CheckBox checkBox = (CheckBox) node;
    System.out.println("CheckBox encontrado: " + checkBox.getText());
    checkBox.setSelected(false);
   }
  }

 }

 public void alerta(String mensagem) {
  Alert alerta = new Alert(Alert.AlertType.ERROR);
  alerta.setTitle("ERRO");
  alerta.setContentText(mensagem);
  alerta.showAndWait();
 }

 @FXML
 private void btnReinicializarClick(ActionEvent event) {
  obsPedidos.clear();
  btnApagar.setDisable(true);
 }

 @FXML
 private void btnTrocoClick(ActionEvent event) {

  // lendo e validando um valor float 
  String valor1Str = txtTroco.getText();
  // Valida a entrada dos valores
  try {
   Double valor = Double.parseDouble(valor1Str);
   // Formata a saída com duas casas decimais
   if (valor >= preco) {
    Double troco = valor - preco;
    lblTroco.setText(String.format("%.2f", troco));
   } else {
    alerta("Valor insuficiente para pagamento");
   }
  } catch (NumberFormatException e) {
   // Caso a entrada seja inválida, exibe uma mensagem de erro
   alerta("Valor inválido");
   txtTroco.requestFocus();
  }
 }
}
