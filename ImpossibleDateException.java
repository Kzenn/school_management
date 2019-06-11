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
public class ImpossibleDateException extends Exception{
    @Override
    public String getMessage(){
        String erreur;
        erreur = "Erreur : la timeline imposée ne convient pas";
        return erreur;
    }
}
