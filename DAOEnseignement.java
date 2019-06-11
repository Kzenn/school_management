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
import modele.Enseignement;

/**
 * classe DAO qui permet d'accéder à la table : <b>enseignement</b>. Cette classe 
 * associe un objet modèle Enseignement à la table enseignement.<br> 
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
 * @param <Enseignement> : Enseignement est une classe du package modele (Classes Modèles)
 */
public class DAOEnseignement extends DAO<Enseignement> {
    /**
     * Constructeur de la classe
     * @param connexion : Le module de connexion qui permet d'accéder à la base de données
     */
    public DAOEnseignement(Connexion connexion) {
        // Créer une instance de DAOEnseignement avec la connexion et le nom de table : classe
        super(connexion, "enseignement");
    }
    
    /**
    * Cette méthode permet de retourner une instance de la classe modèle Classe à partir d'une ligne de ResultSet
    * 
    * @param data : un result set obtenu à partir d'une requête SQL Select
    * @return : une instance de type Enseignement
    */
    @Override
    public Enseignement getObjectFromData(ResultSet data){
        Enseignement enseignement = null;
        
        try{
            enseignement = new Enseignement();
                
            enseignement.setId(data.getInt("id"));
            enseignement.setIdClasse(data.getInt("id_classe") );
            enseignement.setIdDiscipline(data.getInt("id_discipline") );
            enseignement.setIdEnseignant(data.getInt("id_enseignant") );
        }
        catch(Exception e){
        }
        
        return enseignement;
    }

    /**
    * Méthode d'insertion d'un objet du modèle Enseignement dans la base de données (table classe)
    * @param obj : l'objet à insérer
    * @return boolean : true si l'insertion a été exécutée avec succès, false sinon
    */
    @Override
    public boolean insert(Enseignement obj) {
        String sql = "INSERT INTO `"+this.tableName+"` (`id`, `id_classe`, `id_discipline`, `id_enseignant`) VALUES (NULL, '"+obj.getIdClasse()+"', '"+obj.getDiscipline()+"', '"+obj.getIdEnseignant()+"')";
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
    * Méthode pour supprimer le tuple correspondant à l'objet du modèle Enseignement de la base de données (table classe)
    * @param obj : l'objet à supprimer
    * @return boolean : true si la suppression a été exécutée avec succès, false sinon
    */
    @Override
    public boolean delete(Enseignement obj) {
        String sql = "DELETE FROM `"+this.tableName+"` WHERE `"+this.tableName+"`.`id` = "+obj.getId();
        
        return this.connexion.sendQuery(sql);
    }

    /**
    * Méthode de mise à jour l'objet d'un objet du modèle AnneeScoalire dans la base de données (table annee_scoalire)
    * @param obj : l'objet à mettre à jour
    * @return boolean : true si la mise à jour a été exécutée avec succès, false sinon
    */
    @Override
    public boolean update(Enseignement obj) {
        String sql = "UPDATE `"+this.tableName+"` SET `id_classe` = '"+obj.getIdClasse()+"', `id_discipline` = '"+obj.getIdDiscipline()+"', `id_enseignant` = '"+obj.getIdEnseignant()+"' WHERE `"+this.tableName+"`.`id` = "+obj.getId();
        
        return this.connexion.sendQuery(sql);
    }

    /**
    * Méthode qui permet de rechercher une instance de la classe Modèle AnneeScoalire à partir de son id
    * @param id : l'identifiant à rechercher
    * @return Enseignement : Une instance de la classe Enseignement de l'objet à récupérer. Résultat null si id ne se trouve.
    */
    @Override
    public Enseignement findById(int id) {
        Enseignement classe = null;
        
        String sql = "SELECT * FROM `"+this.tableName+"` WHERE `"+this.tableName+"`.id = "+id+" LIMIT 1";
        
        ResultSet data = this.connexion.sendQuerySelect(sql);
        
        try {
            if (data.next()){
                classe = getObjectFromData(data);
            }
        } catch (Exception e) {
        }

        return classe;
    }

    
    /**
    * Méthode qui permet de récupérer les objets qui vérifient les critères dans la base de doonées du modèle T (table classe)
    * @return : Liste des objets dans le modèle Enseignement qui vérfient les critères
    */
    @Override
    public List<Enseignement> get(String criteres) {
        List<Enseignement> list = new ArrayList<>();
        
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
