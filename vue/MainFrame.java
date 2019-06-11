
package vue;

import dao.DAOFactory;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import modele.AnneeScolaire;
import modele.Ecole;
import org.jfree.chart.JFreeChart;
import utils.ImageUtil;
import utils.chart.PieChart;
import vue.fenetres.FenetreAnneeScolaire;
import vue.fenetres.FenetreEcole;
import vue.fenetres.FenetreNiveau;
import vue.fenetres.FenetreStatRepartitionMoyennes;
import vue.fenetres.FenetreStatTauxSucces;
import vue.fenetres.FenetreTrimestre;

/**
 * @author CHAABANA Yanis
 * 
 * Cette classe permet 
 * <br>
 * C'est une classe singleton.
 * 
 * <br>
 * <br>
 * Source : <br>
 *     -)   https://docs.oracle.com/javase/tutorial/uiswing/index.html
 *     -)   https://docs.oracle.com/javase/tutorial/uiswing/layout/visual.html
 *     -)   https://docs.oracle.com/javase/tutorial/uiswing/layout/group.html
 *     -)   https://docs.oracle.com/javase/tutorial/uiswing/layout/groupExample.html
 */
public class MainFrame extends JFrame {
    /**
     * Le singleton (attribut static : attribut de la classe) qui intialisé à null
     */
    private static MainFrame singleton = null;
    
    //Les composants graphiques internes sont toujours déclarés comme attributs
    
    
    private JMenuBar menuBar;
    
    private JMenu        mConfiguraiton;
    
    private JMenuItem    miEcole;
    private JMenuItem    miAnneeScolaire;
    private JMenuItem    miNiveau;
    private JMenuItem    miTrimestres;
    
    private JMenu    mEnseignement;
    
    private JMenuItem miEnsiegnant;
    private JMenuItem miClasses;
    private JMenuItem miDisciplines;
    
    private JMenu       mStatistiques;
    private JMenuItem   miRepartitionMoyennes;
    private JMenuItem   miTauxSuccessAnneeScolaire;
    
    
    private ImageIcon backgroundImage = null;
    
    private JLabel  lEcole;
    private JLabel  lAnneeScolaire;
    
    private JComboBox<Ecole>            cbEcole;
    private JComboBox<AnneeScolaire>  cbAnneeScolaire;
    
    /**
     * Constructeur privé : pour interdire l'instanciation en dehors de la classe
     */
    private MainFrame() {
        initUI();
        manageLayout();
        manageEvents();
    }

    /**
     * Assurer que l'instanciation est réalisée une seule fois ...
     * @return signleton
     */
    public static MainFrame getSingleton() {
        if (singleton == null){
            singleton = new MainFrame();
        }
        
        singleton.initData();
        
        return singleton;
    }

    /**
     * Créer et paramétrer les composants graphiques internes de la boite de dialogue
     */
    private void initUI(){
        this.creerMenu();
        
        
        lEcole = new JLabel("Ecole : ");
        lAnneeScolaire = new JLabel("Année Scolaire : ");
    
        cbEcole = new JComboBox<>();
        cbAnneeScolaire = new JComboBox<>();
        
        this.setTitle("Application de Gesiton d'une École ...");
        
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        
        this.backgroundImage = ImageUtil.getImageIconByResource("/imgs/ecole01.jpg");
    }
    
    /**
     * Créer 
     */
    private void creerMenu(){
        //Création du menu Configuration et ses éléments
        mConfiguraiton = new JMenu("Configuration");
        
        miEcole = new JMenuItem("École");
        miNiveau = new JMenuItem("Niveau");
        miAnneeScolaire = new JMenuItem("Année Scolaire");
        miTrimestres = new JMenuItem("Trimestres");
        
        mConfiguraiton.add( miEcole );
        mConfiguraiton.add( miNiveau );
        mConfiguraiton.add(miAnneeScolaire );
        mConfiguraiton.add(miTrimestres);
        
        mConfiguraiton.setIcon(ImageUtil.IC_PARAM_25_25);
        miEcole.setIcon(ImageUtil.IC_ECOLE_25_25);
        miNiveau.setIcon(ImageUtil.IC_NIVEAU_25_25);
        miAnneeScolaire.setIcon(ImageUtil.IC_ANNEE_SCOLAIRE_25_25);
        
        
        //Création du menu Enseignement ...
        mEnseignement = new JMenu("Enseignements");
    
        //Création des élements du menu Enseignement
        miEnsiegnant = new JMenuItem("Enseignants");
        miDisciplines = new JMenuItem("Disciplines");
        miClasses = new JMenuItem("Classes");
        
        //Ajout des éléments au menu Enseigmenet
        mEnseignement.add(miEnsiegnant);
        mEnseignement.add(miDisciplines);
        mEnseignement.addSeparator();
        mEnseignement.add(miClasses);
        
        mEnseignement.setIcon( ImageUtil.IC_ENSEIGNEMENT_25_25 );
        
        
        mStatistiques = new JMenu("Statistiques");
        miRepartitionMoyennes = new JMenuItem("Répartition des moyennes");
        miTauxSuccessAnneeScolaire = new JMenuItem("Taux de succès par années scolaire");
        
        mStatistiques.add(miRepartitionMoyennes);
        mStatistiques.add(miTauxSuccessAnneeScolaire);
        
        mStatistiques.setIcon( ImageUtil.IC_STATISTIQUES_25_25 );
        miRepartitionMoyennes.setIcon( ImageUtil.IC_PIE_CHART_25_25 );
        miTauxSuccessAnneeScolaire.setIcon( ImageUtil.IC_PIE_CHART_25_25 );
        
        
        
        menuBar = new JMenuBar();
        menuBar.add(mConfiguraiton);
        menuBar.add(mEnseignement);
        menuBar.add(mStatistiques);
        
        this.setJMenuBar(menuBar);
    }
    
    /**
     * Gérer la dispostion des composants graphiques internes dans la boite de dialogue
     */
    private void manageLayout(){
        Container zoneInterne = this.getContentPane();
        
        GroupLayout layout = new GroupLayout(zoneInterne);
        zoneInterne.setLayout(layout);
        
        layout.setHorizontalGroup(layout.createSequentialGroup()
                .addGap(50)
                .addComponent(lEcole)
                .addGap(5)
                .addComponent(cbEcole, 250, 250, 250)
                
                .addGap(200, 200, Short.MAX_VALUE)
                
                
                .addComponent(lAnneeScolaire)
                .addGap(5)
                .addComponent(cbAnneeScolaire, 250, 250, 250)
                .addGap(50)
        );
        
        layout.setVerticalGroup(layout.createSequentialGroup()
                .addGap(50)
                .addGroup(layout.createParallelGroup()
                        .addComponent(lEcole, 25, 25, 25)
                        .addComponent(cbEcole, 50, 50, 50)

                        .addComponent(lAnneeScolaire, 25, 25, 25)
                        .addComponent(cbAnneeScolaire, 50, 50, 50)
                )
                .addGap(500)
        );
        
        this.pack();
        this.setMinimumSize(this.getSize());
        
        //Maximiser la fenetre horizontalement et verticalment
        this.setExtendedState( JFrame.MAXIMIZED_BOTH );
    }
    
    /**
     * Gérer le taraitement des évènements pour les composants graphiques internes de la boite de dialogue
     */
    private void manageEvents(){
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                quitter();
            }
        });
        
        this.miEcole.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                miEcoleActionPerformed();
            }
        });
        
        this.miNiveau.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                miNiveauActionPerformed();
            }
        });
        
        this.miAnneeScolaire.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                miAnneeScolaireActionPerformed();
            }
        });
        
        this.miTrimestres.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                miTrimestresActionPerformed();
            }
        });
        
        this.miRepartitionMoyennes.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                miRepartitionMoyennesActionPerformed();
            }
        });
        
        this.miTauxSuccessAnneeScolaire.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                miTauxSuccessAnneeScolaireActionPerformed();
            }
        });
    }
    
    private void initData(){
        List<Ecole> listEcoles = DAOFactory.getDAOEcole().getAll();
        for (Ecole ecole : listEcoles) {
            cbEcole.addItem(ecole);
        }
        
        List<AnneeScolaire> listAnneeScolaires = DAOFactory.getDAOAnneeScolaire().getAll();
        for (AnneeScolaire anneeScolaire : listAnneeScolaires) {
            cbAnneeScolaire.addItem(anneeScolaire);
        }
    }
    
    private void quitter(){
        int reponse = JOptionPane.showConfirmDialog(this, "Voulez-vous quitter l'Application ? ", "Quitter ?", JOptionPane.YES_NO_OPTION);
        if ( reponse == JOptionPane.YES_OPTION ){
            System.exit(0);
        }
    }

    private void miEcoleActionPerformed(){
        FenetreEcole.getSingleton().setVisible(true);
    }
    
    private void miNiveauActionPerformed(){
        FenetreNiveau.getSingleton().setVisible(true);
    }
    
    private void miAnneeScolaireActionPerformed(){
        FenetreAnneeScolaire.getSingleton().setVisible(true);
    }

    private void miTrimestresActionPerformed(){
        Object item = cbAnneeScolaire.getSelectedItem();
        if (item == null){
            JOptionPane.showMessageDialog(this, "Veuillez sélectionner une année scolaire !!!", "Erreur", JOptionPane.ERROR_MESSAGE);            
            return;
        }
        
        FenetreTrimestre.getSingleton( (AnneeScolaire)item ).setVisible(true);
    }
    
    private void miRepartitionMoyennesActionPerformed(){
        Map<String, Double> mapData = new LinkedHashMap<>();
        
        mapData.put("Entre 17.75 et 20", 2.0);
        mapData.put("Entre 15.00 et 17.75", 5.0);
        mapData.put("Entre 12.25 et 15.00", 8.0);
        mapData.put("Entre 10.00 et 12.25", 11.0);
        mapData.put("Entre 07.75 et 10.00", 15.0);
        mapData.put("Entre 05.00 et 7.75", 6.0);
        mapData.put("Entre 00.00 et 05.00", 4.0);
        
        JFreeChart freeChart = PieChart.createChart3D("Répartition des Moyennes", mapData);
        
        FenetreStatRepartitionMoyennes.getSingleton( freeChart ).setVisible(true);
    }
    
     private void miTauxSuccessAnneeScolaireActionPerformed(){
        Map<String, Double> mapData = new LinkedHashMap<>();
        
        mapData.put("2011/2012", 55.00);//Le taux de succès est 55%
        mapData.put("2012/2013", 75.00);
        mapData.put("2013/2014", 60.00);
        mapData.put("2014/2015", 90.00);
        mapData.put("2015/2016", 42.33);
        
        JFreeChart freeChart = PieChart.createChart("Taux de succès par Années Scoalire", mapData);
        
         FenetreStatTauxSucces.getSingleton( freeChart ).setVisible(true);
    }
    
    /**
     * Dessiner une image de fond (background image)
     * @param g 
     */
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        
        g.drawImage(this.backgroundImage.getImage(), 50, 200, this.getWidth()-100, this.getHeight()-150, null);        
    }

    @Override
    public void paintComponents(Graphics g) {
        super.paintComponents(g); //To change body of generated methods, choose Tools | Templates.
    }
}
