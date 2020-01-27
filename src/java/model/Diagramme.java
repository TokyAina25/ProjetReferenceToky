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
public class Diagramme extends BaseModele{
    private Date datedebut;
    private Date datefin;
    private double taux;
    private int idprojet;

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

    public double getTaux() {
        return taux;
    }

    public void setTaux(double taux) {
        this.taux = taux;
    }

    public int getIdprojet() {
        return idprojet;
    }

    public void setIdprojet(int idprojet) {
        this.idprojet = idprojet;
    }

    public Diagramme(Date datedebut, Date datefin, double taux, int idprojet, int id) {
        super(id);
        this.datedebut = datedebut;
        this.datefin = datefin;
        this.taux = taux;
        this.idprojet = idprojet;
    }

    public Diagramme(Date datedebut, Date datefin, double taux, int idprojet) {
        this.datedebut = datedebut;
        this.datefin = datefin;
        this.taux = taux;
        this.idprojet = idprojet;
    }

    public Diagramme() {
    }

}
