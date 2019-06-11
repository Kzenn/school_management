/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

/**
 * Classe modèle qui correspond à une personne(Enseignant / Élève)
 * 
 * @author Famille Francois
 */
public class Personne {

    /**
     * TypePersonne : type énumération interne
     * Voir : Découvrez les énumérations. URL : https://openclassrooms.com/fr/courses/26832-apprenez-a-programmer-en-java/22162-decouvrez-les-enumerations
     */
    public static enum TypePersonne{
        Enseignant("Enseignant"), Eleve("Élève");
        
        private String libelle = "";
        
        TypePersonne(String libelle){
            this.libelle = libelle;
        }

        public String toString() {
            return this.libelle;
        }
        
        public boolean isEquals(Object other){
            boolean equals = false;
            
            if (other instanceof TypePersonne){
                TypePersonne otherType = (TypePersonne)other;
                equals = this.libelle.equals( otherType.libelle   );
            }
            
            return equals;
        }
        
        public static TypePersonne getTypeByLibelle(String libelle){
            TypePersonne type = null;
            
            if (libelle.equalsIgnoreCase("Enseignant")){
                type = Enseignant;
            }
            else {
                type = Eleve;
            }
            
            return type;
        }
    };
    
    /*
     * Les attributs : id et année
     */
    private int id = 0;
    private String nom = "";
    private String prenom = "";
    private TypePersonne type = TypePersonne.Enseignant;
    
    /**
     * Constructeur par defaut
     */
    public Personne(){
    }
    
    /**
     * Constructeur de la classe Personne
     * 
     * @param id : identifiant de la personne
     * @param nom : nom de la personne
     * @param prenom : prénom de la personne
     * @param type : type de la personne
     */
    public Personne(int id, String nom, String prenom, TypePersonne type){
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.type = type;
    }

    /**
     * Obtenir l'identifiant de la personne référencée
     * @return : Identifiant de la personne
     */
    public int getId() {
        return id;
    }

    /**
     * Modifier l'identifiant de la personne référencée
     * @param id : le nouveau identifiant
     */
    public void setId(int id) {
        this.id = id;
    }
    
    /**
     * Obtenir le nom de la personne référencée
     * @return : nom de la personne
     */
    public String getNom(){
        return this.nom;
    }
    
    /**
     * Modifier le nom de la personne référencée
     * @param nom : le nouveau nom de la personne 
     */
    public void setNom(String nom){
        this.nom = nom;
    }

    /**
     * Obtenir le prénom de la personne référencée
     * @return : prénom de la personne
     */
    public String getPrenom() {
        return prenom;
    }

    /**
     * Modifier le prénom de la personne référencée
     * @param prenom : le nouveau prénom de la personne 
     */
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    /**
     * Obtenir le type de la personne référencée
     * @return : type de la personne (Enseignant / Élève)
     */
    public TypePersonne getType() {
        return type;
    }

    /**
     * Modifier le type de la personne référencée, soit Enseignant ou Élève
     * @param type : le nouveau type de la personne 
     */
    public void setType(TypePersonne type) {
        this.type = type;
    }
}
