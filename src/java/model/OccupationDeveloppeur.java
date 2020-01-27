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
public class OccupationDeveloppeur {
    private int projet;
    private int developpeur;
    private double taux;

    public int getProjet() {
        return projet;
    }

    public void setProjet(int projet) {
        this.projet = projet;
    }

    public int getDeveloppeur() {
        return developpeur;
    }

    public void setDeveloppeur(int developpeur) {
        this.developpeur = developpeur;
    }

    public double getTaux() {
        return taux;
    }

    public void setTaux(double taux) {
        this.taux = taux;
    }

    public OccupationDeveloppeur(int projet, int developpeur, double taux) {
        this.projet = projet;
        this.developpeur = developpeur;
        this.taux = taux;
    }

    public OccupationDeveloppeur() {
    }
    
}
