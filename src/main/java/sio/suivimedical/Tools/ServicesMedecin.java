package sio.suivimedical.Tools;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ServicesMedecin
{
    private Connection uneCnx;
    private PreparedStatement ps;
    private ResultSet rs;

    public ServicesMedecin()
    {
        uneCnx = ConnexionBDD.getCnx();
    }

    // A vous de jouer
    public ObservableList<String> GetlesMedecins() throws SQLException {
        ObservableList<String> lesMedecins = FXCollections.observableArrayList();
        ps = uneCnx.prepareStatement("SELECT medecin.nomMedecin FROM medecin");
        rs = ps.executeQuery();
        while(rs.next()){
            lesMedecins.add(rs.getString(1));
        }
        return lesMedecins;
    }

    public int getIdMededin(String nomMedecin) throws SQLException {
        int idMedecin = 0;
        ps = uneCnx.prepareStatement("SELECT medicament.idMedoc FROM medecin WHERE medecin.nomMedecin= ?");
        ps.setString(1, nomMedecin);
        rs = ps.executeQuery();
        rs.next();
        idMedecin = rs.getInt(1);
        return idMedecin;
    }
}
