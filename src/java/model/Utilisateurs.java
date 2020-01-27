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
public class Utilisateurs extends BaseModele{
    private String nomutilisateur;
    private String mdp;
    private String email;

    public String getNomutilisateur() {
        return nomutilisateur;
    }

    public void setNomutilisateur(String nomutilisateur) {
        this.nomutilisateur = nomutilisateur;
    }

    public Utilisateurs(String nomutilisateur, String mdp, String email, int id) {
        super(id);
        this.nomutilisateur = nomutilisateur;
        this.mdp = mdp;
        this.email = email;
    }

    public Utilisateurs(String nomutilisateur, String mdp, String email) {
        this.nomutilisateur = nomutilisateur;
        this.mdp = mdp;
        this.email = email;
    }

    public Utilisateurs(int id) {
        super(id);
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public Utilisateurs() {
    }
}
