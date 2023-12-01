package sio.suivimedical.Entities;

import javafx.beans.property.SimpleIntegerProperty;

public class Medicament
{
    private int numero;
    private String nom;
    private double prix;
    private int quantite;

    public Medicament(int numero, String nom, double prix, int quantite) {
        this.numero = numero;
        this.nom = nom;
        this.prix = prix;
        this.quantite = quantite;
    }
    public Medicament(int numero, String nom, double prix) {
        this.numero = numero;
        this.nom = nom;
        this.prix = prix;
        this.quantite = quantite;
    }

    public int getNumero() {
        return numero;
    }

    public String getNom() {
        return nom;
    }

    public double getPrix() {
        return prix;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }
}
