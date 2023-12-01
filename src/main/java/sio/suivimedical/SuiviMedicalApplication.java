package sio.suivimedical;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SuiviMedicalApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(SuiviMedicalApplication.class.getResource("suivimedical-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Suivi Médical");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}