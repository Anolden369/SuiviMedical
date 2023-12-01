package sio.suivimedical.Tools;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sio.suivimedical.Entities.Consultation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ServicesPatient
{
    private Connection uneCnx;
    private PreparedStatement ps;
    private ResultSet rs;

    public ServicesPatient()
    {
        uneCnx = ConnexionBDD.getCnx();
    }

    // A vous de jouer
    public ObservableList<String> GetLesPatients() throws SQLException {
        ObservableList<String> lesPatients = FXCollections.observableArrayList();
        ps = uneCnx.prepareStatement("SELECT patient.nomPatient FROM patient");
        rs = ps.executeQuery();
        while(rs.next()){
            lesPatients.add(rs.getString(1));
        }
        return lesPatients;
    }

    public int getIdPatient(String nomPatient) throws SQLException {
        int idPatient = 0;
        ps = uneCnx.prepareStatement("SELECT patient.idPatient FROM patient WHERE patient.nomPatient= ?");
        ps.setString(1, nomPatient);
        rs = ps.executeQuery();
        rs.next();
        idPatient = rs.getInt(1);
        return idPatient;
    }

}
