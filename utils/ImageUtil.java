/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author redouane
 */
public class ImageUtil {
    public static ImageIcon scalImageIcon (ImageIcon imageIcon, int width, int height){
        Image image = imageIcon.getImage(); // transform it 
        Image newimg = image.getScaledInstance(width, height,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
        imageIcon = new ImageIcon(newimg);  // transform it back
        
        return imageIcon;
    }
    
    public static ImageIcon getImageIconByResource(String pathImage){
        return new ImageIcon(Class.class.getResource(pathImage));
    }
    
    public static ImageIcon getImageIconByResource(String pathImage, int width, int height){
        ImageIcon ic = new ImageIcon(Class.class.getResource(pathImage));
        
        return scalImageIcon(ic, width, height);
    }
    
    //Constantes ImageIcon
    public static final ImageIcon IC_PARAM_25_25 = ImageUtil.getImageIconByResource("/imgs/parametres.png", 25, 25);
    
    public static final ImageIcon IC_ECOLE_25_25 = ImageUtil.getImageIconByResource("/imgs/ecole.png", 25, 25);
    public static final ImageIcon IC_NIVEAU_25_25 = ImageUtil.getImageIconByResource("/imgs/niveau.png", 25, 25);
    public static final ImageIcon IC_ANNEE_SCOLAIRE_25_25 = ImageUtil.getImageIconByResource("/imgs/anneeScolaire.png", 25, 25);
    public static final ImageIcon IC_ENSEIGNEMENT_25_25 = ImageUtil.getImageIconByResource("/imgs/enseignement.png", 25, 25);
    public static final ImageIcon IC_STATISTIQUES_25_25 = ImageUtil.getImageIconByResource("/imgs/statistiques.png", 25, 25);
    public static final ImageIcon IC_PIE_CHART_25_25 = ImageUtil.getImageIconByResource("/imgs/pie-chart.png", 25, 25);
    
    public static final ImageIcon IC_TRIMESTRE_25_25 = ImageUtil.getImageIconByResource("/imgs/parametres.png", 25, 25);
    
    public static final ImageIcon IC_EXIT_25_25 = ImageUtil.getImageIconByResource("/imgs/exit.png", 25, 25);
    
    public static final ImageIcon IC_VALIDATE_25_25 = ImageUtil.getImageIconByResource("/imgs/validate.png", 25, 25);
    
    public static final ImageIcon IC_AJOUTER_25_25 = ImageUtil.getImageIconByResource("/imgs/ajouter.png", 25, 25);
    public static final ImageIcon IC_SUPPRIMER_25_25 = ImageUtil.getImageIconByResource("/imgs/supprimer.png", 25, 25);
    public static final ImageIcon IC_RCHERCHER_25_25 = ImageUtil.getImageIconByResource("/imgs/rechercher.png", 25, 25);
}
