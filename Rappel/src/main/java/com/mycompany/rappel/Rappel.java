/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.rappel;

/**
 *
 * @author ihab
 */

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Rappel {

    public static void main(String[] args) {
        List<Produit> produits = new ArrayList<>();
        try {
            produits.add(new Produit(1, "Laptop", 55000.0));
            produits.add(new Produit(2, "Smartphone", 30000.0));
            produits.add(new ProduitConsommable(3, "Cartouche", 200.0, "2025-05-01"));
        } catch (PrixNegatifException e) {
            System.out.println(e);
        }

        
        Collections.sort(produits, Comparator.comparingDouble(Produit::getPrix));
        
        /*try {
            produits.add(new Produit(4, "Tablette", -500.0));
        } catch (PrixNegatifException e) {
            System.out.println(e);
        }*/
        
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("Produits.txt"));
            for (Produit p : produits) {
                writer.write(p.getId() + "," + p.getNom() + "," + p.getPrix() + "\n");
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("Erreur d'écriture dans le fichier");
        }
    }
}
