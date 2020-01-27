/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author OTME
 */
public class Developpeur extends BaseModele{
    
    private String nomutilisateur;
    private String email;

    public String getNomutilisateur() {
        return nomutilisateur;
    }

    public void setNomutilisateur(String nomutilisateur) {
        this.nomutilisateur = nomutilisateur;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Developpeur(String nomutilisateur, String email, int id) {
        super(id);
        this.nomutilisateur = nomutilisateur;
        this.email = email;
    }

    public Developpeur(String nomutilisateur, String email) {
        this.nomutilisateur = nomutilisateur;
        this.email = email;
    }

    public Developpeur() {
    }
    
}
