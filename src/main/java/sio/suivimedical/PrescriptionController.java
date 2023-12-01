package sio.suivimedical;

import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.converter.IntegerStringConverter;
import sio.suivimedical.Entities.Medicament;
import sio.suivimedical.Tools.*;


import java.net.URL;
import java.sql.SQLException;

import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class PrescriptionController implements Initializable
{
    @javafx.fxml.FXML
    private TableView<Medicament> tvMedicamentsPrescrits;
    @javafx.fxml.FXML
    private Button btnInsererPrescription;
    @javafx.fxml.FXML
    private TextField txtNumeroConsultation;
    @javafx.fxml.FXML
    private DatePicker dpDateConsultation;
    @javafx.fxml.FXML
    private ComboBox cboPatients;
    @javafx.fxml.FXML
    private ComboBox cboMedecins;
    @javafx.fxml.FXML
    private TableColumn tcNumeroMedicament;
    @javafx.fxml.FXML
    private TableColumn tcNomMedicament;
    @javafx.fxml.FXML
    private TableColumn tcPrixMedicament;
    @javafx.fxml.FXML
    private TableColumn<Medicament,Integer> tcQuantiteMedicament;

    ServicesConsultation servicesConsultation;
    ServicesPatient servicesPatient;
    ServicesMedecin servicesMedecin;
    ServicesMedicament servicesMedicament;
    ServicesPrescription servicesPrescription;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        // A vous de jouer
        servicesConsultation = new ServicesConsultation();
        servicesPatient = new ServicesPatient();
        servicesMedecin = new ServicesMedecin();
        servicesMedicament = new ServicesMedicament();
        try {
            txtNumeroConsultation.setText(servicesConsultation.GetDerniereConsultation());
            cboPatients.setItems(servicesPatient.GetLesPatients());
            cboPatients.getSelectionModel().selectFirst();
            cboMedecins.setItems(servicesMedecin.GetlesMedecins());
            cboMedecins.getSelectionModel().selectFirst();
            tcNumeroMedicament.setCellValueFactory(new PropertyValueFactory<Medicament, Integer>("numero"));
            tcNomMedicament.setCellValueFactory(new PropertyValueFactory<Medicament, String>("nom"));
            tcPrixMedicament.setCellValueFactory(new PropertyValueFactory<Medicament, Double>("prix"));



        // Ne pas modifier ce code
        tcQuantiteMedicament.setCellFactory(tc -> new TextFieldTableCell<>(new IntegerStringConverter()));
        tcQuantiteMedicament.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Medicament, Integer>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<Medicament, Integer> medicamentIntegerCellEditEvent) {
                tvMedicamentsPrescrits.getItems().get(medicamentIntegerCellEditEvent.getTablePosition().getRow()).setQuantite(medicamentIntegerCellEditEvent.getNewValue());
            }
        });
        tvMedicamentsPrescrits.setEditable(true);
        tvMedicamentsPrescrits.setItems(servicesMedicament.GetLesMedicaments());

        // A vous de jouer

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @javafx.fxml.FXML
    public void btnInsererPrescriptionClicked(Event event) throws SQLException
    {
        // A vous de jouer
        if(dpDateConsultation.getValue()==null){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur de saisie de Date");
            alert.setContentText("Veuillez selectionner une date !");
            alert.setHeaderText("");
            alert.showAndWait();
        } else if(tvMedicamentsPrescrits.getSelectionModel().getSelectedItem() == null){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur de selection");
            alert.setContentText("Veuillez selectionner une activité !");
            alert.setHeaderText("");
            alert.showAndWait();
        } else {
            // Ne pas modifier ce code :
            // Il sert à récupérer la date au bon format
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            String dateConsult = dtf.format(dpDateConsultation.getValue());

            // A vous de jouer
            ObservableList<Medicament> lesMedics = tvMedicamentsPrescrits.getItems();
            for (Medicament unMedicament:lesMedics) {
                servicesPrescription.insertConsultation(txtNumeroConsultation.getId(),dpDateConsultation.getValue(),cboPatients.getSelectionModel().getSelectedItem().toString(),cboMedecins.getSelectionModel().getSelectedItem().toString());

            }
        }
    }
}
