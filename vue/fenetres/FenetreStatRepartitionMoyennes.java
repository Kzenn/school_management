
package vue.fenetres;

import java.awt.Container;
import javax.swing.GroupLayout;
import javax.swing.JFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;

/**
 * @author CHAABANA Yanis
 * 
 * Cette classe permet d'afficher des secteur concernant la répartition des moyennes
 * <br>
 * C'est une classe singleton.
 */
public class FenetreStatRepartitionMoyennes extends JFrame {
    /**
     * Le singleton (attribut static : attribut de la classe) qui intialisé à null
     */
    private static FenetreStatRepartitionMoyennes singleton = null;
    
    //Les composants graphiques internes sont toujours déclarés comme attributs
    
    private ChartPanel chartPanel = null;
    
    /**
     * Constructeur privé : pour interdire l'instanciation en dehors de la classe
     */
    private FenetreStatRepartitionMoyennes() {
        initUI();
        manageLayout();
        manageEvents();
    }

    /**
     * Assurer que l'instanciation est réalisée une seule fois ...
     * @return signleton
     */
    public static FenetreStatRepartitionMoyennes getSingleton(JFreeChart freeChart) {
        if (singleton == null){
            singleton = new FenetreStatRepartitionMoyennes();
        }
        
        singleton.updateFreeChart(freeChart);
        
        return singleton;
    }

    /**
     * Créer et paramétrer les composants graphiques internes de la boite de dialogue
     */
    private void initUI(){
        this.setTitle("Statistiques : Répartition des élèves par rapport à leurs moyennes");
        this.setAlwaysOnTop(true);
    }
    
    /**
     * Gérer la dispostion des composants graphiques internes dans la boite de dialogue
     */
    private void manageLayout(){
        this.getContentPane().removeAll();
        
        Container zoneInterne = this.getContentPane();
        
        GroupLayout layout = new GroupLayout( zoneInterne );
        zoneInterne.setLayout( layout );
        
        layout.setHorizontalGroup(layout.createSequentialGroup()
        
        );
        
        layout.setVerticalGroup(layout.createSequentialGroup()
        
        );
    }
    
    private void updateLayout(){
        Container zoneInterne = this.getContentPane();
        GroupLayout layout = (GroupLayout)zoneInterne.getLayout();
        
        layout.setHorizontalGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(chartPanel, 700, 700, Short.MAX_VALUE)
                .addGap(20, 20, 20)
        );
        
        layout.setVerticalGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(chartPanel, 500, 500, Short.MAX_VALUE)
                .addGap(20, 20, 20)
        );
        
        this.pack();
        this.setMinimumSize(this.getSize());
    }
    
    private void updateFreeChart(JFreeChart freeChart){
        this.chartPanel =  new ChartPanel(freeChart);
        this.updateLayout();
    }
    
    /**
     * Gérer le taraitement des évènements pour les composants graphiques internes de la boite de dialogue
     */
    private void manageEvents(){
        
    }
}
