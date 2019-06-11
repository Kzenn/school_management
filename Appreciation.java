/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

/**
 *
 * @author AnissPC
 */
public class Appreciation {
    
    private double note;
    private String commentaire;
    private Matiere matiere;
    private Professeur E; 

    public Appreciation(double note, String commentaire, Matiere matiere, Professeur E) {
        this.note = note;
        this.commentaire = commentaire;
        this.matiere = matiere;
        this.E = E;
    }
    
    public double getNote() {
        return note;
    }

    public void setNote(double note) {
        this.note = note;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public Matiere getMatiere() {
        return matiere;
    }

    public void setMatiere(Matiere matiere) {
        this.matiere = matiere;
    }

    public Professeur getE() {
        return E;
    }

    public void setE(Professeur E) {
        this.E = E;
    }  
}
