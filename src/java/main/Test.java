/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import connection.connectDB;
import dao.AutresFonction;
import dao.Generaliser;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import model.BaseModele;
import model.Utilisateurs;

/**
 *
 * @author OTME
 */
public class Test {
     public static String getMd5(String input) 
    { 
        try { 
  
            // Static getInstance method is called with hashing MD5 
            MessageDigest md = MessageDigest.getInstance("MD5"); 
  
            // digest() method is called to calculate message digest 
            //  of an input digest() return array of byte 
            byte[] messageDigest = md.digest(input.getBytes()); 
  
            // Convert byte array into signum representation 
            BigInteger no = new BigInteger(1, messageDigest); 
  
            // Convert message digest into hex value 
            String hashtext = no.toString(16); 
            while (hashtext.length() < 32) { 
                hashtext = "0" + hashtext; 
            } 
            return hashtext; 
        }  
  
        // For specifying wrong message digest algorithms 
        catch (NoSuchAlgorithmException e) { 
            throw new RuntimeException(e); 
        } 
    } 
    public static void main(String[] args) throws Exception{
              
        Generaliser general = new Generaliser();
        List<BaseModele> restaurants = new ArrayList<>();
        List<BaseModele> listes = new ArrayList<>();
        LocalDate localDate = LocalDate.now();
        Utilisateurs utilisateur = null;
        AutresFonction autres = null;
        //Utilisateur user = new Utilisateurs("joojojojoo","jonatana@outlook.com","jonatana");
        try{
             Connection connection = connectDB.getCon();
             autres = new AutresFonction();
             //restaurants = general.find(new Restaurants(), "1=1", 10, 1);
             String user="toky";
             String mdp="toky25";
             //listes = general.find(new Plats(), "restaurant="+1, 8 , 0);
            // listes = general.find(new Utilisateurs(), "nom='"+user+"' and mdp='"+mdp+"'", 1, 0);
             //general.save(new Detailscommande(1, new Date(System.currentTimeMillis()), 1));
             //List<BaseModele> detailcommande = general.find(new Detailscommande(), "utilisateur="+1+" order by id desc", 1, 0);
            // System.out.println("idmax "+detailcommande.get(0).getId());
             //List<BaseModele> detailcommande = general.find(new Detailscommande(), "utilisateur="+1+" order by id desc", 1, 0);
             //int idCommande = detailcommande.get(0).getId();
             //System.out.println("idCommande "+idCommande);
             /*Plats plat1 =(Plats) general.find(new Plats(), "id=1", 1, 0).get(0);
             Plats plat2 =(Plats) general.find(new Plats(), "id=2", 1, 0).get(0);
             Plats plat3 =(Plats) general.find(new Plats(), "id=3", 1, 0).get(0);
             Commandes commandes = new Commandes();
             List<Commande> commande = new ArrayList<>();
             commande.add(new Commande(plat1,4,(plat1.getPrix()*4)));
             commande.add(new Commande(plat2,4,(plat2.getPrix()*4)));
             commande.add(new Commande(plat3,4,(plat3.getPrix()*4)));
             commandes.setCommande(commande);
             commandes.setRemise(0);
             commandes.setTotal(18000);
             Utilisateurs util = new Utilisateurs(1);*/
             //autres.TransactionCommandeClient(commandes, util);
             //List<BaseModele> detailcommande = general.find(new Detailscommande(), "utilisateur="+1+" order by id desc", 1, 0);
             //int detail = autres.getLastIdDetailsCommande(util);
             //System.out.println("test last "+detail);
             /*NumberFormat formatter = null;
             formatter=java.text.NumberFormat.getInstance(java.util.Locale.FRENCH); 

             //POUR AJOUTER LES SEPARATEUR ENTRE LES MILIERS
             formatter = new DecimalFormat("##,###.## ");
             System.out.println("test "+formatter.format(100005258.25));
              System.out.println("Your HashCode Generated by MD5 is: " + getMd5("toky")); */
             int iduser = 5;
             listes = general.find(new Utilisateurs(), "nomutilisateur='"+user+"' and mdp='"+mdp+"'", 1, 0);
             System.out.println(listes.get(0).getId());
             listes = general.find(new Utilisateurs(), "id="+iduser, 0, 1);
             general.delete((Utilisateurs) listes.get(0));
        }catch(Exception ex){
            throw ex;
        }
     }
}
