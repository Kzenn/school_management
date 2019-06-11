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

import java.sql.*;
import modele.Matiere;

public class MatiereDAO extends DAO<Matiere> {

    private Object connect;
  public MatiereDAO(Connection conn) {
    super(conn);
  }

  public boolean create(Matiere obj) {
    return false;
  }

  public boolean delete(Matiere obj) {
    return false;
  }

  public boolean update(Matiere obj) {
    return false;
  }

  public Matiere find(int id) {
    Matiere matiere = new Matiere();  

    try {
      ResultSet result;
        result = this.connect.createStatement(
                ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM matiere WHERE mat_id = " + id);
        if(result.first())
          matiere = new Matiere(id, result.getString("mat_nom"));         
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return matiere;
  }
}
