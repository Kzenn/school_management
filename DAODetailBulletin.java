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
import modele.DetailBulletin;

/**
 * classe DAO qui permet d'accéder à la table : <b>detail_bulletin</b>. Cette classe 
 * associe un objet modèle DetailBulletin à la table detail_bulletin.<br> 
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
 * @param <DetailBulletin> : DetailBulletin est une classe du package modele (Classes Modèles)
 */
public class DAODetailBulletin extends DAO<DetailBulletin> {
    /**
     * Constructeur de la classe
     * @param connexion : Le module de connexion qui permet d'accéder à la base de données
     */
    public DAODetailBulletin(Connexion connexion) {
     // Créer une instance de DAODetailBulletin avec la connexion et le nom de table : detail_bulletin
      super(connexion, "detail_bulletin");
    }

    /**
    * Cette méthode permet de retourner une instance de la classe modèle DetailBulletin à partir d'une ligne de ResultSet
    * 
    * @param data : un result set obtenu à partir d'une requête SQL Select
    * @return : une instance de type DetailBulletin
    */
    @Override
    public DetailBulletin getObjectFromData(ResultSet data){
        DetailBulletin detailBulletin = null;
        
        try{
            detailBulletin = new DetailBulletin();
            
            detailBulletin.setId(data.getInt("id"));
            detailBulletin.setAppreciation( data.getString("appreciation") );
            detailBulletin.setIdEnseignement(data.getInt("id_enseignement") );
            detailBulletin.setIdBulletin(data.getInt("id_bulletin") );
        }
        catch(Exception e){
        }
        
        return detailBulletin;
    }
    
    /**
    * Méthode d'insertion d'un objet du modèle DetailBulletin dans la base de données (table detail_bulletin)
    * @param obj : l'objet à insérer
    * @return boolean : true si l'insertion a été exécutée avec succès, false sinon
    */
    @Override
    public boolean insert(DetailBulletin obj) {
        String sql = "INSERT INTO `"+this.tableName+"` (`id`, `appreciation`, `id_enseignement`, `id_bulletin`) VALUES (NULL, '"+obj.getAppreciation()+"', '"+obj.getIdEnseignement()+"', '"+obj.getIdBulletin()+"')";
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
    * Méthode pour supprimer le tuple correspondant à l'objet du modèle DetailBulletin de la base de données (table detail_bulletin)
    * @param obj : l'objet à supprimer
    * @return boolean : true si la suppression a été exécutée avec succès, false sinon
    */
    @Override
    public boolean delete(DetailBulletin obj) {
        String sql = "DELETE FROM `"+this.tableName+"` WHERE `"+this.tableName+"`.`id` = "+obj.getId();
        
        return this.connexion.sendQuery(sql);
    }

    /**
    * Méthode de mise à jour l'objet d'un objet du modèle DetailBulletin dans la base de données (table annee_scoalire)
    * @param obj : l'objet à mettre à jour
    * @return boolean : true si la mise à jour a été exécutée avec succès, false sinon
    */
    @Override
    public boolean update(DetailBulletin obj) {
        String sql = "UPDATE `"+this.tableName+"` SET `appreciation` = '"+obj.getAppreciation()+"', `id_enseignement` = '"+obj.getIdEnseignement()+"', `id_bulletin` = '"+obj.getIdBulletin()+"' WHERE `"+this.tableName+"`.`id` = "+obj.getId();
        
        return this.connexion.sendQuery(sql);
    }

    /**
    * Méthode qui permet de rechercher une instance de la classe Modèle DetailBulletin à partir de son id
    * @param id : l'identifiant à rechercher
    * @return DetailBulletin : Une instance de la classe DetailBulletin de l'objet à récupérer. Résultat null si id ne se trouve.
    */
    @Override
    public DetailBulletin findById(int id) {
        DetailBulletin detailDetailBulletin = null;
        
        String sql = "SELECT * FROM `"+this.tableName+"` WHERE `"+this.tableName+"`.id = "+id+" LIMIT 1";
        
        ResultSet data = this.connexion.sendQuerySelect(sql);
        
        try {
            if (data.next()){
                detailDetailBulletin = getObjectFromData(data);
            }
        } catch (Exception e) {
        }

        return detailDetailBulletin;
    }

    
    /**
    * Méthode qui permet de récupérer les objets qui vérifient les critères dans la base de doonées du modèle T (table detail_bulletin)
    * @return : Liste des objets dans le modèle DetailBulletin qui vérfient les critères
    */
    @Override
    public List<DetailBulletin> get(String criteres) {
        List<DetailBulletin> list = new ArrayList<>();
        
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
