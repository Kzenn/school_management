/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;


import connexion.Connexion;
import java.sql.ResultSet;
import java.util.List;

/**
 * Classe abstraite DAO qui permet d'accéder à une table. Cette classe 
 * associe un objet modèle (classes modèles) à une/plusieurs tables.<br> 
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
 * @param <T> : T est une classe du package modele (Classes Modèles)
 */
public abstract class DAO<T> {
  protected Connexion connexion = null;
   
  protected String tableName = null;
  
  /**
   * 
   * @param connexion : objet qui permet de se connecter à la base de données (Module de connexion)
   * @param tableName : nom de la table à utliser pour la classe T
   */
  public DAO(Connexion connexion, String tableName){
    this.connexion = connexion;
    this.tableName = tableName;
  }
  
  /**
   * Cette méthode permet de retourner une instance de Type T à partir d'une ligne de ResultSet
   * 
   * @param data : un result set obtenu à partir d'une requête SQL Select
   * @return : une instance de type T
   */
  public abstract T getObjectFromData(ResultSet data);
   
  /**
  * Méthode d'insertion d'un objet du modèle T dans la base de données (table tableName)
  * @param obj : l'objet à insérer
  * @return boolean : true si l'insertion a été exécutée avec succès, false sinon
  */
  public abstract boolean insert(T obj);

  /**
  * Méthode pour supprimer le tuple correspondant à l'objet du modèle T de la base de données (table tableName)
  * @param obj : l'objet à supprimer
  * @return boolean : true si la suppression a été exécutée avec succès, false sinon
  */
  public abstract boolean delete(T obj);

  /**
  * Méthode de mise à jour l'objet d'un objet du modèle T dans la base de données (table tableName)
  * @param obj : l'objet à mettre à jour
  * @return boolean : true si la mise à jour a été exécutée avec succès, false sinon
  */
  public abstract boolean update(T obj);

  /**
  * Méthode qui permet de rechercher une instance de la classe Modèle T à partir de son id
  * @param id : l'identifiant à rechercher
  * @return T : Une instance de la classe de l'objet à récupérer. Résultat null si id ne se trouve.
  */
  public abstract T findById(int id);
  
  /**
   * Méthode qui permet de récupérer tous les objets enregistrés dans la base de doonées du modèle T (table tableName)
   * @return : Liste de tous les objets enregistrés
   */
  public List<T> getAll(){
      return this.get("1");
  }
  
  /**
   * Méthode qui permet de récupérer les objets qui vérifient les critères dans la base de doonées du modèle T (table tableName)
   * @return : Liste des objets dans le modèle T qui vérfient les critères
   */
  public abstract List<T> get(String criteres);
}