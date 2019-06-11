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
import modele.Inscription;

/**
 * classe DAO qui permet d'accéder à la table : <b>inscription</b>. Cette classe 
 * associe un objet modèle Inscription à la table inscription.<br> 
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
 * @param <Inscription> : Inscription est une classe du package modele (Classes Modèles)
 */
public class DAOInscription extends DAO<Inscription> {
    /**
     * Constructeur de la classe
     * @param connexion : Le module de connexion qui permet d'accéder à la base de données
     */
    public DAOInscription(Connexion connexion) {
     // Créer une instance de DAOInscription avec la connexion et le nom de table : inscription
      super(connexion, "inscription");
    }

    /**
    * Cette méthode permet de retourner une instance de la classe modèle Inscription à partir d'une ligne de ResultSet
    * 
    * @param data : un result set obtenu à partir d'une requête SQL Select
    * @return : une instance de type Inscription
    */
    @Override
    public Inscription getObjectFromData(ResultSet data){
        Inscription inscription = null;
        
        try{
            inscription = new Inscription();
            
            inscription.setId(data.getInt("id"));
            inscription.setIdClasse( data.getInt("id_classe") );
            inscription.setIdEleve( data.getInt("id_eleve") );
        }
        catch(Exception e){
        }
        
        return inscription;
    }
    
    /**
    * Méthode d'insertion d'un objet du modèle Inscription dans la base de données (table inscription)
    * @param obj : l'objet à insérer
    * @return boolean : true si l'insertion a été exécutée avec succès, false sinon
    */
    @Override
    public boolean insert(Inscription obj) {
        String sql = "INSERT INTO `"+this.tableName+"` (`id`, `id_classe`, `id_eleve`) VALUES (NULL, '"+obj.getIdClasse()+"', '"+obj.getIdEleve()+"')";
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
    * Méthode pour supprimer le tuple correspondant à l'objet du modèle Inscription de la base de données (table inscription)
    * @param obj : l'objet à supprimer
    * @return boolean : true si la suppression a été exécutée avec succès, false sinon
    */
    @Override
    public boolean delete(Inscription obj) {
        String sql = "DELETE FROM `"+this.tableName+"` WHERE `"+this.tableName+"`.`id` = "+obj.getId();
        
        return this.connexion.sendQuery(sql);
    }

    /**
    * Méthode de mise à jour l'objet d'un objet du modèle Inscription dans la base de données (table annee_scoalire)
    * @param obj : l'objet à mettre à jour
    * @return boolean : true si la mise à jour a été exécutée avec succès, false sinon
    */
    @Override
    public boolean update(Inscription obj) {
        String sql = "UPDATE `"+this.tableName+"` SET `id_classe` = '"+obj.getIdClasse()+"', `id_eleve` = '"+obj.getIdEleve()+"' WHERE `"+this.tableName+"`.`id` = "+obj.getId();
        
        return this.connexion.sendQuery(sql);
    }

    /**
    * Méthode qui permet de rechercher une instance de la classe Modèle Inscription à partir de son id
    * @param id : l'identifiant à rechercher
    * @return Inscription : Une instance de la classe Inscription de l'objet à récupérer. Résultat null si id ne se trouve.
    */
    @Override
    public Inscription findById(int id) {
        Inscription inscription = null;
        
        String sql = "SELECT * FROM `"+this.tableName+"` WHERE `"+this.tableName+"`.id = "+id+" LIMIT 1";
        
        ResultSet data = this.connexion.sendQuerySelect(sql);
        
        try {
            if (data.next()){
                inscription = getObjectFromData(data);
            }
        } catch (Exception e) {
        }

        return inscription;
    }

    
    /**
    * Méthode qui permet de récupérer les objets qui vérifient les critères dans la base de doonées du modèle T (table inscription)
    * @return : Liste des objets dans le modèle Inscription qui vérfient les critères
    */
    @Override
    public List<Inscription> get(String criteres) {
        List<Inscription> list = new ArrayList<>();
        
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
