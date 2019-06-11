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
import modele.Trimestre;

/**
 * classe DAO qui permet d'accéder à la table : <b>trimestre</b>. Cette classe 
 * associe un objet modèle Trimestre à la table trimestre.<br> 
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
 * @param <Trimestre> : Trimestre est une classe du package modele (Classes Modèles)
 */
public class DAOTrimestre extends DAO<Trimestre> {
    /**
     * Constructeur de la classe
     * @param connexion : Le module de connexion qui permet d'accéder à la base de données
     */
    public DAOTrimestre(Connexion connexion) {
        // Créer une instance de DAOTrimestre avec la connexion et le nom de table : trimestre
        super(connexion, "trimestre");
    }
    
    /**
    * Cette méthode permet de retourner une instance de la classe modèle Trimestre à partir d'une ligne de ResultSet
    * 
    * @param data : un result set obtenu à partir d'une requête SQL Select
    * @return : une instance de type Trimestre
    */
    @Override
    public Trimestre getObjectFromData(ResultSet data){
        Trimestre trimestre = null;
        
        try{
            trimestre = new Trimestre();
            
            trimestre.setId(data.getInt("id"));
            trimestre.setNumero( data.getString("numero") );
            trimestre.setDebut( data.getDate("debut") );
            trimestre.setFin( data.getDate("fin") );
            trimestre.setIdAnneeScolaire(data.getInt("id_annee_scolaire") );
        }
        catch(Exception e){
        }
        
        return trimestre;
    }

    /**
    * Méthode d'insertion d'un objet du modèle Trimestre dans la base de données (table trimestre)
    * @param obj : l'objet à insérer
    * @return boolean : true si l'insertion a été exécutée avec succès, false sinon
    */
    @Override
    public boolean insert(Trimestre obj) {
        String sql = "INSERT INTO `"+this.tableName+"` (`id`, `numero`, `debut`, `fin`, `id_annee_scolaire`) VALUES (NULL, '"+obj.getNumero().toString()+"', '"+obj.getDebut()+"', '"+obj.getFin()+"', '"+obj.getIdAnneeScolaire()+"')";
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
    * Méthode pour supprimer le tuple correspondant à l'objet du modèle Trimestre de la base de données (table trimestre)
    * @param obj : l'objet à supprimer
    * @return boolean : true si la suppression a été exécutée avec succès, false sinon
    */
    @Override
    public boolean delete(Trimestre obj) {
        String sql = "DELETE FROM `"+this.tableName+"` WHERE `"+this.tableName+"`.`id` = "+obj.getId();
        
        return this.connexion.sendQuery(sql);
    }

    /**
    * Méthode de mise à jour l'objet d'un objet du modèle AnneeScoalire dans la base de données (table annee_scoalire)
    * @param obj : l'objet à mettre à jour
    * @return boolean : true si la mise à jour a été exécutée avec succès, false sinon
    */
    @Override
    public boolean update(Trimestre obj) {
        String sql = "UPDATE `"+this.tableName+"` SET `numero` = '"+obj.getNumero()+"', `debut` = '"+obj.getDebut().toString()+"', `fin` = '"+obj.getFin().toString()+"', `id_annee_scolaire` = '"+obj.getIdAnneeScolaire()+"' WHERE `"+this.tableName+"`.`id` = "+obj.getId();
        
        return this.connexion.sendQuery(sql);
    }

    /**
    * Méthode qui permet de rechercher une instance de la classe Modèle AnneeScoalire à partir de son id
    * @param id : l'identifiant à rechercher
    * @return Trimestre : Une instance de la classe Trimestre de l'objet à récupérer. Résultat null si id ne se trouve.
    */
    @Override
    public Trimestre findById(int id) {
        Trimestre trimestre = null;
        
        String sql = "SELECT * FROM `"+this.tableName+"` WHERE `"+this.tableName+"`.id = "+id+" LIMIT 1";
        
        ResultSet data = this.connexion.sendQuerySelect(sql);
        
        try {
            if (data.next()){
                trimestre = getObjectFromData(data);
            }
        } catch (Exception e) {
        }

        return trimestre;
    }

    
    /**
    * Méthode qui permet de récupérer les objets qui vérifient les critères dans la base de doonées du modèle T (table trimestre)
    * @return : Liste des objets dans le modèle Trimestre qui vérfient les critères
    */
    @Override
    public List<Trimestre> get(String criteres) {
        List<Trimestre> list = new ArrayList<>();
        
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
