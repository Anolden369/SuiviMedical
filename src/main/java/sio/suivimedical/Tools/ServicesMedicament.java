package sio.suivimedical.Tools;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sio.suivimedical.Entities.Consultation;
import sio.suivimedical.Entities.Medicament;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ServicesMedicament
{
    private Connection uneCnx;
    private PreparedStatement ps;
    private ResultSet rs;

    public ServicesMedicament()
    {
        uneCnx = ConnexionBDD.getCnx();
    }

    // A vous de jouer
    public ObservableList<Medicament> GetListeMedicPrescrit(int idConsultationSelectionne) throws SQLException{

        ObservableList<Medicament> lesMedicaments = FXCollections.observableArrayList();

        ps = uneCnx.prepareStatement("SELECT medicament.idMedoc, medicament.nomMedoc, medicament.prixMedoc\n" +
                "FROM prescrire\n" +
                "INNER JOIN medicament ON prescrire.numMedoc=medicament.idMedoc\n" +
                "INNER JOIN consultation ON prescrire.numConsult=consultation.idConsult\n" +
                "WHERE consultation.idConsult=?");
        ps.setInt(1,idConsultationSelectionne);
        rs = ps.executeQuery();
        while(rs.next()){
            Medicament unMedicament = new Medicament(rs.getInt(1),rs.getString(2),rs.getDouble(3));
            lesMedicaments.add(unMedicament);
        }
        return lesMedicaments;
    }

    public ObservableList<Medicament> GetLesMedicaments() throws SQLException{

        ObservableList<Medicament> lesMedicaments = FXCollections.observableArrayList();

        ps = uneCnx.prepareStatement("SELECT medicament.idMedoc, medicament.nomMedoc, medicament.prixMedoc FROM medicament");
        rs = ps.executeQuery();
        while(rs.next()){
            Medicament unMedicament = new Medicament(rs.getInt(1),rs.getString(2),rs.getDouble(3), 0);
            lesMedicaments.add(unMedicament);
        }
        return lesMedicaments;
    }

}
