package sio.suivimedical;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import sio.suivimedical.Tools.ConnexionBDD;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class SuiviMedicalController implements Initializable
{

    @FXML
    private ImageView imgPrescription;
    @FXML
    private ImageView imgConsultation;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        try {
            ConnexionBDD bdd = new ConnexionBDD();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    @FXML
    public void imgPrescriptionClicked(Event event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(SuiviMedicalApplication.class.getResource("prescription-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.setTitle("Préscription");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void imgConsultationClicked(Event event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(SuiviMedicalApplication.class.getResource("consultation-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.setTitle("Consultation");
        stage.setScene(scene);
        stage.show();
    }
}