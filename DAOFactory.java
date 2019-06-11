/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import connexion.Connexion;

/**
 * Classe qui permet de construire des objets DAO
 * @author Famille Francois
 */
public class DAOFactory{
    protected static final Connexion connexion = Connexion.getSingleton();

    public static DAOAnneeScolaire getDAOAnneeScolaire(){
      return new DAOAnneeScolaire( connexion );
    }

    public static DAOBulletin getDAOBulletin(){
      return new DAOBulletin( connexion );
    }
    
    public static DAOClasse getDAOClasse(){
      return new DAOClasse( connexion );
    }
    
    public static DAODetailBulletin getDAODetailBulletin(){
      return new DAODetailBulletin( connexion );
    }
    
    public static DAODiscipline getDAODAODiscipline(){
      return new DAODiscipline( connexion );
    }
    
    public static DAOEcole getDAOEcole(){
      return new DAOEcole( connexion );
    }
    
    public static DAODiscipline getDAODiscipline(){
      return new DAODiscipline( connexion );
    }
    
    public static DAOEnseignement getDAOEnseignement(){
      return new DAOEnseignement( connexion );
    }
    
    public static DAOEvaluation getDAOEvaluation(){
      return new DAOEvaluation( connexion );
    }
    
    public static DAOInscription getDAOInscription(){
      return new DAOInscription( connexion );
    }
    
    public static DAONiveau getDAONiveau(){
      return new DAONiveau( connexion );
    }
    
    public static DAOPersonne getDAOPersonne(){
      return new DAOPersonne( connexion );
    }
    
    public static DAOTrimestre getDAOTrimestre(){
      return new DAOTrimestre( connexion );
    }
}
