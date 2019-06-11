/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

/**
 *
 * @author Famille Francois
 * @author cfb91
 */
import controleur.*;
import java.util.Date;

public class Semester {
    private AnneeScolaire annee;
    private int id;
    private int numero;
    private Date date_debut;
    private Date date_fin;
    
    public Semester(){
        this.numero = 1;
        this.date_debut = null;
        this.date_fin = null;
        this.annee = new AnneeScolaire();
    }
    public Semester(int number,Date debut,Date fin, AnneeScolaire year) 
            throws InvalidParameterException, ImpossibleDateException
    {
        if( number >= 1 && number <= 3)
        {
            this.numero = number;
        }
        else
        {
            throw new InvalidParameterException();
        }
        
        if(fin.after(debut)){
            this.date_debut = debut;
            this.date_fin = fin;
        }else{
            throw new ImpossibleDateException();
        } 
        
        this.annee = year;
    }
    
    //get && set
    public Date getdebut(){
        return this.date_debut;
    }
    
    public void setdebut(Date debut) throws ImpossibleDateException{
        if(date_fin.after(debut))
        {
            throw new ImpossibleDateException();
        }
        else
        {
            this.date_debut = debut;
        }
        
    }
    
    public Date getfin(){
        return this.date_fin;
    }
    
    public void setfin(Date fin) throws ImpossibleDateException{
        if(date_debut.after(fin))
        {
            throw new ImpossibleDateException();
        }
        else
        {
            this.date_fin = fin;
        }
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public int getNumero() {
        return this.numero;
    }

    public void setNumero(int number) throws InvalidParameterException {
    if( number >= 1 && number <= 3)
        {
            this.numero = number;
        }
        else
        {
            throw new InvalidParameterException();
        }
    }
    
    public void AfficherInfos(){
        System.out.println("Année Scolaire : " + this.annee.getAnnee());
        System.out.println("\n " + "numéro du semestre: " + this.numero);
        System.out.println("\n " + "Le semestre commence le: " + this.date_debut.toString());
        System.out.println("\n " + "Le semestre se termine le: " + this.date_fin.toString());
    }
   
}
