/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.tests;

import connexion.Connexion;

/**
 *
 * @author redouane
 */
public class Test01_Connexion {
    public static void main(String args[]){
        String serverName = "localhost";
        int    port = 3306;

        String databaseName = "ecole_db";
        String databaseUser = "ecole_db_user";
        String databaseUserPassword = "ecole_Db_2_User_@_1";
        
        
        Connexion.getSingleton(serverName, port, databaseName, databaseUser, databaseUserPassword);
        
        System.out.println("La connexion créée : " + Connexion.getSingleton().getConn());
    }
}
