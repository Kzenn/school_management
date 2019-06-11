/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.tests;

import connexion.Connexion;
import dao.DAOAnneeScolaire;

import dao.DAOFactory;
import java.util.List;
import modele.AnneeScolaire;

/**
 *
 * @author redouane
 */
public class Test02_DAOAnneeScolaire {
    public static void main(String args[]){
        //Créer une instance de connexion avec les paramètres spécifiés
        Connexion.getSingleton("localhost", 3306, "ecole_db", "ecole_db_user", "ecole_Db_2_User_@_1");
        DAOAnneeScolaire DAOAs = DAOFactory.getDAOAnneeScolaire();
        
//        AnneeScolaire as = new AnneeScolaire(0, 2011);
        
//        boolean ok = DAOAs.insert(as);
//        System.out.println("Insertion : "+ok);
         

//        int id = 7;
//        AnneeScolaire as = DAOAs.findById(id);
//        if (as != null){
//            System.out.println("ID = "+id+"  :  "+as.getAnnee());    
//            
//            DAOAs.delete( as );
//        }
//        else{
//            System.err.println("Année Universitaire avec ID = "+id+" n'existe pas ...");
//        }


        List<AnneeScolaire> list = DAOAs.get("1 ORDER BY annee DESC");
        
        for (AnneeScolaire as : list){
            System.out.println(as.getId() + "  " + as.getAnnee());
        }
    }
}
