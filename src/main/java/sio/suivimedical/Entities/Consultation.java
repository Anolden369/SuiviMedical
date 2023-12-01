package sio.suivimedical.Entities;

public class Consultation
{
    private int numero;
    private String date;
    private String nomPatient;
    private String nomMedecin;
    private double montant;

    public Consultation(int numero, String date, String nomPatient, String nomMedecin, double montant) {
        this.numero = numero;
        this.date = date;
        this.nomPatient = nomPatient;
        this.nomMedecin = nomMedecin;
        this.montant = montant;
    }

    public int getNumero() {
        return numero;
    }

    public String getDate() {
        return date;
    }

    public String getNomPatient() {
        return nomPatient;
    }

    public String getNomMedecin() {
        return nomMedecin;
    }

    public double getMontant() {
        return montant;
    }
}
