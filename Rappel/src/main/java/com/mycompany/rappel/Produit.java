/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.rappel;

/**
 *
 * @author ihab
 */
public class Produit {
    private int id;
    private String nom;
    private double prix;

    public Produit(int id, String nom, double prix) throws PrixNegatifException {
        if (prix >= 0) {
            this.prix = prix;
        }
        else {
            throw new PrixNegatifException("prix est negatif");
        }
        this.id = id;
        this.nom = nom;
    }
    
    public void afficher() {
        System.out.println("ID: " + id + ", Nom: " + nom + ", Prix: " + prix);
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
}
