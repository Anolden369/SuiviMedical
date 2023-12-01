package sio.suivimedical.Tools;

import javafx.scene.control.DatePicker;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Locale;

public class ServicesPrescription
{
    private Connection uneCnx;
    private PreparedStatement ps;
    private ResultSet rs;

    ServicesPatient servicesPatient = new ServicesPatient();
    ServicesMedecin servicesMedecin = new ServicesMedecin();
    public ServicesPrescription()
    {
        uneCnx = ConnexionBDD.getCnx();
    }

    // A vous de jouer
    public void insertConsultation(String idConsultation, LocalDate dateConsultation, String nomPatient, String nomMedecin) throws SQLException {

        ps = uneCnx.prepareStatement("INSERT INTO `consultation` (`idConsult`, `dateConsult`, `numPatient`, `numMedecin`) VALUES ('?', '?', '?', '?');");
        ps.setInt(1, Integer.parseInt(idConsultation));
        ps.setDate(2,Date.valueOf(dateConsultation));
        ps.setInt(3,servicesPatient.getIdPatient(nomPatient));
        ps.setInt(3,servicesMedecin.getIdMededin(nomMedecin));
        ps.executeUpdate();

    }

    public void insertPrescription(String idConsultation, LocalDate dateConsultation, String nomPatient, String nomMedecin) throws SQLException {

        ps = uneCnx.prepareStatement("INSERT INTO `consultation` (`idConsult`, `dateConsult`, `numPatient`, `numMedecin`) VALUES ('?', '?', '?', '?');");
        ps.setInt(1, Integer.parseInt(idConsultation));
        ps.setDate(2,Date.valueOf(dateConsultation));
        ps.setInt(3,servicesPatient.getIdPatient(nomPatient));
        ps.setInt(3,servicesMedecin.getIdMededin(nomMedecin));
        ps.executeUpdate();

    }

}
