/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Famille Francois
 * @author cfb91
 * classe partiellement fournie sur OpenClassroom 
 * https://openclassrooms.com/fr/courses/26832-apprenez-a-programmer-en-java/26830-liez-vos-tables-avec-des-objets-java-le-pattern-dao
 */
public class Classe {
  //ID
  private int id = 0;
  //Nom du professeur
  private String nom = "";
  //Liste des professeurs
  private Set<Professeur> listeProfesseur = new HashSet<Professeur>();
  //Liste des élèves
  private Set<Eleve> listeEleve = new HashSet<Eleve>();

  public Classe(int id, String nom) {
    this.id = id;
    this.nom = nom;
  }
  public Classe(){}

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

  public Set<Professeur> getListProfesseur() {
    return listeProfesseur;
  }

  public void setListProfesseur(Set<Professeur> listeProfesseur) {
    this.listeProfesseur = listeProfesseur;
  }

  public void addProfesseur(Professeur prof) {
    if(!listeProfesseur.contains(prof))
    {
        listeProfesseur.add(prof);
    }
     
  }

  public void removeProfesseur(Professeur prof) {
    if(listeProfesseur.contains(prof))
    {
      listeProfesseur.remove(prof);  
    }
        
  }

  public Set<Eleve> getListEleve() {
    return listeEleve;
  }

  public void setListEleve(Set<Eleve> listEleve) {
    this.listeEleve = listEleve;
  }

  //Ajoute un élève à la classe
  public void addEleve(Eleve eleve){
    if(!this.listeEleve.contains(eleve))
    {
        this.listeEleve.add(eleve);
    }
      
  }

  //Retire un élève de la classe
  public void removeEleve(Eleve eleve){
    if(this.listeEleve.contains(eleve))
    {
        this.listeEleve.remove(eleve);
    }
  }

  public boolean equals(Classe cls){
    return this.getId() == cls.getId();
  }   
}
