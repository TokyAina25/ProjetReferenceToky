/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;

/**
 *
 * @author OTME
 */
public class Taches extends BaseModele{
    private String description;
    private int estimation;
    private int tempspasse;
    private int restefaire;
    private int developpeur;
    private int idcategorie;
    private int idprojet;
    private int etat;
    private Date datedebut;
    private Date datefin;
    
    public int getEtat() {
        return etat;
    }

    public void setEtat(int etat) {
        this.etat = etat;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getEstimation() {
        return estimation;
    }

    public void setEstimation(int estimation) {
        this.estimation = estimation;
    }

    public int getTempspasse() {
        return tempspasse;
    }

    public void setTempspasse(int tempspasse) {
        this.tempspasse = tempspasse;
    }

    public int getRestefaire() {
        return restefaire;
    }

    public void setRestefaire(int restefaire) {
        this.restefaire = restefaire;
    }

    public int getDeveloppeur() {
        return developpeur;
    }

    public void setDeveloppeur(int developpeur) {
        this.developpeur = developpeur;
    }

    public int getIdcategorie() {
        return idcategorie;
    }

    public void setIdcategorie(int idcategorie) {
        this.idcategorie = idcategorie;
    }

    public int getIdprojet() {
        return idprojet;
    }

    public void setIdprojet(int idprojet) {
        this.idprojet = idprojet;
    }

    public Date getDatedebut() {
        return datedebut;
    }

    public void setDatedebut(Date datedebut) {
        this.datedebut = datedebut;
    }

    public Date getDatefin() {
        return datefin;
    }

    public void setDatefin(Date datefin) {
        this.datefin = datefin;
    }
    
    

    public Taches() {
    }

    public Taches(String description, int estimation, int tempspasse, int restefaire, int developpeur, int idcategorie, int idprojet, int etat, Date datedebut, Date datefin, int id) {
        super(id);
        this.description = description;
        this.estimation = estimation;
        this.tempspasse = tempspasse;
        this.restefaire = restefaire;
        this.developpeur = developpeur;
        this.idcategorie = idcategorie;
        this.idprojet = idprojet;
        this.etat = etat;
        this.datedebut = datedebut;
        this.datefin = datefin;
    }

    public Taches(String description, int estimation, int tempspasse, int restefaire, int developpeur, int idcategorie, int idprojet, int etat, Date datedebut, Date datefin) {
        this.description = description;
        this.estimation = estimation;
        this.tempspasse = tempspasse;
        this.restefaire = restefaire;
        this.developpeur = developpeur;
        this.idcategorie = idcategorie;
        this.idprojet = idprojet;
        this.etat = etat;
        this.datedebut = datedebut;
        this.datefin = datefin;
    }
    
    
    
    
}
