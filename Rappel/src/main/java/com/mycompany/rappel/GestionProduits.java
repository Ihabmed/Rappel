/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.rappel;

import static com.mycompany.rappel.Rappel.produits;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author ihab
 */
public class GestionProduits {
    /*private List<Produit> produits = new ArrayList<>();*/
    
    public void ajouterProduit(Produit produit) {
        produits.add(produit);
    }

    public void supprimerProduit(int id) {
        produits.removeIf(p -> p.getId() == id);
    }
    
    public List<Produit> filtrerProduitsParPrix(double seuil) {
        return produits.stream().filter(p -> p.getPrix() > seuil).collect(Collectors.toList());
    }
    
    public List<Produit> getProduits() {
        return produits;
    }
}
