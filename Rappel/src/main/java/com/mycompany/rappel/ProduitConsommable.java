/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.rappel;

/**
 *
 * @author ihab
 */
public class ProduitConsommable extends Produit {
    private String dateExpiration;
    
    public ProduitConsommable(int id, String nom, double prix, String dateExpiration) throws PrixNegatifException, NomInvalideException {
        super(id, nom, prix);
        this.dateExpiration = dateExpiration;
    }
    
    @Override
    public void afficher() {
        super.afficher();
        System.out.println("Date d'expiration: " + dateExpiration);
    }
}
