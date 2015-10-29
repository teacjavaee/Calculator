package controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private TextField textFieldPower;

    @FXML
    private TextField textFieldLine;

    @FXML
    private CheckBox checkBoxLAP;

    @FXML
    private CheckBox checkBoxKTP;

    @FXML
    private CheckBox checkBoxPS;

    @FXML
    private Label labelnoNDS;

    @FXML
    private Label labelNDS;

    @FXML
    private Label labelFull;

    @FXML
    private Button buttonPDF;

    @FXML
    private ComboBox<String> comboBox;

    ObservableList<String> list = FXCollections.observableArrayList("0.8", "1.0", "1.15", "1.25");

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        textFieldPower.setTooltip(new Tooltip("Мощность вводится в кВт, в качестве разделителя использовать точку"));
       // textFieldPower.setStyle("-fx-font-weight:bold;-fx-font-size:10pt;-fx-font-family:Georgia"); если шрифт определен в FXML то здесь он переопределяеся и распространяется на весь текс поля.
        comboBox.setItems(list);
        textFieldLine.setVisible(false);
        if (checkBoxLAP.isSelected()) {
            textFieldLine.setVisible(true);
        }

    }
}
