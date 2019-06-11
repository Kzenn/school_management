/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.util.Calendar;

/**
 * Classe modèle qui correspond à l'année scolaire
 * 
 * @author Famille Francois
 */
public class AnneeScolaire {
    /*
     * Les attributs : id et année
     */
    private int id = 0;
    private int annee = 0;
    
    /**
     * Constructeur par defaut
     */
    public AnneeScolaire(){
        this(0, Calendar.getInstance().get(Calendar.YEAR));
    }
    
    /**
     * Constructeur par id et l'année
     * <br> Si l'année = 2018 donc l'année scolaire : 2018/2019
     * @param id : identifiant de l'année scolaire
     * @param annee : année scolaire 
     */
    public AnneeScolaire(int id, int annee){
        this.id = id;
        this.annee = annee;
    }

    /**
     * Obtenir l'identifiant de l'année scolaire
     * @return 
     */
    public int getId() {
        return id;
    }

    /**
     * Modifier l'identifiant de l'année scolaire
     * @param id 
     */
    public void setId(int id) {
        this.id = id;
    }
    
    /**
     * Obtenir l'année (inférieur) de l'année scolaire
     * @return 
     */
    public int getAnnee(){
        return this.annee;
    }
    
    /**
     * Modifier l'année (inférieure) de l'année soclaire
     * @param annee : année inférieur
     */
    public void setAnnee(int annee){
        this.annee = annee;
    }
    
    @Override
    public String toString() {
        String strEcole = "";
        
        strEcole+=this.getAnnee()+" / "+(this.getAnnee()+1)+"<br>";
        strEcole+="<hr>" ;
        
        strEcole = "<html>" + strEcole + "</html>";
        
        return strEcole;
    }
}
