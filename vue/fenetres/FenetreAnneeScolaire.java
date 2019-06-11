
package vue.fenetres;

import dao.DAOAnneeScolaire;
import dao.DAOFactory;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import modele.AnneeScolaire;
import utils.ImageUtil;

/**
 * @author CHAABANA Yanis
 * 
 * Cette classe permet 
 * <br>
 * C'est une classe singleton.
 * 
 * * <br>
 * <br>
 * Source : <br>
 *     -)   https://docs.oracle.com/javase/tutorial/uiswing/index.html
 *     -)   https://docs.oracle.com/javase/tutorial/uiswing/layout/visual.html
 *     -)   https://docs.oracle.com/javase/tutorial/uiswing/layout/group.html
 *     -)   https://docs.oracle.com/javase/tutorial/uiswing/layout/groupExample.html
 */
public class FenetreAnneeScolaire extends JFrame {
    /**
     * Le singleton (attribut static : attribut de la classe) qui intialisé à null
     */
    private static FenetreAnneeScolaire singleton = null;
    
    private static DAOAnneeScolaire dao = DAOFactory.getDAOAnneeScolaire();
    
    private AnneeScolaire selectedItem = null;
    
    //Les composants graphiques internes sont toujours déclarés comme attributs
    
    private JPanel pEntete;
    private JPanel pCoteDroite;
    private JPanel pFormulaire;
    private JPanel pPied;
    
    private JLabel  lEntete;
    
    private JButton         bAjouter;
    private JButton         bSupprimer;
    private JButton         bRechercher;
    private JTextField      tfRecherche;
    private JSeparator      sepBouttonsListe;
    
    private JList<AnneeScolaire> listAnneeScolaires;
    private DefaultListModel<AnneeScolaire> dlmAnneeScolaire;
    private JScrollPane     spListAnneeScolaire;
    
    private JButton bFermer;
    private JButton bValider;
    
    
    private JLabel      lAnnee;
    
    private JTextField  tfAnnee;
    
    /**
     * Constructeur privé : pour interdire l'instanciation en dehors de la classe
     */
    private FenetreAnneeScolaire() {
        initUI();
        manageLayout();
        manageEvents();
    }

    /**
     * Assurer que l'instanciation est réalisée une seule fois ...
     * @return signleton
     */
    public static FenetreAnneeScolaire getSingleton() {
        if (singleton == null){
            singleton = new FenetreAnneeScolaire();
        }
        
        singleton.initData();
        
        return singleton;
    }

    /**
     * Créer et paramétrer les composants graphiques internes de la boite de dialogue
     */
    private void initUI(){
        pEntete = new JPanel();
        pEntete.setBorder(BorderFactory.createEtchedBorder());
        
        pCoteDroite = new JPanel();
        pCoteDroite.setBorder(BorderFactory.createEtchedBorder());
        
        
        pFormulaire = new JPanel();
        pFormulaire.setBorder(BorderFactory.createEtchedBorder());
        
        
        pPied = new JPanel();
        pPied.setBorder(BorderFactory.createEtchedBorder());

        lEntete = new JLabel("Gestion des informations des Années Scolaires");
        lEntete.setFont( lEntete.getFont().deriveFont((float)20.0) );

        bAjouter = new JButton( ImageUtil.IC_AJOUTER_25_25 );
        bAjouter.setToolTipText("Ajouter une nouvelle année scolaire");
        
        bSupprimer = new JButton( ImageUtil.IC_SUPPRIMER_25_25 );
        bSupprimer.setToolTipText("Supprimer l'année scoalire sélectionnée");
        
        bRechercher = new JButton( ImageUtil.IC_RCHERCHER_25_25 );
        bSupprimer.setToolTipText("Rechercher une année scoalire");
        
        tfRecherche = new JTextField();
        sepBouttonsListe = new JSeparator();
        
        dlmAnneeScolaire = new DefaultListModel<>();
        listAnneeScolaires = new JList(dlmAnneeScolaire);
        spListAnneeScolaire = new JScrollPane(listAnneeScolaires);

        bFermer = new JButton("Fermer");
        bValider = new JButton("Valider");
                
        bFermer.setIcon( ImageUtil.IC_EXIT_25_25 );
        bValider.setIcon( ImageUtil.IC_VALIDATE_25_25 );
        
        lAnnee = new JLabel("Année : ");

        tfAnnee = new JTextField();
        
        this.setAlwaysOnTop(true);
    }
    
    /**
     * Gérer la dispostion des composants graphiques internes dans la boite de dialogue
     */
    private void manageLayout(){
        //Gestion de disposition du panel pEntete
        GroupLayout layoutPEntete = new GroupLayout(pEntete);
        pEntete.setLayout(layoutPEntete);
        layoutPEntete.setHorizontalGroup(layoutPEntete.createSequentialGroup()
                .addGap(10, 10, Short.MAX_VALUE)
                .addComponent(lEntete)
                .addGap(10, 10, Short.MAX_VALUE)
        );
        layoutPEntete.setVerticalGroup(layoutPEntete.createSequentialGroup()
                .addGap(10, 10, Short.MAX_VALUE)
                .addComponent(lEntete)
                .addGap(10, 10, Short.MAX_VALUE)
        );
        
        //Gestion de disposition du panel pPied
        GroupLayout layoutPPied = new GroupLayout(pPied);
        pPied.setLayout(layoutPPied);
        layoutPPied.setHorizontalGroup(layoutPPied.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(bFermer, 200, 200, 200)
                .addGap(10, 10, Short.MAX_VALUE)
                .addComponent(bValider, 200, 200, 200)
                .addGap(10, 10, 10)
        );
        layoutPPied.setVerticalGroup(layoutPPied.createSequentialGroup()
                .addGap(10, 10, Short.MAX_VALUE)
                .addGroup(layoutPPied.createParallelGroup()
                        .addComponent(bFermer, 30, 30, 30)
                        .addComponent(bValider, 30, 30, 30)
                )
                .addGap(10, 10, Short.MAX_VALUE)
        );
        
        //Gestion de disposition du panel pCoteDroite
        GroupLayout layoutPCoteDroite = new GroupLayout(pCoteDroite);
        pCoteDroite.setLayout(layoutPCoteDroite);
        layoutPCoteDroite.setHorizontalGroup(layoutPCoteDroite.createParallelGroup()
                .addGroup(layoutPCoteDroite.createSequentialGroup()
                        .addGap(5)
                        .addComponent(tfRecherche, 100, 100, Short.MAX_VALUE)
                        .addComponent(bRechercher, 25, 25, 25)
                        .addComponent(bAjouter, 25, 25, 25)
                        .addComponent(bSupprimer, 25, 25, 25)
                        .addGap(5)
                )
                .addGroup(layoutPCoteDroite.createSequentialGroup()
                        .addGap(2)
                        .addComponent(sepBouttonsListe, 100, 100, Short.MAX_VALUE)
                        .addGap(2)
                )
                .addGroup(layoutPCoteDroite.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(layoutPCoteDroite.createParallelGroup()
                                .addComponent(spListAnneeScolaire, 100, 100, Short.MAX_VALUE)
                        )
                        .addGap(3, 3, 3)
                )
        );
        layoutPCoteDroite.setVerticalGroup(layoutPCoteDroite.createSequentialGroup()
                .addGap(3, 3, 3)
                .addGroup(layoutPCoteDroite.createParallelGroup()
                        .addComponent(tfRecherche, 25, 25, 25)
                        .addComponent(bRechercher, 25, 25, 25)
                        .addComponent(bAjouter, 25, 25, 25)
                        .addComponent(bSupprimer, 25, 25, 25)
                )
                .addGap(3)
                .addComponent(sepBouttonsListe, 2, 2, 2)
                .addGap(3)
                .addComponent(spListAnneeScolaire, 100, 100, Short.MAX_VALUE)
                .addGap(3, 3, 3)
        );
        
        
        //Gestion de disposition du panel pFormulaire
        GroupLayout layoutPFormulaire = new GroupLayout(pFormulaire);
        pFormulaire.setLayout(layoutPFormulaire);
        layoutPFormulaire.setHorizontalGroup(layoutPFormulaire.createSequentialGroup()
                .addGap(10, 10, Short.MAX_VALUE)
                .addGroup(layoutPFormulaire.createParallelGroup()
                        .addComponent(lAnnee)
                )
                .addGap(10)
                .addGroup(layoutPFormulaire.createParallelGroup()
                        .addComponent(tfAnnee, 200, 200, 200)
                )
                .addGap(10, 10, Short.MAX_VALUE)
        );
        layoutPFormulaire.setVerticalGroup(layoutPFormulaire.createSequentialGroup()
                .addGap(10, 10, Short.MAX_VALUE)
                .addGroup(layoutPFormulaire.createParallelGroup()
                        .addComponent(lAnnee, 25, 25, 25)
                        .addComponent(tfAnnee, 25, 25, 25)
                )
                .addGap(10, 10, Short.MAX_VALUE)
        );
        
        
        //La gestion de dispoisiton de toute la zone interne de la fêntre
        Container zoneInterne = this.getContentPane();
        
        GroupLayout layout = new GroupLayout(zoneInterne);
        zoneInterne.setLayout(layout);
        
        layout.setHorizontalGroup(layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                        .addGap(3)
                        .addComponent(pEntete, 500, 500, Short.MAX_VALUE)
                        .addGap(3)
                )
                
                .addGroup(layout.createSequentialGroup()
                        .addGap(3)
                        .addComponent(pCoteDroite, 300, 300, 300)
                        .addGap(10)
                        .addComponent(pFormulaire, 700, 700, Short.MAX_VALUE)
                        .addGap(3)
                )
                .addGroup(layout.createSequentialGroup()
                        .addGap(3)
                        .addComponent(pPied, 500, 500, Short.MAX_VALUE)
                        .addGap(3)
                )
        );
        
        layout.setVerticalGroup(layout.createSequentialGroup()
                .addGap(3)
                .addComponent(pEntete, 75, 75, 75)
                
                .addGroup(layout.createParallelGroup()
                        .addComponent(pCoteDroite, 300, 300, Short.MAX_VALUE)
                        .addComponent(pFormulaire, 300, 300, Short.MAX_VALUE)
                )
                
                .addComponent(pPied, 75, 75, 75)
                .addGap(3)
        );
        
        this.pack();
        this.setMinimumSize(this.getSize());
        
        this.setLocationRelativeTo(null);
    }
    
    /**
     * Gérer le taraitement des évènements pour les composants graphiques internes de la boite de dialogue
     */
    private void manageEvents(){
        this.bFermer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                bFermerActionPerformed();
            }
        });
        
        this.bValider.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                bValiderActionPerformed();
            }
        });
        
        this.listAnneeScolaires.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                listAnneeScolaireMouseClicked();
            }
        });
        
        this.bAjouter.addActionListener( new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                bAjouterActionPerformed();
            }
        });
        
        this.bSupprimer.addActionListener( new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                bSupprimerActionPerformed();
            }
        });
        
        this.tfRecherche.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == 10){//10 est le code ASCII de la touche ENTREE ..
                    bRechercherActionPerformed();
                }
            }
        });
                
        this.bRechercher.addActionListener( new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                bRechercherActionPerformed();
            }
        });
    }
    
    /**
     * Intisialise le champs de recherche à vide et relance la récupération de données....
     */
    private void initData(){
        this.tfRecherche.setText("");
        getData();
    }
    
    /**
     * Avoir la liste des années scoalires qui sont enregistrées dans la base de données
     */
    private void getData(){
        dlmAnneeScolaire.clear();
        
        String condition = "1";
        String txtRecherche = tfRecherche.getText().trim();
        if (!txtRecherche.equals("")){
            condition = " `annee` like '"+txtRecherche+"%'";
        }
        
        List<AnneeScolaire> listAnneeScolaire = dao.get(condition);
        
        for (AnneeScolaire anneeScolaire : listAnneeScolaire){
            dlmAnneeScolaire.addElement(anneeScolaire);
        }
        
        fillForm(null);
    }
    
    /**
     * Pour vider les champs du formulaire
     */
    private void emptyForm(){
        this.tfAnnee.setText("");
    }
    
    /**
     * Pour activer ou désactivier les champs du formulaire 
     * @param enabled : true pour activer et false pour désactiver
     */
    private void setEnabledForm(boolean enabled){
        this.lAnnee.setEnabled(enabled);
        
        this.tfAnnee.setEnabled(enabled);
        
        this.bValider.setEnabled(enabled);
    }
    
    /**
     * Pour remplir le formulaire par les informations de l'année scoalire
     * @param anneeScolaire : année scoalire à consulter ...
     */
    private void fillForm(AnneeScolaire anneeScolaire){
        if (anneeScolaire == null){
            emptyForm();
            setEnabledForm(false);
            
            return;
        }
        
        setEnabledForm(true);
        
        this.tfAnnee.setText( anneeScolaire.getAnnee()+"" );
        
        this.tfAnnee.requestFocus();
    }
    
    private void bFermerActionPerformed(){
        this.setVisible(false);
    }
    
    private void bValiderActionPerformed(){
        if (selectedItem == null){
            return;
        }
        
        String strAnnee = tfAnnee.getText().trim();
        
        if (strAnnee.equals("")){
            JOptionPane.showMessageDialog(this, "Veuillez remplir tous les champs !!!!", "Champs vides", JOptionPane.ERROR_MESSAGE);
            
            tfAnnee.requestFocus();
            
            return;
        }
        
        int annee = -1;
        try{
            annee = Integer.parseInt(strAnnee);
        }
        catch(Exception e) {
            JOptionPane.showMessageDialog(this, "Veuillez une valeur valide de l'année", "Champs invalide", JOptionPane.ERROR_MESSAGE);
            
            tfAnnee.requestFocus();
            return;
        }
        
        //Modifier l'objet
        selectedItem.setAnnee(annee);
        
        if (selectedItem.getId() > 0){
            //Mettre à jour l'objet ...
            dao.update(selectedItem);
            listAnneeScolaires.updateUI();
        }
        else{
            dao.insert( selectedItem );
            dlmAnneeScolaire.addElement(selectedItem);
        }
    }
    
    private void listAnneeScolaireMouseClicked(){
        selectedItem = listAnneeScolaires.getSelectedValue();
        fillForm(selectedItem);
    }
    
    private void bAjouterActionPerformed(){
        selectedItem = new AnneeScolaire();
        fillForm(selectedItem);
    }
    
    private void bSupprimerActionPerformed(){
        if (selectedItem == null){
            return;
        }
        
        int reponse = JOptionPane.showConfirmDialog(this, "Voullez-vous supprimer cet Année Scolaire ?", "Supprimer ?", JOptionPane.YES_NO_OPTION);
        if (reponse == JOptionPane.YES_OPTION){
            dao.delete(selectedItem);
        
            dlmAnneeScolaire.removeElement(selectedItem);
            fillForm( null );   
        }
    }
    
    private void bRechercherActionPerformed(){
        getData();
    }
}
