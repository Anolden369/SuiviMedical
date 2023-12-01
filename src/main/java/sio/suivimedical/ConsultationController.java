package sio.suivimedical;

import javafx.event.Event;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import sio.suivimedical.Entities.Consultation;
import sio.suivimedical.Entities.Medicament;
import sio.suivimedical.Tools.ServicesConsultation;
import sio.suivimedical.Tools.ServicesMedicament;


import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ConsultationController implements Initializable
{
    @javafx.fxml.FXML
    private TableView<Consultation> tvConsultations;
    @javafx.fxml.FXML
    private TableColumn tcNumeroConsultation;
    @javafx.fxml.FXML
    private TableColumn tcDateConsultation;
    @javafx.fxml.FXML
    private TableColumn tcNomPatient;
    @javafx.fxml.FXML
    private TableColumn tcNomMedecin;
    @javafx.fxml.FXML
    private TableColumn tcMontantConsultation;
    @javafx.fxml.FXML
    private TableView<Medicament> tvMedicamentsPrescrits;
    @javafx.fxml.FXML
    private TableColumn tcNumeroMedicament;
    @javafx.fxml.FXML
    private TableColumn tcNomMedicament;
    @javafx.fxml.FXML
    private TableColumn tcPrixMedicament;

    ServicesConsultation servicesConsultation;
    ServicesMedicament servicesMedicament;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        // A vous de jouer
        servicesConsultation = new ServicesConsultation();
        tcNumeroConsultation.setCellValueFactory(new PropertyValueFactory<Consultation, Integer>("numero"));
        tcDateConsultation.setCellValueFactory(new PropertyValueFactory<Consultation, String>("date"));
        tcNomPatient.setCellValueFactory(new  PropertyValueFactory<Consultation, String>("nomPatient"));
        tcNomMedecin.setCellValueFactory(new PropertyValueFactory<Consultation, String>("nomMedecin"));
        tcMontantConsultation.setCellValueFactory(new PropertyValueFactory<Consultation, Double>("montant"));

        try {
            tvConsultations.setItems(servicesConsultation.GetAlllesConsultations());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @javafx.fxml.FXML
    public void tvConsultationsClicked(Event event) throws SQLException
    {
        // A vous de jouer
        servicesMedicament = new ServicesMedicament();
        int idConsultationSelectionne = tvConsultations.getSelectionModel().getSelectedItem().getNumero();
        tcNumeroMedicament.setCellValueFactory(new PropertyValueFactory<Medicament, Integer>("numero"));
        tcNomMedicament.setCellValueFactory(new PropertyValueFactory<Medicament, String>("nom"));
        tcPrixMedicament.setCellValueFactory(new PropertyValueFactory<Medicament, Double>("prix"));

        tvMedicamentsPrescrits.setItems(servicesMedicament.GetListeMedicPrescrit(idConsultationSelectionne));


    }
}
