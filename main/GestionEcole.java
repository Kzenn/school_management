/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import vue.ConnexionDialog;

/**
 * Le point d'entrée : elle contient la méthode main()
 * 
 * @author CHAABANA Yanis
 */
public class GestionEcole {
    public static void main(String args[]){
        ConnexionDialog connexionDlg = ConnexionDialog.getSingleton();
        
        connexionDlg.setVisible(true);
    }
}
