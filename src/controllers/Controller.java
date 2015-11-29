package controllers;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import sample.Calculator;

import java.math.BigDecimal;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private TextField textFieldPower;

    @FXML
    private TextField textFieldLineVL;

    @FXML
    private TextField textFieldLineKL;

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
    private Button buttonSumma;

    @FXML
    private ComboBox<String> comboBox;


    ObservableList<String> listcomboBox = FXCollections.observableArrayList("0.8", "1.0", "1.15", "1.25");
    Tooltip tooltipLine = new Tooltip("Расстояние указывается в км.");
    Calculator calc = new Calculator();

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        textFieldPower.setTooltip(new Tooltip("Мощность вводится в кВт, в качестве разделителя использовать точку"));
        comboBox.setItems(listcomboBox);

        textFieldLineVL.setVisible(false);
        textFieldLineVL.setTooltip(tooltipLine);

        textFieldLineKL.setVisible(false);
        textFieldLineKL.setTooltip(tooltipLine);

        checkBoxLAP.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if (checkBoxLAP.isSelected()) {
                    textFieldLineVL.setVisible(true);
                    textFieldLineKL.setVisible(true);

                } else {
                    textFieldLineVL.setVisible(false);
                    textFieldLineKL.setVisible(false);
                    textFieldLineKL.clear();
                    textFieldLineVL.clear();
                }
            }
        });
    }

    public void actionButtonPressed(ActionEvent actionEvent) {
        double noNDS = new BigDecimal((Double.parseDouble(textFieldPower.getText()) * calc.getC1() * Double.parseDouble(comboBox.getValue()))).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        double Full = new BigDecimal((Double.parseDouble(textFieldPower.getText()) * calc.getC1() * Double.parseDouble(comboBox.getValue()))* 1.18).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        double NDS = new BigDecimal((Double.parseDouble(textFieldPower.getText()) * calc.getC1() * Double.parseDouble(comboBox.getValue()) * 0.18)).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        labelnoNDS.setText("Стоимость без НДС: " + noNDS + " .руб");
        labelFull.setText("Итого c НДС: " + Full + " .руб");
        labelNDS.setText("НДС: " + NDS + " .руб");
    }


}
