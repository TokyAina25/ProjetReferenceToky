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
public class Teammembrevue extends BaseModele{
    private int projet;
    private int idutilisateur;
    private int nomutilisateur;

    public Teammembrevue(int projet, int idutilisateur, int nomutilisateur, int id) {
        super(id);
        this.projet = projet;
        this.idutilisateur = idutilisateur;
        this.nomutilisateur = nomutilisateur;
    }

    public Teammembrevue() {
    }

    public Teammembrevue(int projet, int idutilisateur, int nomutilisateur) {
        this.projet = projet;
        this.idutilisateur = idutilisateur;
        this.nomutilisateur = nomutilisateur;
    }

    public int getProjet() {
        return projet;
    }

    public void setProjet(int projet) {
        this.projet = projet;
    }

    public int getIdutilisateur() {
        return idutilisateur;
    }

    public void setIdutilisateur(int idutilisateur) {
        this.idutilisateur = idutilisateur;
    }

    public int getNomutilisateur() {
        return nomutilisateur;
    }

    public void setNomutilisateur(int nomutilisateur) {
        this.nomutilisateur = nomutilisateur;
    }
    
    
}
