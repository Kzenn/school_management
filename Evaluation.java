/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

/**
 * Classe modèle qui correspond à une évaluation
 * 
 * @author Famille Francois
 */
public class Evaluation {
    /*
     * Les attributs : id, 
     */
    private int id = 0;
    private int idDetailBulletin = 0;
    private String appreciation = "";
    private float note = 0;
    
    private DetailBulletin detaillBulletin = null;
    
    /**
     * Constructeur par defaut
     */
    public Evaluation(){
    }
    
    /**
     * Constructeur par id, idDetailBulletin et idEnseignement
     * @param id : identifiant de la detaillBulletin d'élèves
     * @param idDetailBulletin : l'identifiant du detaill-bulletin
     * @param appreciation  : l'appreciation pour l'enseignement
     * @param note  : note de l'évaluation
     */
    public Evaluation(int id, int idDetailBulletin, String appreciation, float note){
        this.id = id;
        this.idDetailBulletin = idDetailBulletin;
        this.appreciation = appreciation;
        this.note = note;
    }

    /**
     * Obtenir l'identifiant de l'évaluation référencée
     * @return 
     */
    public int getId() {
        return id;
    }

    /**
     * Modifier l'identifiant de l'évaluation référencée
     * @param id : le nouveau id
     */
    public void setId(int id) {
        this.id = id;
    }
    
    /**
     * Obtenir l'identifiant du detaill-bulletin de l'évaluation référencée
     * @return : l'identifiant du detaillBulletin
     */
    public int getIdDetailBulletin() {
        return idDetailBulletin;
    }

    /**
     * Modifier l'identifiant de detaillBulletin de l'évaluation référencée
     * @param idDetailBulletin : le nouveau identifiant du detaill-bulletin
     */
    public void setIdDetailBulletin(int idDetailBulletin) {
        this.idDetailBulletin = idDetailBulletin;
    }

    /**
     * Obtenir l'appréciation pour l'évaluation référencée
     * @return : l'appréciation
     */
    public String getAppreciation() {
        return appreciation;
    }

    /**
     * Modifier l'appréciation pour l'évaluation référencée
     * @param appreciation : la nouvelle appreciation
     */
    public void setAppreciation(String appreciation) {
        this.appreciation = appreciation;
    }

    /**
     * Obtenir la note pour l'évaluation référencée
     * @return : la note
     */
    public float getNote() {
        return note;
    }
    
    /**
     * Modifier la note pour l'évaluation référencée
     * @param nopte : la nouvelle note
     */
    public void setNote(float note) {
        this.note = note;
    }

    
    
    
    
    /**
     * Obtenir l'objet modèle du detaill Bulletin concerné par l'évaluation référencée
     * @return : la detaillBulletin d'élèves
     */
    public DetailBulletin getDetaillBulletin() {
        return detaillBulletin;
    }

    /**
     * Modifier l'objet modèle du detaill Bulletin concerné par l'évaluation référencée
     * @param detaillBulletin : le nouveau objet detaill Bulletin
     */
    public void setDetaillBulletin(DetailBulletin detaillBulletin) {
        this.detaillBulletin = detaillBulletin;
    }
}
