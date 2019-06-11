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
import modele.Evaluation;

/**
 * classe DAO qui permet d'accéder à la table : <b>evaluation</b>. Cette classe 
 * associe un objet modèle Evaluation à la table evaluation.<br> 
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
 * @param <Evaluation> : Evaluation est une classe du package modele (Classes Modèles)
 */
public class DAOEvaluation extends DAO<Evaluation> {
    /**
     * Constructeur de la classe
     * @param connexion : Le module de connexion qui permet d'accéder à la base de données
     */
    public DAOEvaluation(Connexion connexion) {
     // Créer une instance de DAOEvaluation avec la connexion et le nom de table : evaluation
      super(connexion, "evaluation");
    }

    /**
    * Cette méthode permet de retourner une instance de la classe modèle Evaluation à partir d'une ligne de ResultSet
    * 
    * @param data : un result set obtenu à partir d'une requête SQL Select
    * @return : une instance de type Evaluation
    */
    @Override
    public Evaluation getObjectFromData(ResultSet data){
        Evaluation evaluation = null;
        
        try{
            evaluation = new Evaluation();
            
            evaluation.setId(data.getInt("id"));
            evaluation.setAppreciation( data.getString("appreciation") );
            evaluation.setNote(data.getFloat("note") );
            evaluation.setIdDetailBulletin(data.getInt("id_detail_bulletin") );
        }
        catch(Exception e){
        }
        
        return evaluation;
    }
    
    /**
    * Méthode d'insertion d'un objet du modèle Evaluation dans la base de données (table evaluation)
    * @param obj : l'objet à insérer
    * @return boolean : true si l'insertion a été exécutée avec succès, false sinon
    */
    @Override
    public boolean insert(Evaluation obj) {
        String sql = "INSERT INTO `"+this.tableName+"` (`id`, `appreciation`, `note`, `id_detail_bulletin`) VALUES (NULL, '"+obj.getAppreciation()+"', '"+obj.getNote()+"', '"+obj.getIdDetailBulletin()+"')";
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
    * Méthode pour supprimer le tuple correspondant à l'objet du modèle Evaluation de la base de données (table evaluation)
    * @param obj : l'objet à supprimer
    * @return boolean : true si la suppression a été exécutée avec succès, false sinon
    */
    @Override
    public boolean delete(Evaluation obj) {
        String sql = "DELETE FROM `"+this.tableName+"` WHERE `"+this.tableName+"`.`id` = "+obj.getId();
        
        return this.connexion.sendQuery(sql);
    }

    /**
    * Méthode de mise à jour l'objet d'un objet du modèle Evaluation dans la base de données (table annee_scoalire)
    * @param obj : l'objet à mettre à jour
    * @return boolean : true si la mise à jour a été exécutée avec succès, false sinon
    */
    @Override
    public boolean update(Evaluation obj) {
        String sql = "UPDATE `"+this.tableName+"` SET `appreciation` = '"+obj.getAppreciation()+"', `note` = '"+obj.getNote()+"', `id_detail_bulletin` = '"+obj.getIdDetailBulletin()+"' WHERE `"+this.tableName+"`.`id` = "+obj.getId();
        
        return this.connexion.sendQuery(sql);
    }

    /**
    * Méthode qui permet de rechercher une instance de la classe Modèle Evaluation à partir de son id
    * @param id : l'identifiant à rechercher
    * @return Evaluation : Une instance de la classe Evaluation de l'objet à récupérer. Résultat null si id ne se trouve.
    */
    @Override
    public Evaluation findById(int id) {
        Evaluation evaluation = null;
        
        String sql = "SELECT * FROM `"+this.tableName+"` WHERE `"+this.tableName+"`.id = "+id+" LIMIT 1";
        
        ResultSet data = this.connexion.sendQuerySelect(sql);
        
        try {
            if (data.next()){
                evaluation = getObjectFromData(data);
            }
        } catch (Exception e) {
        }

        return evaluation;
    }

    
    /**
    * Méthode qui permet de récupérer les objets qui vérifient les critères dans la base de doonées du modèle T (table evaluation)
    * @return : Liste des objets dans le modèle Evaluation qui vérfient les critères
    */
    @Override
    public List<Evaluation> get(String criteres) {
        List<Evaluation> list = new ArrayList<>();
        
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
