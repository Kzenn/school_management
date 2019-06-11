/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.util.Calendar;

/**
 *
 * @author Famille Francois
 */
public class AnneeScolaire {
    private int annee;
    
    public AnneeScolaire(){
        this.annee = Calendar.getInstance().get(Calendar.YEAR);
    }
    
    public AnneeScolaire(int year){
        this.annee = year;
    }
    
    //set && get
    public void setAnnee(int year){
        this.annee = year;
    }
    
    public int getAnnee(){
        return this.annee;
    }
}
