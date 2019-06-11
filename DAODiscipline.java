/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

/**
 *
 * @author Famille Francois
 */

import connexion.Connexion;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import modele.Discipline;

/**
 * classe DAO qui permet d'accéder à la table : <b>discipline</b>. Cette classe 
 * associe un objet modèle Discipline à la table discipline.<br> 
 * <br>
 * Un objet de cette classe permet de réaliser les opérations suivantes  :<br>
 * - Insérer un nouveau objet dans la base de données<br>
 * - Suppriemr un objet dans la base de données<br>
 * - Mettre à jour un objet dans la base de données <br>
 * - Avoir la liste des objets qui sont enregistrés dans la base de données
 * - Avoir la liste des objets qui vérifient un ensemble de critères
 * 
 * @author Famille Francois
 * 
 * @param <Discipline> : Discipline est une classe du package modele (Classes Modèles)
 */
public class DAODiscipline extends DAO<Discipline> {
    /**
     * Constructeur de la classe
     * @param connexion : Le module de connexion qui permet d'accéder à la base de données
     */
    public DAODiscipline(Connexion connexion) {
     // Créer une instance de DAODiscipline avec la connexion et le nom de table : discipline
      super(connexion, "discipline");
    }

    /**
    * Cette méthode permet de retourner une instance de la classe modèle Discipline à partir d'une ligne de ResultSet
    * 
    * @param data : un result set obtenu à partir d'une requête SQL Select
    * @return : une instance de type Discipline
    */
    @Override
    public Discipline getObjectFromData(ResultSet data){
        Discipline discipline = null;
        
        try{
            discipline = new Discipline();
            
            discipline.setId(data.getInt("id"));
            discipline.setNom( data.getString("nom") );
        }
        catch(Exception e){
        }
        
        return discipline;
    }
    
    /**
    * Méthode d'insertion d'un objet du modèle Discipline dans la base de données (table discipline)
    * @param obj : l'objet à insérer
    * @return boolean : true si l'insertion a été exécutée avec succès, false sinon
    */
    @Override
    public boolean insert(Discipline obj) {
        String sql = "INSERT INTO `"+this.tableName+"` (`id`, `nom`) VALUES (NULL, '"+obj.getNom()+"')";
        boolean result = this.connexion.sendQuery(sql);
        
        try{
            ResultSet data = connexion.sendQuerySelect("select id from `"+this.tableName+"` order by id desc limit 1");
            if (data.next()){
                int id = data.getInt("id");
                obj.setId(id);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        return result;
    }

    /**
    * Méthode pour supprimer le tuple correspondant à l'objet du modèle Discipline de la base de données (table discipline)
    * @param obj : l'objet à supprimer
    * @return boolean : true si la suppression a été exécutée avec succès, false sinon
    */
    @Override
    public boolean delete(Discipline obj) {
        String sql = "DELETE FROM `"+this.tableName+"` WHERE `"+this.tableName+"`.`id` = "+obj.getId();
        
        return this.connexion.sendQuery(sql);
    }

    /**
    * Méthode de mise à jour l'objet d'un objet du modèle Discipline dans la base de données (table annee_scoalire)
    * @param obj : l'objet à mettre à jour
    * @return boolean : true si la mise à jour a été exécutée avec succès, false sinon
    */
    @Override
    public boolean update(Discipline obj) {
        String sql = "UPDATE `"+this.tableName+"` SET `nom` = '"+obj.getNom()+"' WHERE `"+this.tableName+"`.`id` = "+obj.getId();
        
        return this.connexion.sendQuery(sql);
    }

    /**
    * Méthode qui permet de rechercher une instance de la classe Modèle Discipline à partir de son id
    * @param id : l'identifiant à rechercher
    * @return Discipline : Une instance de la classe Discipline de l'objet à récupérer. Résultat null si id ne se trouve.
    */
    @Override
    public Discipline findById(int id) {
        Discipline discipline = null;
        
        String sql = "SELECT * FROM `"+this.tableName+"` WHERE `"+this.tableName+"`.id = "+id+" LIMIT 1";
        
        ResultSet data = this.connexion.sendQuerySelect(sql);
        
        try {
            if (data.next()){
                discipline = getObjectFromData(data);
            }
        } catch (Exception e) {
        }

        return discipline;
    }

    
    /**
    * Méthode qui permet de récupérer les objets qui vérifient les critères dans la base de doonées du modèle T (table discipline)
    * @return : Liste des objets dans le modèle Discipline qui vérfient les critères
    */
    @Override
    public List<Discipline> get(String criteres) {
        List<Discipline> list = new ArrayList<>();
        
        if (criteres.trim().equals("")){
            criteres = "1";
        }
        
        String sql = "SELECT * FROM `"+this.tableName+"` WHERE "+criteres;
        
        ResultSet data = this.connexion.sendQuerySelect(sql);
        
        try {
            while (data.next()){
                list.add( getObjectFromData(data) );
            }
        } catch (Exception e) {
        }
        
        return list;
    }
}
