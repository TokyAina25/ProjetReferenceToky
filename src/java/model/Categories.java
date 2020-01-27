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
public class Categories extends BaseModele{
    private String sujet; 

    public String getSujet() {
        return sujet;
    }

    public void setSujet(String sujet) {
        this.sujet = sujet;
    }

    public Categories(String sujet, int id) {
        super(id);
        this.sujet = sujet;
    }

    public Categories(String sujet) {
        this.sujet = sujet;
    }

    public Categories() {
    }
    
    
}
