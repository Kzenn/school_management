/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

/**
 * Classe modèle qui correspond à une inscription
 * 
 * @author Famille Francois
 */
public class Inscription {
    /*
     * Les attributs : id, 
     */
    private int id = 0;
    private int idClasse = 0;
    private int idEleve = 0;
    
    private Classe classe = null;
    private Personne eleve = null;
    
    /**
     * Constructeur par defaut
     */
    public Inscription(){
    }
    
    /**
     * Constructeur par id, idClasse et idEleve
     * @param id : identifiant de la classe d'élèves
     * @param idClasse : l'identifiant de la classe d'élèves
     * @param idEleve  : l'identifiant de l'eleve
     */
    public Inscription(int id, int idClasse, int idEleve){
        this.id = id;
        this.idClasse = idClasse;
        this.idEleve = idEleve;
    }

    /**
     * Obtenir l'identifiant de l'inscription référencée
     * @return 
     */
    public int getId() {
        return id;
    }

    /**
     * Modifier l'identifiant de l'inscription référencée
     * @param id : le nouveau id
     */
    public void setId(int id) {
        this.id = id;
    }
    
    /**
     * Obtenir l'identifiant de la classe d'élève pour l'inscription référencée
     * @return : l'identifiant de la classe d'élève
     */
    public int getIdClasse() {
        return idClasse;
    }

    /**
     * Modifier l'identifiant de la classe d'élève pour l'inscription référencée
     * @param idClasse : le nouveau identifiant de la classe d'élève
     */
    public void setIdClasse(int idClasse) {
        this.idClasse = idClasse;
    }


    /**
     * Obtenir l'identifiant de l'eleve concerné par l'inscription référencée
     * @return : l'identifant de l'eleve
     */
    public int getIdEleve() {
        return idEleve;
    }

    /**
     * Modifier l'identifiant de l'eleve concerné par l'inscription référencée
     * @param idEleve : le nouveau identifiant de l'eleve
     */
    public void setIdEleve(int idEleve) {
        this.idEleve = idEleve;
    }

    /**
     * Obtenir l'objet modèle de la classe pour l'inscription référencée
     * @return : la classe d'élèves
     */
    public Classe getClasse() {
        return classe;
    }

    /**
     * Modifier l'objet modèle de la classe pour l'inscription référencée
     * @param classe : le nouveau objet classe d'élèves
     */
    public void setClasse(Classe classe) {
        this.classe = classe;
    }

    /**
     * Obtenir l'objet modèle de l'eleve concerné par l'inscription référencée
     * @return : l'élève
     */
    public Personne getEleve() {
        return eleve;
    }

    /**
     * Modifier l'objet modèle de l'eleve concerné par l'inscription référencée
     * @param eleve  : le nouveau objet élève
     */
    public void setEleve(Personne eleve) {
        this.eleve = eleve;
    }
}
