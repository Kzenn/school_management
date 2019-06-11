/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

/**
 * Classe modèle qui correspond à un bulletin
 * 
 * @author Famille Francois
 */
public class Bulletin {
    /*
     * Les attributs : id, 
     */
    private int id = 0;
    private int idTrimestre = 0;
    private int idInscription = 0;
    private String appreciation = "";
    
    private Trimestre trimestre = null;
    private Inscription inscription = null;
    
    /**
     * Constructeur par defaut
     */
    public Bulletin(){
    }
    
    /**
     * Constructeur par id, idTrimestre et idInscription
     * @param id : identifiant de la trimestre d'élèves
     * @param idTrimestre : l'identifiant de la trimestre
     * @param idInscription  : l'identifiant de l'inscription
     * @param appreciation  : l'appreciation globale du bulletin
     */
    public Bulletin(int id, int idTrimestre, int idInscription, String appreciation){
        this.id = id;
        this.idTrimestre = idTrimestre;
        this.idInscription = idInscription;
        this.appreciation = appreciation;
    }

    /**
     * Obtenir l'identifiant du bulletin référencé
     * @return 
     */
    public int getId() {
        return id;
    }

    /**
     * Modifier l'identifiant du bulletin référencé
     * @param id : le nouveau id
     */
    public void setId(int id) {
        this.id = id;
    }
    
    /**
     * Obtenir l'identifiant du trimestre du bulletin référencé
     * @return : l'identifiant du trimestre
     */
    public int getIdTrimestre() {
        return idTrimestre;
    }

    /**
     * Modifier l'identifiant de trimestre du bulletin référencé
     * @param idTrimestre : le nouveau identifiant de la trimestre
     */
    public void setIdTrimestre(int idTrimestre) {
        this.idTrimestre = idTrimestre;
    }


    /**
     * Obtenir l'identifiant de l'inscription concernée par le bulletin référencé
     * @return : l'identifant de l'inscription
     */
    public int getIdInscription() {
        return idInscription;
    }

    /**
     * Modifier l'identifiant de l'inscription concernée par le bulletin référencé
     * @param idInscription : le nouveau identifiant de l'inscription
     */
    public void setIdInscription(int idInscription) {
        this.idInscription = idInscription;
    }

    /**
     * Obtenir l'appréciation globale pour le bulletin référencé
     * @return : l'appréciation globale
     */
    public String getAppreciation() {
        return appreciation;
    }

    /**
     * Modifier l'appréciation globale pour le bulletin référencé
     * @param appreciation : la nouvelle appreciation
     */
    public void setAppreciation(String appreciation) {
        this.appreciation = appreciation;
    }

    
    
    /**
     * Obtenir l'objet modèle du trimestre concerné par le bulletin référencé
     * @return : la trimestre d'élèves
     */
    public Trimestre getTrimestre() {
        return trimestre;
    }

    /**
     * Modifier l'objet modèle du trimestre concerné par le bulletin référencé
     * @param trimestre : le nouveau objet trimestre d'élèves
     */
    public void setTrimestre(Trimestre trimestre) {
        this.trimestre = trimestre;
    }

    /**
     * Obtenir l'objet modèle de l'inscription concerné par le bulletin référencé
     * @return : l'élève
     */
    public Inscription getInscription() {
        return inscription;
    }

    /**
     * Modifier l'objet modèle de l'inscription concerné par le bulletin référencé
     * @param inscription  : le nouveau objet élève
     */
    public void setInscription(Inscription inscription) {
        this.inscription = inscription;
    }
}
