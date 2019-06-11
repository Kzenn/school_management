/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;

/**
 *
 * @author Famille Francois
 */
public class InvalidParameterException extends Exception {
     @Override
    public String getMessage(){
        String erreur;
        erreur = "Erreur : votre paramètre est incorrect";
        return erreur;
    }
}
