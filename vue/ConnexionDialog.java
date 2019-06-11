/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import connexion.Connexion;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import utils.ImageUtil;

/**
 * @author CHAABANA Yanis
 * 
 * Cette classe permet d'afficher l'interface de connexion à la base de données
 * C'est une classe singleton.
 * 
 * * <br>
 * <br>
 * Source : <br>
 *     -)   https://docs.oracle.com/javase/tutorial/uiswing/index.html
 *     -)   https://docs.oracle.com/javase/tutorial/uiswing/layout/visual.html
 *     -)   https://docs.oracle.com/javase/tutorial/uiswing/layout/group.html
 *     -)   https://docs.oracle.com/javase/tutorial/uiswing/layout/groupExample.html
 * 
 */
public class ConnexionDialog extends JDialog {
    /**
     * Le singleton (attribut static : attribut de la classe) qui intialisé à null
     */
    private static ConnexionDialog singleton = null;
    
    //Les composants graphiques internes sont toujours déclarés comme attributs
    private JLabel          lServeur;
    private JLabel          lBaseDonnees;
    private JLabel          lUtilisateur;
    private JLabel          lMotDePasse;
    
    private JTextField      tfServeur;
    private JTextField      tfBaseDonnees;
    private JTextField      tfUtilisateur;
    private JPasswordField  pwfMotDePasse;
    
    private JSeparator      separator;
    private JButton         bSeConnecter;
    private JButton         bFermer;
    
    /**
     * Constructeur privé : pour interdire l'instanciation en dehors de la classe
     */
    private ConnexionDialog() {
        initUI();
        manageLayout();
        manageEvents();
    }

    /**
     * Assurer que l'instanciation est réalisée une seule fois ...
     * @return signleton
     */
    public static ConnexionDialog getSingleton() {
        if (singleton == null){
            singleton = new ConnexionDialog();
        }
        
        return singleton;
    }

    /**
     * Créer et paramétrer les composants graphiques internes de la boite de dialogue
     * <br>
     * - Instancier les composants grapiques<br>
     * - Paramétrer les composants graphiques
     */
    private void initUI(){
        lServeur = new JLabel("Adresse/Nom du Serveur : ");
        lBaseDonnees = new JLabel("Nom de la base de données : ");
        lUtilisateur = new JLabel("Utilisateur : ");
        lMotDePasse = new JLabel("Mot de passe : ");

        tfServeur = new JTextField();
        tfBaseDonnees = new JTextField();
        tfUtilisateur = new JTextField();
        pwfMotDePasse = new JPasswordField();

        separator = new JSeparator();
        bSeConnecter = new JButton("Se Connecter");
        bFermer = new JButton("   Fermer");
        
        bFermer.setIcon( ImageUtil.IC_EXIT_25_25 );
        bSeConnecter.setIcon( ImageUtil.IC_VALIDATE_25_25 );
        
        //This : l'instance en cours de la classe ConnexionDialog
        this.setTitle("Connexion à la base de données : ");
        this.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        
        //Les paramètres de connexion ....
        tfServeur.setText("localhost");
        tfBaseDonnees.setText("ecole_db");
        tfUtilisateur.setText("root");
        pwfMotDePasse.setText("");
    }
    
    /**
     * Gérer la dispostion des composants graphiques internes dans la boite de dialogue
     */
    private void manageLayout(){
        Container zoneInterne = this.getContentPane();
        
        GroupLayout layout = new GroupLayout(zoneInterne);
        zoneInterne.setLayout(layout);
        
        //Spécifier horizontalement l'interface
        layout.setHorizontalGroup( layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, Short.MAX_VALUE)
                        
                        .addGroup(layout.createParallelGroup()
                                .addComponent(lServeur)
                                .addComponent(lBaseDonnees)
                                .addComponent(lUtilisateur)
                                .addComponent(lMotDePasse)
                        )
                        .addGap(5)
                        .addGroup(layout.createParallelGroup()
                                .addComponent(tfServeur, 250, 250, 250)
                                .addComponent(tfBaseDonnees, 200, 200, 200)
                                .addComponent(tfUtilisateur, 180, 180, 180)
                                .addComponent(pwfMotDePasse, 180, 180, 180)
                        )
                        
                        .addGap(20, 20, Short.MAX_VALUE)
                )
                
                .addGroup(layout.createSequentialGroup()
                        .addGap(3)
                        .addComponent(separator, 20, 20, Short.MAX_VALUE)
                        .addGap(3)
                )
                
                .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, Short.MAX_VALUE)
                        .addComponent(bSeConnecter, 200, 200, 200)
                        .addGap(20, 20, Short.MAX_VALUE)
                        .addComponent(bFermer, 200, 200, 200)
                        .addGap(20, 20, Short.MAX_VALUE)
                )
        );
        
        //Spécifier verticalement l'interface
        layout.setVerticalGroup( layout.createSequentialGroup() 
                .addGap(5, 5, Short.MAX_VALUE)
                
                .addGroup(layout.createParallelGroup()
                        .addComponent(lServeur,25, 25, 25)
                        .addComponent(tfServeur,25, 25, 25)
                )
                .addGap(5)
                .addGroup(layout.createParallelGroup()
                        .addComponent(lBaseDonnees,25, 25, 25)
                        .addComponent(tfBaseDonnees,25, 25, 25)
                )
                .addGap(5)
                .addGroup(layout.createParallelGroup()
                        .addComponent(lUtilisateur,25, 25, 25)
                        .addComponent(tfUtilisateur,25, 25, 25)
                )
                .addGap(5)
                .addGroup(layout.createParallelGroup()
                        .addComponent(lMotDePasse,25, 25, 25)
                        .addComponent(pwfMotDePasse,25, 25, 25)
                )
                
                .addGap(10)
                .addComponent(separator, 2, 2, 2)
                .addGap(10)
                
                .addGroup(layout.createParallelGroup()
                        .addComponent(bSeConnecter ,25, 25, 25)
                        .addComponent(bFermer ,25, 25, 25)
                )
                
                .addGap(5, 5, Short.MAX_VALUE)
        );
        
        this.pack();//Empacter la fenetre (la boite de dialogue)
        this.setLocationRelativeTo(null); // Center par rapport à l'écran
        this.setResizable(false);
    }
    
    /**
     * Gérer le taraitement des évènements pour les composants graphiques internes de la boite de dialogue
     */
    private void manageEvents(){
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                bFermerActionPerformed();
            }
        });
        
        this.bFermer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                bFermerActionPerformed();
            }
        });
        
        this.bSeConnecter.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                bSeConnecterActionPerformed();
            }
        });
    }
    
    private void bFermerActionPerformed(){
        int reponse = JOptionPane.showConfirmDialog(this, "Voulez-vous quitter l'Application ? ", "Quitter ?", JOptionPane.YES_NO_OPTION);
        if ( reponse == JOptionPane.YES_OPTION ){
            System.exit(0);
        }
    }
    
    private void bSeConnecterActionPerformed(){
        String serverName = tfServeur.getText().trim();
        int    port = 3306;

        String databaseName = tfBaseDonnees.getText().trim(); //"ecole_db";
        String databaseUser = tfUtilisateur.getText().trim(); //"ecole_db_user";
        String databaseUserPassword = pwfMotDePasse.getText().trim(); //"ecole_Db_2_User_@_1";
        
        Connexion.getSingleton(serverName, port, databaseName, databaseUser, databaseUserPassword);
        
        if (Connexion.getSingleton().getConn() != null){
            this.setVisible(false);
            MainFrame.getSingleton().setVisible(true);   
        }
        else {
            JOptionPane.showMessageDialog(this, "Erreur de connexion vers la base de données : "+databaseName, "Erreur", JOptionPane.ERROR_MESSAGE);
        }
    }
}
