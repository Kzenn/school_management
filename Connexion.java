/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package connexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/*
 * 
 * Librairies importées
 */


/**
 * 
 * Connexion a votre BDD locale ou à distance sur le serveur de l'ECE via le tunnel SSH
 * 
 * @author segado
 */
public class Connexion {

    /**
     * Attributs prives : connexion JDBC, statement, ordre requete et resultat
     * requete
     */
    private Connection conn;
    
    
    private String serverName;
    private int port;
    private String databaseName;
    private String databaseUser; 
    private String databaseUserPassword;
    
    
    private static Connexion singleton = null;

    public static Connexion getSingleton(String serverName, int port, String databaseName, String databaseUser, String databaseUserPassword) {
        if (singleton == null){
            singleton = new Connexion(serverName, databaseName, databaseUser, databaseUserPassword, port);
        }
        else{
            singleton.serverName = serverName;
            singleton.port = port;
            singleton.databaseName = databaseName;
            singleton.databaseUser = databaseUser;
            singleton.databaseUserPassword = databaseUserPassword;
            
            //recréer la connexion ....
            singleton.creerConnexion();
        }
        
        return singleton;
    }
    
    public static Connexion getSingleton() {
        return singleton;
    }
    
    
    /**
     * Constructeur avec 4 paramètres : <br>
     *  - nom du Serveur <br>
     *  - Nom de la base données <br>
     *  - Nom de l'utilisateur <br>
     *  - Mot de passe de l'utilisateur <br>
     *
     * @param nameDatabase
     * @param loginDatabase
     * @param passwordDatabase
     * @throws java.sql.SQLException
     * @throws java.lang.ClassNotFoundException
     */
    private Connexion(String serverName, String databaseName, String databaseUser, String databaseUserPassword){
        this(serverName, databaseName, databaseUser, databaseUserPassword, 3306);
        
        
    }

    
   /**
     * Constructeur avec 5 paramètres : <br>
     *  - nom du Serveur <br>
     *  - Nom de la base données <br>
     *  - Nom de l'utilisateur <br>
     *  - Mot de passe de l'utilisateur <br>
     *
     * @param nameDatabase
     * @param loginDatabase
     * @param passwordDatabase
     * @throws java.sql.SQLException
     * @throws java.lang.ClassNotFoundException
     */
    private Connexion(String serverName, String databaseName, String databaseUser, String databaseUserPassword, int port) {
        this.serverName = serverName;
        this.port = port;
        this.databaseName = databaseName;
        this.databaseUser = databaseUser;
        this.databaseUserPassword = databaseUserPassword;
        

        creerConnexion();
    }
    
    private void creerConnexion(){
        try {
            this.conn = null;
            
            // chargement driver "com.mysql.jdbc.Driver"
            //Class.forName("com.mysql.jdbc.Driver");
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // url de connexion "jdbc:mysql://localhost:3305/usernameECE"
            String urlDatabase = "jdbc:mysql://"+this.serverName+":"+this.port+"/" + this.databaseName+"?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC";

            //création d'une connexion JDBC à la base 
            conn = DriverManager.getConnection(urlDatabase, this.databaseUser, this.databaseUserPassword);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Connection getConn() {
        return conn;
    }
    
    /**
     * Pour envoyer des requêtes SQL pour : Update, Delete et Insert ...
     * @param sqlQuery
     * @return 
     */
    public boolean sendQuery(String sqlQuery){
        boolean result = true;
        
        try{
            Statement stmt = this.conn.createStatement();

            stmt.execute(sqlQuery);
//            stmt.close();
            
        }catch(Exception e){
            result = false;
            e.printStackTrace();
        }
        
        return result;
    }
    
    /**
     * Pour des requêtes SQL pour : Select
     * @param sqlSelectQuery : requete SQL Select
     * @return  : les données récupérées à partir de la base de données ...
     */
    public ResultSet sendQuerySelect(String sqlSelectQuery){
        ResultSet data = null;
        
        try{
            Statement stmt = this.conn.createStatement();
            data = stmt.executeQuery(sqlSelectQuery);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        
        return data;
    }
}
