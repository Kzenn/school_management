
package vue;

import javax.swing.JFrame;

/**
 * @author CHAABANA Yanis
 * 
 * Cette classe permet 
 * <br>
 * C'est une classe singleton.
 */
public class AAAA_Modele extends JFrame {
    /**
     * Le singleton (attribut static : attribut de la classe) qui intialisé à null
     */
    private static AAAA_Modele singleton = null;
    
    //Les composants graphiques internes sont toujours déclarés comme attributs
    
    
    /**
     * Constructeur privé : pour interdire l'instanciation en dehors de la classe
     */
    private AAAA_Modele() {
        initUI();
        manageLayout();
        manageEvents();
    }

    /**
     * Assurer que l'instanciation est réalisée une seule fois ...
     * @return signleton
     */
    public static AAAA_Modele getSingleton() {
        if (singleton == null){
            singleton = new AAAA_Modele();
        }
        
        return singleton;
    }

    /**
     * Créer et paramétrer les composants graphiques internes de la boite de dialogue
     */
    private void initUI(){
        
    }
    
    /**
     * Gérer la dispostion des composants graphiques internes dans la boite de dialogue
     */
    private void manageLayout(){
        
    }
    
    /**
     * Gérer le taraitement des évènements pour les composants graphiques internes de la boite de dialogue
     */
    private void manageEvents(){
        
    }
}
