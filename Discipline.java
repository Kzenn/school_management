/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

/**
 * Classe modèle qui correspond à la discipline
 * 
 * @author Famille Francois
 */
public class Discipline {
    /*
     * Les attributs : id et nom de la discipline
     */
    private int id = 0;
    private String nom = "";
    
    /**
     * Constructeur par defaut
     */
    public Discipline(){
    }
    
    /**
     * Constructeur par id et le nom
     * @param id : identifiant de la discipline
     * @param nom : nom de la discipline 
     */
    public Discipline(int id, String nom){
        this.id = id;
        this.nom = nom;
    }

    /**
     * Obtenir l'identifiant de la discipline 
     * @return 
     */
    public int getId() {
        return id;
    }

    /**
     * Modifier l'identifiant de la discipline 
     * @param id 
     */
    public void setId(int id) {
        this.id = id;
    }
    
    /**
     * Obtenir le nom de la discipline référencée
     * @return : le nom
     */
    public String getNom(){
        return this.nom;
    }
    
    /**
     * Modifier le nom de la discipline référencée
     * @param nom : nom de la discipline
     */
    public void setNom(String nom){
        this.nom = nom;
    }
}
