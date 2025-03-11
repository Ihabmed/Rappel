/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.rappel;

/**
 *
 * @author ihab
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Rappel {
    public static List<Produit> produits = new ArrayList<>();

    
    public static void main(String[] args) throws PrixNegatifException, NomInvalideException, IOException {
        Scanner scan = new Scanner(System.in);
        int reponse = 0;
        GestionProduits gestionProduits = new GestionProduits();
        int id;
        String nom; 
        double prix;
        SauvegardeThread sauvegardeThread;
        
        while (reponse != 7) {
            System.out.println("Bienvenue sur le gestionnaire de stock : ");
            System.out.println("1- Afficher les produits");
            System.out.println("2- Ajouter un produit");
            System.out.println("3- Supprimer un produit");
            System.out.println("4- Sauvegarde les produits");
            System.out.println("5- Charger les produits");
            System.out.println("6- Trier les produits");
            System.out.println("7- Quitter");
            System.out.println("Entrez votre choix: ");
            reponse = scan.nextInt();
            
            switch (reponse) {

                case 1 -> {
                    for (Produit p: produits) {
                        p.afficher();
                    }
                }
                case 2 -> {
                    System.out.println("remplir les information de produit : ");
                    System.out.print("Id : ");
                    id = scan.nextInt();
                    System.out.print("nom : ");
                    nom = scan.next();
                    System.out.print("prix : ");
                    prix = scan.nextDouble();
                    try {
                        gestionProduits.ajouterProduit(new Produit(id, nom, prix));
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                }
                case 3 -> {
                    System.out.println("saisir l'id de produit pour le supprimer : ");
                    id = scan.nextInt();
                    gestionProduits.supprimerProduit(id);
                }
                case 4 -> { 
                    sauvegardeThread = new SauvegardeThread();
                    sauvegardeThread.start();
                }
                case 5 -> {
                    produits.clear();
                    try {
                        BufferedReader reader = new BufferedReader(new FileReader("Produits.txt"));
                        String line = new String();
                        String[] arr;
                        produits.clear();

                        while (line != null)
                        {
                            line = reader.readLine();
                            if (line != null) {
                                arr = line.split("[,]");
                                id = Integer.parseInt(arr[0]);
                                nom = arr[1];
                                prix = Double.parseDouble(arr[2]);
                                
                                produits.add(new Produit(id, nom, prix));
                            }
                        }
                        reader.close();
                    } catch (IOException e) {
                        System.out.println("Erreur d'écriture dans le fichier");
                    }
                }
                case 6 -> Collections.sort(produits, Comparator.comparingDouble(Produit::getPrix));
                case 7 -> {
                    break;
                }
                default -> System.out.println("choix errone, rechoisir : ");
            }
        }
    }
}
