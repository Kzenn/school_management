/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.util.ArrayList;

public class Bulletin {
    
    private  ArrayList<Appreciation> list;
    private Eleve e;
    private Semester tri;
    
     public Bulletin()
    {
        e = new Eleve();
        tri = new Semester();
        list= new ArrayList<Appreciation>();
    }
    
    public Bulletin(ArrayList<Appreciation> list, Eleve e, Semester tri)
    {
        this.list = list;
        this.e = e;
        this.tri = tri;
    } 
    
    public ArrayList<Appreciation> getList() {
        return list;
    }

    public void setList(ArrayList<Appreciation> list) {
        this.list = list;
    }

    public Eleve getE() {
        return e;
    }

    public void setE(Eleve e) {
        this.e = e;
    }

    public Semester getTri() {
        return tri;
    }

    public void setTri(Semester tri) {
        this.tri = tri;
    }    
}