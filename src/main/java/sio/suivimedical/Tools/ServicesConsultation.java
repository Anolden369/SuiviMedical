package sio.suivimedical.Tools;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sio.suivimedical.Entities.Consultation;


import java.sql.*;

public class ServicesConsultation
{
    private Connection uneCnx;
    private PreparedStatement ps;
    private ResultSet rs;

    public ServicesConsultation()
    {
        uneCnx = ConnexionBDD.getCnx();
    }

    // A vous de jouer
    public ObservableList<Consultation> GetAlllesConsultations() throws SQLException{

        ObservableList<Consultation> lesConsultations = FXCollections.observableArrayList();

        ps = uneCnx.prepareStatement("SELECT consultation.idConsult, consultation.dateConsult, patient.nomPatient, medecin.nomMedecin\n" +
                "FROM consultation\n" +
                "INNER JOIN patient ON consultation.numPatient=patient.idPatient\n" +
                "INNER JOIN medecin ON consultation.numMedecin=medecin.idMedecin  \n" +
                "ORDER BY `consultation`.`idConsult` ASC");
        rs = ps.executeQuery();
        while(rs.next()){
            Consultation uneDemande = new Consultation(
                    rs.getInt(1),
                    rs.getDate(2).toString(),
                    rs.getString(3),
                    rs.getString(4),
                    0);
            lesConsultations.add(uneDemande);
        }
        return lesConsultations;
    }

    public String GetDerniereConsultation() throws SQLException {
        ps = uneCnx.prepareStatement("SELECT MAX(consultation.idConsult)+1 FROM consultation");
        rs = ps.executeQuery();
        rs.next();
        String idConsultation = String.valueOf(rs.getInt(1));
        return idConsultation;
    }

}
