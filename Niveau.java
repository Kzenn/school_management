/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

/**
 * Classe modèle qui correspond au niveau
 * 
 * @author Famille Francois
 */
public class Niveau {
    /*
     * Les attributs : id et année
     */
    private int id = 0;
    private String nom = "";
    
    /**
     * Constructeur par defaut
     */
    public Niveau(){
    }
    
    /**
     * Constructeur par id et le niveau
     * @param id : identifiant du niveau
     * @param nom : nom (libellé) du niveau 
     */
    public Niveau(int id, String nom){
        this.id = id;
        this.nom = nom;
    }

    /**
     * Obtenir l'identifiant du niveau
     * @return 
     */
    public int getId() {
        return id;
    }

    /**
     * Modifier l'identifiant du niveau
     * @param id 
     */
    public void setId(int id) {
        this.id = id;
    }
    
    /**
     * Obtenir le nom (libellée) du niveau
     * @return 
     */
    public String getNom(){
        return this.nom;
    }
    
    /**
     * Modifier le nom (libellé) du niveau
     * @param nom 
     */
    public void setNom(String nom){
        this.nom = nom;
    }
    
    @Override
    public String toString() {
        String strEcole = "";
        
        strEcole+=this.getNom()+"<br>";
        strEcole+="<hr>" ;
        
        strEcole = "<html>" + strEcole + "</html>";
        
        return strEcole;
    }
}
