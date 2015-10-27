package controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private ComboBox <String> comboBox;

    ObservableList<String> list = FXCollections.observableArrayList("0.8","1.0","1.15","1.25");

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        comboBox.setItems(list);
    }
}
