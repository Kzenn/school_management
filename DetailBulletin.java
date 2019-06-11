/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

/**
 * Classe modèle qui correspond à un détail bulletin
 * 
 * @author Famille Francois
 */
public class DetailBulletin {
    /*
     * Les attributs : id, 
     */
    private int id = 0;
    private int idBulletin = 0;
    private int idEnseignement = 0;
    private String appreciation = "";
    
    private Bulletin bulletin = null;
    private Enseignement enseignement = null;
    
    /**
     * Constructeur par defaut
     */
    public DetailBulletin(){
    }
    
    /**
     * Constructeur par id, idBulletin et idEnseignement
     * @param id : identifiant de la bulletin d'élèves
     * @param idBulletin : l'identifiant du bulletin
     * @param idEnseignement  : l'identifiant de l'enseignement
     * @param appreciation  : l'appreciation pour l'enseignement
     */
    public DetailBulletin(int id, int idBulletin, int idEnseignement, String appreciation){
        this.id = id;
        this.idBulletin = idBulletin;
        this.idEnseignement = idEnseignement;
        this.appreciation = appreciation;
    }

    /**
     * Obtenir l'identifiant du détail bulletin référencé
     * @return 
     */
    public int getId() {
        return id;
    }

    /**
     * Modifier l'identifiant du détail bulletin référencé
     * @param id : le nouveau id
     */
    public void setId(int id) {
        this.id = id;
    }
    
    /**
     * Obtenir l'identifiant du bulletin du détail bulletin référencé
     * @return : l'identifiant du bulletin
     */
    public int getIdBulletin() {
        return idBulletin;
    }

    /**
     * Modifier l'identifiant de bulletin du détail bulletin référencé
     * @param idBulletin : le nouveau identifiant du bulletin
     */
    public void setIdBulletin(int idBulletin) {
        this.idBulletin = idBulletin;
    }


    /**
     * Obtenir l'identifiant de l'enseignement concerné par le détail bulletin référencé
     * @return : l'identifant de l'enseignement
     */
    public int getIdEnseignement() {
        return idEnseignement;
    }

    /**
     * Modifier l'identifiant de l'enseignement concerné par le détail bulletin référencé
     * @param idEnseignement : le nouveau identifiant de l'enseignement
     */
    public void setIdEnseignement(int idEnseignement) {
        this.idEnseignement = idEnseignement;
    }

    /**
     * Obtenir l'appréciation pour le détail bulletin référencé
     * @return : l'appréciation
     */
    public String getAppreciation() {
        return appreciation;
    }

    /**
     * Modifier l'appréciation pour le détail bulletin référencé
     * @param appreciation : la nouvelle appreciation
     */
    public void setAppreciation(String appreciation) {
        this.appreciation = appreciation;
    }

    
    
    /**
     * Obtenir l'objet modèle du bulletin concerné par le détail bulletin référencé
     * @return : la bulletin d'élèves
     */
    public Bulletin getBulletin() {
        return bulletin;
    }

    /**
     * Modifier l'objet modèle du bulletin concerné par le détail bulletin référencé
     * @param bulletin : le nouveau objet bulletin d'élèves
     */
    public void setBulletin(Bulletin bulletin) {
        this.bulletin = bulletin;
    }

    /**
     * Obtenir l'objet modèle de l'enseignement concerné par le détail bulletin référencé
     * @return : l'élève
     */
    public Enseignement getEnseignement() {
        return enseignement;
    }

    /**
     * Modifier l'objet modèle de l'enseignement concerné par le détail bulletin référencé
     * @param enseignement  : le nouveau objet élève
     */
    public void setEnseignement(Enseignement enseignement) {
        this.enseignement = enseignement;
    }
}
