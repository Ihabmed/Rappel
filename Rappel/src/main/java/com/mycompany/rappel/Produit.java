/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.rappel;

/**
 *
 * @author ihab
 */
public class Produit extends ProduitGenerique {

    public Produit(int id, String nom, double prix) throws PrixNegatifException, NomInvalideException {
        super(id, nom, prix);
    }
    
    @Override
    public double calculePrixAvecTaxe() {
        return super.getPrix() - super.getPrix() * 0.35;
    }
}
