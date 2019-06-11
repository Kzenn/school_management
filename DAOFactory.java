/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;

import java.sql.Connection;

/**
 *
 * @author Famille Francois
 */
public class DAOFactory extends AbstractDAOFactory{
  protected static final Connection conn = SdzConnection.getInstance();   

  public DAO getClasseDAO(){
    return new ClasseDAO(conn);
  }

  public DAO getProfesseurDAO(){
    return new ProfesseurDAO(conn);
  }

  public DAO getEleveDAO(){
    return new EleveDAO(conn);
  }

  public DAO getMatiereDAO(){
    return new MatiereDAO(conn);
  }
  
  public DAO getAnneeScolaireDAO(){
    return new MatiereDAO(conn);
  }
  
  public DAO getSemesterDAO(){
    return new MatiereDAO(conn);
  }
  
  public DAO getEvaluationDAO(){
    return new MatiereDAO(conn);
  }
  
  public DAO getBulletinDAO(){
    return new MatiereDAO(conn);
  }
}
