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
import modele.Bulletin;

/**
 * classe DAO qui permet d'accéder à la table : <b>bulletin</b>. Cette classe 
 * associe un objet modèle Bulletin à la table bulletin.<br> 
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
 * @param <Bulletin> : Bulletin est une classe du package modele (Classes Modèles)
 */
public class DAOBulletin extends DAO<Bulletin> {
    /**
     * Constructeur de la classe
     * @param connexion : Le module de connexion qui permet d'accéder à la base de données
     */
    public DAOBulletin(Connexion connexion) {
     // Créer une instance de DAOBulletin avec la connexion et le nom de table : bulletin
      super(connexion, "bulletin");
    }

    /**
    * Cette méthode permet de retourner une instance de la classe modèle Bulletin à partir d'une ligne de ResultSet
    * 
    * @param data : un result set obtenu à partir d'une requête SQL Select
    * @return : une instance de type Bulletin
    */
    @Override
    public Bulletin getObjectFromData(ResultSet data){
        Bulletin bulletin = null;
        
        try{
            bulletin = new Bulletin();
            
            bulletin.setId(data.getInt("id"));
            bulletin.setAppreciation( data.getString("appreciation") );
            bulletin.setIdTrimestre(data.getInt("id_trimestre") );
            bulletin.setIdInscription(data.getInt("id_inscription") );
        }
        catch(Exception e){
        }
        
        return bulletin;
    }
    
    /**
    * Méthode d'insertion d'un objet du modèle Bulletin dans la base de données (table bulletin)
    * @param obj : l'objet à insérer
    * @return boolean : true si l'insertion a été exécutée avec succès, false sinon
    */
    @Override
    public boolean insert(Bulletin obj) {
        String sql = "INSERT INTO `"+this.tableName+"` (`id`, `appreciation`, `id_trimestre`, `id_inscription`) VALUES (NULL, '"+obj.getAppreciation()+"', '"+obj.getIdTrimestre()+"', '"+obj.getIdInscription()+"')";
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
    * Méthode pour supprimer le tuple correspondant à l'objet du modèle Bulletin de la base de données (table bulletin)
    * @param obj : l'objet à supprimer
    * @return boolean : true si la suppression a été exécutée avec succès, false sinon
    */
    @Override
    public boolean delete(Bulletin obj) {
        String sql = "DELETE FROM `"+this.tableName+"` WHERE `"+this.tableName+"`.`id` = "+obj.getId();
        
        return this.connexion.sendQuery(sql);
    }

    /**
    * Méthode de mise à jour l'objet d'un objet du modèle Bulletin dans la base de données (table annee_scoalire)
    * @param obj : l'objet à mettre à jour
    * @return boolean : true si la mise à jour a été exécutée avec succès, false sinon
    */
    @Override
    public boolean update(Bulletin obj) {
        String sql = "UPDATE `"+this.tableName+"` SET `appreciation` = '"+obj.getAppreciation()+"', `id_trimestre` = '"+obj.getIdTrimestre()+"', `id_inscription` = '"+obj.getIdInscription()+"' WHERE `"+this.tableName+"`.`id` = "+obj.getId();
        
        return this.connexion.sendQuery(sql);
    }

    /**
    * Méthode qui permet de rechercher une instance de la classe Modèle Bulletin à partir de son id
    * @param id : l'identifiant à rechercher
    * @return Bulletin : Une instance de la classe Bulletin de l'objet à récupérer. Résultat null si id ne se trouve.
    */
    @Override
    public Bulletin findById(int id) {
        Bulletin bulletin = null;
        
        String sql = "SELECT * FROM `"+this.tableName+"` WHERE `"+this.tableName+"`.id = "+id+" LIMIT 1";
        
        ResultSet data = this.connexion.sendQuerySelect(sql);
        
        try {
            if (data.next()){
                bulletin = getObjectFromData(data);
            }
        } catch (Exception e) {
        }

        return bulletin;
    }

    
    /**
    * Méthode qui permet de récupérer les objets qui vérifient les critères dans la base de doonées du modèle T (table bulletin)
    * @return : Liste des objets dans le modèle Bulletin qui vérfient les critères
    */
    @Override
    public List<Bulletin> get(String criteres) {
        List<Bulletin> list = new ArrayList<>();
        
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
