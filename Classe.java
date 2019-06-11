/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

/**
 * Classe modèle qui correspond à la classe d'élève
 * 
 * @author Famille Francois
 */
public class Classe {
    /*
     * Les attributs : id et année
     */
    private int id = 0;
    private String nom = "";
    private int idEcole = 0;
    private int idNiveau = 0;
    private int idAnneeScolaire = 0;
    
    private Ecole ecole = null;
    private Niveau niveau = null;
    private AnneeScolaire anneeScolaire = null;
    
    /**
     * Constructeur par defaut
     */
    public Classe(){
    }
    
    /**
     * Constructeur par id, nom, idEcole, idNiveau et idAnneeUniversitaire
     * @param id : identifiant de la classe d'élèves
     * @param nom : nom de la classe d'élèves
     * @param idEcole : l'identifiant de l'école
     * @param idNiveau : l'identifiant du niveau de la classe d'élève
     * @param idAnneeScolaire  : l'identifiant de l'année scolaire
     */
    public Classe(int id, String nom, int idEcole, int idNiveau, int idAnneeScolaire){
        this.id = id;
        this.nom = nom;
        this.idEcole = idEcole;
        this.idNiveau = idNiveau;
        this.idAnneeScolaire = idAnneeScolaire;
    }

    /**
     * Obtenir l'identifiant de la classe d'élève
     * @return 
     */
    public int getId() {
        return id;
    }

    /**
     * Modifier l'identifiant de la classe d'élève
     * @param id 
     */
    public void setId(int id) {
        this.id = id;
    }
    
    /**
     * Obtenir le nom de la classe d'élève
     * @return : nom de la classe
     */
    public String getNom(){
        return this.nom;
    }
    
    /**
     * Modifier le nom de la classe d'élève
     * @param nom : le nouveau nom de la classe d'élève
     */
    public void setNom(String nom){
        this.nom = nom;
    }

    /**
     * Obtenir l'identifiant de l'école
     * @return : l'identifiant de l'école
     */
    public int getIdEcole() {
        return idEcole;
    }

    /**
     * Modifier l'identifiant de l'école
     * @param idEcole : le nouveau identifiant de l'école
     */
    public void setIdEcole(int idEcole) {
        this.idEcole = idEcole;
    }

    /**
     * Obtenir l'identifiant du niveau
     * @return : l'idientifiant du niveau de la classe référencée
     */
    public int getIdNiveau() {
        return idNiveau;
    }

    /**
     * Modifier l'identifiant du niveau de la classe d'évlève référencée
     * @param idNiveau : le nouveau identifiant du niveau
     */
    public void setIdNiveau(int idNiveau) {
        this.idNiveau = idNiveau;
    }

    /**
     * Obtenir l'identifiant de l'année scolaire de la classe référencée
     * @return : l'identifant de l'année scolaire
     */
    public int getIdAnneeScolaire() {
        return idAnneeScolaire;
    }

    /**
     * Modifier l'identifiant de l'année scolaire de la classe référencée
     * @param idAnneeScolaire : le nouveau identifiant de l'année scoalire
     */
    public void setIdAnneeScolaire(int idAnneeScolaire) {
        this.idAnneeScolaire = idAnneeScolaire;
    }

    /**
     * 
     * @return 
     */
    public Ecole getEcole() {
        return ecole;
    }

    /**
     * 
     * @param ecole 
     */
    public void setEcole(Ecole ecole) {
        this.ecole = ecole;
    }

    /**
     * 
     * @return 
     */
    public Niveau getNiveau() {
        return niveau;
    }

    /**
     * 
     * @param niveau 
     */
    public void setNiveau(Niveau niveau) {
        this.niveau = niveau;
    }

    /**
     * 
     * @return 
     */
    public AnneeScolaire getAnneeScolaire() {
        return anneeScolaire;
    }

    /**
     * 
     * @param anneeScolaire 
     */
    public void setAnneeScolaire(AnneeScolaire anneeScolaire) {
        this.anneeScolaire = anneeScolaire;
    }
}
