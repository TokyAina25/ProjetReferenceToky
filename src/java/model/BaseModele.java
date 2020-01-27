/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;


/**
 *
 * @author Hanta
 */
public abstract class BaseModele {
    
    private int id;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public BaseModele(int id) {        
        super();
        this.id = id;
    }
    
    public BaseModele(){
    }
}

