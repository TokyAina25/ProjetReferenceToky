/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import connection.connectDB;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import model.BaseModele;
import model.OccupationDeveloppeur;
import model.Utilisateurs;

/**
 *
 * @author OTME
 */
public class AutresFonction {
    private Generaliser general;
    private AutresFonction fonction;
    
    /*public List<Plats> supprimerElement(List<Plats> listes, Plats objet) throws Exception{
        List<Plats> reponse = new ArrayList<>();
        try {
            for(int i = 0 ; i<listes.size() ; i++){
                if(listes.get(i).getId()!=objet.getId()){
                    reponse.add(listes.get(i));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return reponse;
    }
    public Commandes construireCommande(HttpServletRequest hsr, List<Plats> listes) throws Exception{
        
          List<Commande> commandes = new ArrayList<>();
          Utilisateurs user = null; 
          Commandes commandeclient = new Commandes();
          Plats plat = null;
          double montant = 0;
          double total = 0;
          general = new Generaliser();
          fonction = new AutresFonction();
        try {
            String[] tabQuantite = new String[listes.size()];
            String quantite = hsr.getParameter("quantite"+1);
            for(int i = 0;i<listes.size();i++){
                   tabQuantite[i] = hsr.getParameter("quantite"+i);
                   System.out.println(tabQuantite[i]);
                   montant=Double.parseDouble(tabQuantite[i])*listes.get(i).getPrix();
                   total+=montant;
                   commandes.add(new Commande(listes.get(i),Integer.parseInt(tabQuantite[i]),montant));
               }
               commandeclient.setCommande(commandes);
               commandeclient.setTotal(total);
               commandeclient.setRemise(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return commandeclient;
    }
    public int getLastIdDetailsCommande(Utilisateurs user) throws Exception{
        int reponse = 0;
        general = new Generaliser();
        try {
            List<BaseModele> detailcommande = general.find(new Detailscommande(), "utilisateur="+1+" order by id desc", 1, 0);
            reponse = detailcommande.get(0).getId();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return reponse;
    }
    public int TransactionCommandeClient(Commandes commande, Utilisateurs user) throws Exception{
        int reponse = 0;
        List<Commande> commandepret = null;
        Connection connect=null;
        int idCommande = 0;
        try {
            general = new Generaliser();
            System.out.println("Début de la transaction");
            connect = connectDB.getCon();
            connect.setAutoCommit(false);
            commandepret = commande.getCommande();
            List<BaseModele> detailcommande = general.find(connect, new Detailscommande(), "utilisateur="+user.getId()+" order by id desc", 1, 0);
            idCommande = detailcommande.get(0).getId();
            for(Commande liste : commandepret){
                System.out.println("quantite "+liste.getQuantite());
                general.save(connect, new Platscommande(idCommande,liste.getPlats().getId(),liste.getQuantite()));
            }
            System.out.println("Fin de la transaction");
            connect.commit();
            reponse = 1;
        } catch (Exception e) {
            if(connect!=null)
                connect.rollback();
            e.printStackTrace();
            throw e;
        }finally{
            if(connect!=null){
                connect.close();
            }
        }
        return reponse;
    }*/
    
    public String getMd5(String input) 
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
    
    public List<OccupationDeveloppeur> findAllAffichesProduits(int idprojet) throws Exception{
        
        Connection connection = null;
        PreparedStatement state = null;
        ResultSet rs = null;
        String query = "";
        List<OccupationDeveloppeur> list = new ArrayList<>();
        try {
            connection = connectDB.getCon();
            query = "select developpeur,sum(tempspasse)/sum(estimation) as tempspasse from taches where idprojet="+idprojet+" group by developpeur ";
            System.out.println(query);
            state = connection.prepareStatement(query);
            rs = state.executeQuery();
            int i = 0;
            OccupationDeveloppeur prod;
            while (rs.next()) { 
                prod = new OccupationDeveloppeur();
                prod.setProjet(idprojet);
                prod.setDeveloppeur(Integer.parseInt(rs.getString(1)));
                prod.setTaux(Double.parseDouble(rs.getString(2)));
                list.add(prod);
                i++;
            }
            
        } catch (SQLException e) {
            throw e;
        } finally {
            if (rs != null) 
                rs.close();                
            if(state !=null)
                state.close();
            if(connection != null)
                connection.close();
        }
        return list;
    }
    
    public List<OccupationDeveloppeur> findAllAffichesProduits(int idprojet,Date date1,Date date2) throws Exception{
        
        Connection connection = null;
        PreparedStatement state = null;
        ResultSet rs = null;
        String query = "";
        List<OccupationDeveloppeur> list = new ArrayList<>();
        try {
            connection = connectDB.getCon();
            query = "select developpeur,sum(tempspasse)/sum(estimation) as tempspasse from taches where idprojet="+idprojet+" where datedebut>="+date1+" and datefin<="+date2+" group by developpeur ";
            System.out.println(query);
            state = connection.prepareStatement(query);
            rs = state.executeQuery();
            int i = 0;
            OccupationDeveloppeur prod;
            while (rs.next()) { 
                prod = new OccupationDeveloppeur();
                prod.setProjet(idprojet);
                prod.setDeveloppeur(Integer.parseInt(rs.getString(1)));
                prod.setTaux(Double.parseDouble(rs.getString(2)));
                list.add(prod);
                i++;
            }
            
        } catch (SQLException e) {
            throw e;
        } finally {
            if (rs != null) 
                rs.close();                
            if(state !=null)
                state.close();
            if(connection != null)
                connection.close();
        }
        return list;
    }
    
}
