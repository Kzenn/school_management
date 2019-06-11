/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

/**
 *
 * @author Famille Francois
 * classe partiellement fournie sur OpenClassroom 
 * https://openclassrooms.com/fr/courses/26832-apprenez-a-programmer-en-java/26830-liez-vos-tables-avec-des-objets-java-le-pattern-dao
 */
public class Matiere {
  //ID
  private int id;
  //Nom du professeur
  private String nom;

  public Matiere(int id, String nom) {
    this.id = id;
    this.nom = nom;
  }

  public Matiere(){
      this.id = 0;
      this.nom = "";
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getNom() {
    return nom;
  }

  public void setNom(String nom) {
    this.nom = nom;
  }   
}
