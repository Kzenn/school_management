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
import modele.Classe;

/**
 * classe DAO qui permet d'accéder à la table : <b>classe</b>. Cette classe 
 * associe un objet modèle Classe à la table classe.<br> 
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
 * @param <Classe> : Classe est une classe du package modele (Classes Modèles)
 */
public class DAOClasse extends DAO<Classe> {
    /**
     * Constructeur de la classe
     * @param connexion : Le module de connexion qui permet d'accéder à la base de données
     */
    public DAOClasse(Connexion connexion) {
        // Créer une instance de DAOClasse avec la connexion et le nom de table : classe
        super(connexion, "classe");
    }
    
    /**
    * Cette méthode permet de retourner une instance de la classe modèle Classe à partir d'une ligne de ResultSet
    * 
    * @param data : un result set obtenu à partir d'une requête SQL Select
    * @return : une instance de type Classe
    */
    @Override
    public Classe getObjectFromData(ResultSet data){
        Classe classe = null;
        
        try{
            classe = new Classe();
                
            classe.setId(data.getInt("id"));
            classe.setNom( data.getString("nom") );
            classe.setIdEcole( data.getInt("id_ecole") );
            classe.setIdNiveau( data.getInt("id_niveau") );
            classe.setIdAnneeScolaire(data.getInt("id_annee_scolaire") );
        }
        catch(Exception e){
        }
        
        return classe;
    }

    /**
    * Méthode d'insertion d'un objet du modèle Classe dans la base de données (table classe)
    * @param obj : l'objet à insérer
    * @return boolean : true si l'insertion a été exécutée avec succès, false sinon
    */
    @Override
    public boolean insert(Classe obj) {
        String sql = "INSERT INTO `"+this.tableName+"` (`id`, `nom`, `id_ecole`, `id_niveau`, `id_annee_scolaire`) VALUES (NULL, '"+obj.getNom()+"', '"+obj.getIdEcole()+"', '"+obj.getIdNiveau()+"', '"+obj.getIdAnneeScolaire()+"')";
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
    * Méthode pour supprimer le tuple correspondant à l'objet du modèle Classe de la base de données (table classe)
    * @param obj : l'objet à supprimer
    * @return boolean : true si la suppression a été exécutée avec succès, false sinon
    */
    @Override
    public boolean delete(Classe obj) {
        String sql = "DELETE FROM `"+this.tableName+"` WHERE `"+this.tableName+"`.`id` = "+obj.getId();
        
        return this.connexion.sendQuery(sql);
    }

    /**
    * Méthode de mise à jour l'objet d'un objet du modèle AnneeScoalire dans la base de données (table annee_scoalire)
    * @param obj : l'objet à mettre à jour
    * @return boolean : true si la mise à jour a été exécutée avec succès, false sinon
    */
    @Override
    public boolean update(Classe obj) {
        String sql = "UPDATE `"+this.tableName+"` SET `nom` = '"+obj.getNom()+"', `id_ecole` = '"+obj.getIdEcole()+"', `id_niveau` = '"+obj.getIdNiveau()+"', `id_annee_scolaire` = '"+obj.getIdAnneeScolaire()+"' WHERE `"+this.tableName+"`.`id` = "+obj.getId();
        
        return this.connexion.sendQuery(sql);
    }

    /**
    * Méthode qui permet de rechercher une instance de la classe Modèle AnneeScoalire à partir de son id
    * @param id : l'identifiant à rechercher
    * @return Classe : Une instance de la classe Classe de l'objet à récupérer. Résultat null si id ne se trouve.
    */
    @Override
    public Classe findById(int id) {
        Classe classe = null;
        
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
    * @return : Liste des objets dans le modèle Classe qui vérfient les critères
    */
    @Override
    public List<Classe> get(String criteres) {
        List<Classe> list = new ArrayList<>();
        
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
