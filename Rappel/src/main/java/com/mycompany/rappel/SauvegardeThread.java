/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.rappel;

import static com.mycompany.rappel.Rappel.produits;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author ihab
 */
public class SauvegardeThread extends Thread{
    
    @Override
    public void run() {
        try {
            System.out.println("Sauvegarde en cour...");
            try {
                BufferedWriter writer = new BufferedWriter(new FileWriter("Produits.txt"));
                if (produits.isEmpty()) {
                    writer.write("");
                } else
                {
                    for (Produit p : produits) {
                        writer.write(p.getId() + "," + p.getNom() + "," + p.getPrix() + "\n");
                    }
                }
                writer.close();
            } catch (IOException e) {
                System.out.println("Erreur d'écriture dans le fichier");
            }
            Thread.sleep(2000);
            System.out.println("Produits sauvegardés : ");
            produits.forEach(Produit::afficher);
        } catch (InterruptedException e) {
            System.out.print("Erreur pendant la sauvegarde" + e.getMessage());
        }
    }
}
