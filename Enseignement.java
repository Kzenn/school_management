/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

/**
 * Classe modèle qui correspond à un enseignement
 * 
 * @author Famille Francois
 */
public class Enseignement {
    /*
     * Les attributs : id, 
     */
    private int id = 0;
    private int idClasse = 0;
    private int idDiscipline = 0;
    private int idEnseignant = 0;
    
    private Classe classe = null;
    private Discipline discipline = null;
    private Personne enseignant = null;
    
    /**
     * Constructeur par defaut
     */
    public Enseignement(){
    }
    
    /**
     * Constructeur par id, idClasse, idDiscipline et idEnseignant
     * @param id : identifiant de la classe d'élèves
     * @param idClasse : l'identifiant de la classe d'élèves
     * @param idDiscipline : l'identifiant de la discipline
     * @param idEnseignant  : l'identifiant de l'enseignant
     */
    public Enseignement(int id, int idClasse, int idDiscipline, int idEnseignant){
        this.id = id;
        this.idClasse = idClasse;
        this.idDiscipline = idDiscipline;
        this.idEnseignant = idEnseignant;
    }

    /**
     * Obtenir l'identifiant de l'enseignement référencé
     * @return 
     */
    public int getId() {
        return id;
    }

    /**
     * Modifier l'identifiant de l'enseignement référencé
     * @param id 
     */
    public void setId(int id) {
        this.id = id;
    }
    
    /**
     * Obtenir l'identifiant de la classe
     * @return : l'identifiant de la classe
     */
    public int getIdClasse() {
        return idClasse;
    }

    /**
     * Modifier l'identifiant de la classe
     * @param idClasse : le nouveau identifiant de la classe
     */
    public void setIdClasse(int idClasse) {
        this.idClasse = idClasse;
    }

    /**
     * Obtenir l'identifiant de la discipline
     * @return : l'idientifiant du discipline de l'enseignement référencé
     */
    public int getIdDiscipline() {
        return idDiscipline;
    }

    /**
     * Modifier l'identifiant de la discipline de l'enseignement référencé
     * @param idDiscipline : le nouveau identifiant de la discipline
     */
    public void setIdDiscipline(int idDiscipline) {
        this.idDiscipline = idDiscipline;
    }

    /**
     * Obtenir l'identifiant de l'enseignant de l'esneignement référencé 
     * @return : l'identifant de l'enseignant
     */
    public int getIdEnseignant() {
        return idEnseignant;
    }

    /**
     * Modifier l'identifiant de l'enseignant de la l'enseignement référencée
     * @param idEnseignant : le nouveau identifiant de l'enseignant
     */
    public void setIdEnseignant(int idEnseignant) {
        this.idEnseignant = idEnseignant;
    }

    /**
     * Obtenir l'objet modèle de la classe pour l'enseignement référencé
     * @return : la classe d'élève
     */
    public Classe getClasse() {
        return classe;
    }

    /**
     * Modifier l'objet modèle de la classe pour l'enseignement référencé
     * @param classe : le nouveau objet classe d'élève
     */
    public void setClasse(Classe classe) {
        this.classe = classe;
    }

    /**
     * Obtenir l'objet modèle de la descipline pour l'enseignement référencé
     * @return : la descipline
     */
    public Discipline getDiscipline() {
        return discipline;
    }

    /**
     * Modifier l'objet modèle de la discipline pour l'enseignement référencé
     * @param discipline  : le nouveau objet discipline
     */
    public void setDiscipline(Discipline discipline) {
        this.discipline = discipline;
    }

    /**
     * Obtenir l'objet modèle de l'enseignant pour l'enseignement référencé
     * @return : la descipline
     */
    public Personne getEnseignant() {
        return enseignant;
    }

    /**
     * Modifier l'objet modèle de l'enseignant pour l'enseignement référencé
     * @param enseignant  : le nouveau objet enseignant
     */
    public void setEnseignant(Personne enseignant) {
        this.enseignant = enseignant;
    }
}
