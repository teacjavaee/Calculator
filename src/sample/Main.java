package sample;

import controllers.Controller;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        //Parent root = FXMLLoader.load(Main.class.getResource("../fxml/main.fxml")); абсолютный путь к файлу
        Parent root = FXMLLoader.load(getClass().getResource("../fxml/main.fxml"));
        primaryStage.setTitle("Расчет стоимости ТП");
        primaryStage.setMaxHeight(360);
        primaryStage.setMaxWidth(420);
        primaryStage.setScene(new Scene(root, 420, 360));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
        Controller controller = new Controller();
        Calculator calc = new Calculator();

        //double summa = Integer.parseInt(controller.getTextFieldPower().getText()) * calc.getC1();


    }
}
