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
public class Projets extends BaseModele{
    private String description;
    private int idmanager;
    private Date datedebut;
    private Date dateFin;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getIdmanager() {
        return idmanager;
    }

    public void setIdmanager(int idmanager) {
        this.idmanager = idmanager;
    }
    
    public Date getDatedebut() {
        return datedebut;
    }

    public void setDatedebut(Date datedebut) {
        this.datedebut = datedebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public Projets() {
    }

    public Projets(String description, int idmanager, Date datedebut, Date dateFin, int id) {
        super(id);
        this.description = description;
        this.idmanager = idmanager;
        this.datedebut = datedebut;
        this.dateFin = dateFin;
    }

    public Projets(String description, int idmanager, Date datedebut, Date dateFin) {
        this.description = description;
        this.idmanager = idmanager;
        this.datedebut = datedebut;
        this.dateFin = dateFin;
    }    
}
