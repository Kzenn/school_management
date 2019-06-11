/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

/**
 * Classe modèle qui correspond à l'école
 * 
 * @author Famille Francois
 */
public class Ecole {
    /*
     * Les attributs : id et année
     */
    private int id = 0;
    private String nomEcole = "";
    private String adresse = "";
    
    /**
     * Constructeur par defaut
     */
    public Ecole(){
    }
    
    /**
     * Constructeur de la classe Ecole
     * 
     * @param id : identifiant de l'école
     * @param nomEcole : nom de l'école
     * @param adresse : adresse de l'école
     */
    public Ecole(int id, String nomEcole, String adresse){
        this.id = id;
        this.nomEcole = nomEcole;
        this.adresse = adresse;
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
     * Obtenir le nom de l'école
     * @return 
     */
    public String getNomEcole(){
        return this.nomEcole;
    }
    
    /**
     * Modifier le nom de l'école
     * @param nomEcole : le nouveau nom de l'école ... 
     */
    public void setNomEcole(String nomEcole){
        this.nomEcole = nomEcole;
    }

     /**
     * Obtenir l'adresse de l'école
     * @return 
     */
    public String getAdresse() {
        return adresse;
    }

    /**
     * Modifier l'adresse de l'école
     * @param adresse : la nouvelle adresse de l'école ... 
     */
    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    @Override
    public String toString() {
        String strEcole = "";
        
        strEcole+="Nom : "+this.getNomEcole()+"<br>";
        strEcole+="Adresse : "+this.getAdresse()+"<br>";
        strEcole+="<hr>" ;
        
        strEcole = "<html>" + strEcole + "</html>";
        
        return strEcole;
    }
    
}
