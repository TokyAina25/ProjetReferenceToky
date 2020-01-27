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
public class Teammembre extends BaseModele{
    private int idutilisateur;
    private int idprojet;
    private int profil;
    private int idleader;

    public int getIdutilisateur() {
        return idutilisateur;
    }

    public void setIdutilisateur(int idutilisateur) {
        this.idutilisateur = idutilisateur;
    }

    public int getIdprojet() {
        return idprojet;
    }

    public void setIdprojet(int idprojet) {
        this.idprojet = idprojet;
    }

    public int getIdleader() {
        return idleader;
    }

    public void setIdleader(int idleader) {
        this.idleader = idleader;
    }

    public Teammembre(int idutilisateur, int idprojet, int profil, int idleader, int id) {
        super(id);
        this.idutilisateur = idutilisateur;
        this.idprojet = idprojet;
        this.profil = profil;
        this.idleader = idleader;
    }

    public Teammembre(int idutilisateur, int idprojet, int profil, int idleader) {
        this.idutilisateur = idutilisateur;
        this.idprojet = idprojet;
        this.profil = profil;
        this.idleader = idleader;
    }

    
    public Teammembre() {
    }

    public int getProfil() {
        return profil;
    }

    public void setProfil(int profil) {
        this.profil = profil;
    }
}
