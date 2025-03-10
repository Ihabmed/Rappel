/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.rappel;

/**
 *
 * @author ihab
 */
abstract class ProduitGenerique implements Affichable{
    int id;
    String nom;
    double prix;

    public ProduitGenerique(int id, String nom, double prix) throws PrixNegatifException, NomInvalideException {
        if (prix >= 0) {
            this.prix = prix;
        }
        else {
            throw new PrixNegatifException("prix est negatif");
        }
        if (nom.matches("[a-zA-Z ]+")) {
            this.nom = nom;
        } else {
            throw new NomInvalideException("nom est invalide");
        }
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }
    
    public abstract double calculePrixAvecTaxe();
    
    @Override
    public void afficher() {
        System.out.println("ID: " + id + ", Nom: " + nom + ", Prix: " + prix);
    }
}
