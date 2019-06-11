/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.sql.Date;
import utils.DateUtils;

/**
 * Classe modèle qui correspond au trimestre
 * 
 * @author Famille Francois
 */
public class Trimestre {
    /*
     * Les attributs : id, numero, debut, fin et idAnneeScolaire
     */
    private int id = 0;
    private String numero = "";
    private Date debut = null;
    private Date fin = null;
    private int idAnneeScolaire;
    
    private AnneeScolaire anneeScolaire;
    
    /**
     * Constructeur par defaut
     */
    public Trimestre(){
    }
    
    /**
     * Constructeur par id et le trimestre
     * 
     * @param id : identifiant du trimestre
     * @param numero : numero du trimestre
     * @param debut : date de début du trimestre
     * @param fin : date de fin du trimestre
     * @param idAnneeScolaire : idenfiantifiant de l'année scolaire
     */
    public Trimestre(int id, String numero, Date debut, Date fin, int idAnneeScolaire){
        this.id = id;
        this.numero = numero;
        this.debut = debut;
        this.fin = fin;
        this.idAnneeScolaire = idAnneeScolaire;
    }

    /**
     * Obtenir l'identifiant du trimestre
     * @return 
     */
    public int getId() {
        return id;
    }

    /**
     * Modifier l'identifiant du trimestre
     * @param id 
     */
    public void setId(int id) {
        this.id = id;
    }
    
    /**
     * Obtenir le numero du trimestre
     * @return 
     */
    public String getNumero(){
        return this.numero;
    }
    
    /**
     * Modifier le numero du trimestre
     * @param numero 
     */
    public void setNumero(String numero){
        this.numero = numero;
    }

    /**
     * Obtenir de la date du début du trimestre
     * @return 
     */
    public Date getDebut() {
        return debut;
    }

    /**
     * Modifier la date de début du trimestre
     * @param debut 
     */
    public void setDebut(Date debut) {
        this.debut = debut;
    }

    /**
     * Obtenir la date fin du trimestre
     * @return : la date fin
     */
    public Date getFin() {
        return fin;
    }

    /**
     * Modifier la date fin du tirmestre
     * @param fin : la nouvelle date fin
     */
    public void setFin(Date fin) {
        this.fin = fin;
    }

    /**
     * Obtenir l'identifiant de l'année scoalire
     * @return : ID de l'année scolaire
     */
    public int getIdAnneeScolaire() {
        return idAnneeScolaire;
    }

    /**
     * Modifier l'identifiant de l'année scoalire
     * @param idAnneeScolaire : le nouveau ID de l'année scolaire
     */
    public void setIdAnneeScolaire(int idAnneeScolaire) {
        this.idAnneeScolaire = idAnneeScolaire;
    }

    /**
     * Obtenir l'objet modele de l'année scoalire
     * @return  : l'année scolaire du trimestre
     */
    public AnneeScolaire getAnneeScolaire() {
        return anneeScolaire;
    }
    
    /**
     * Modifier l'année scoalire du trimestre
     * @param anneeScolaire : le nouveau objet de l'année scolaire
     */
    public void setAnneeScolaire(AnneeScolaire anneeScolaire) {
        this.anneeScolaire = anneeScolaire;
    }
    
    @Override
    public String toString() {
        String strTrimestre = "";
        
        strTrimestre+="N° : "+this.getNumero()+"<br>";
        strTrimestre+="Début : "+ DateUtils.transformDateFromMySQL( this.getDebut().toString() ) +"<br>";
        strTrimestre+="Fin : "+ DateUtils.transformDateFromMySQL( this.getFin().toString() ) +"<br>";
        strTrimestre+="<hr>" ;
        
        strTrimestre = "<html>" + strTrimestre + "</html>";
        
        return strTrimestre;
    }
}
