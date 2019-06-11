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
import java.util.HashSet;
import java.util.Set;

public class Professeur extends Personne {
    
  //Liste des matières dispensées
  private Set<Matiere> listMatiere = new HashSet<Matiere>();

  public Professeur(int id, String nom, String prenom) {
    this.id = id;
    this.nom = nom;
    this.prenom = prenom;
  }

  public Professeur(){}

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

  public String getPrenom() {
    return prenom;
  }

  public void setPrenom(String prenom) {
    this.prenom = prenom;
  }

  public Set<Matiere> getListMatiere() {
    return listMatiere;
  }

  public void setListMatiere(Set<Matiere> listMatiere) {
    this.listMatiere = listMatiere;
  }

  //Ajoute une matière à un professeur
  public void addMatiere(Matiere matiere){
    this.listMatiere.add(matiere);
  }

  //Retire une matière à un professeur
  public void removeMatiere(Matiere matiere){
    this.listMatiere.remove(matiere);
  }
}
