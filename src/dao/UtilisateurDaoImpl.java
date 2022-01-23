package dao;

import java.sql.*;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import beans.Utilisateur;

public class UtilisateurDaoImpl implements UtilisateurDao {
    private DaoFactory daoFactory;
    private AlbumDao albumDao;

    UtilisateurDaoImpl(DaoFactory daoFactory) {
        this.daoFactory = daoFactory;
      
		this.albumDao = daoFactory.getAlbumDao();
    }

    @Override
    public int inscrire(Utilisateur utilisateur) {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        

        try {
            connexion = daoFactory.getConnection();
            preparedStatement=connexion.prepareStatement("SELECT * FROM user WHERE login=? "); //sql select query
            preparedStatement.setString(1,utilisateur.getLogin()); 
            ResultSet rs=preparedStatement.executeQuery(); //execute query and set in ResultSet object "rs".
            
            if(rs.next())
            {
                String checkEmail=rs.getString("login");
                
                if(utilisateur.getLogin().equals(checkEmail))    //check condition email already exist from user email
                {   
                	return 2;
                }
            }else {
            	  preparedStatement = connexion.prepareStatement("INSERT INTO user(nom, prenom,login,password) VALUES(?, ?, ?, ?);");
                  preparedStatement.setString(1, utilisateur.getNom());
                  preparedStatement.setString(2, utilisateur.getPrenom());
                  preparedStatement.setString(3, utilisateur.getLogin());
                  preparedStatement.setString(4, utilisateur.getPassword());
           
                  preparedStatement.executeUpdate();
                  return 1;
            }
           
          
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
        //preparedStatement.close();  //close statement 
        //connexion.close(); //close connection
		return 0;
    }
    
    public Utilisateur connecter(Utilisateur utilisateur) {
    	   Connection connexion = null;
           PreparedStatement preparedStatement = null;
           

           try {
               connexion = daoFactory.getConnection();
                preparedStatement=connexion.prepareStatement("SELECT * FROM user WHERE login=? AND password=? "); //sql select query
                preparedStatement.setString(1,utilisateur.getLogin());
                preparedStatement.setString(2,utilisateur.getPassword());    //set above all variable
              
           ResultSet rs=preparedStatement.executeQuery()
        		   ; //execute query and set in ResultSet object " rs". if(rs.next()) {
           if(rs.next()) {
        	   String dbLogin=rs.getString("login"); 
               String dbPassword=rs.getString("password"); //fetch MySQL database record
               
               if(dbLogin.equals(utilisateur.getLogin()) && dbPassword.equals(utilisateur.getPassword()) ) {
            	
            	  utilisateur.setId(rs.getInt("idUser"));
            	  utilisateur.setNom(rs.getString("nom"));
            	  utilisateur.setPrenom(rs.getString("prenom"));
            		
            	  return utilisateur;
               }
            	  
           }
           
           return null;
           
    }
     catch (SQLException e) {
        e.printStackTrace();
        return null;
    }
    }
    public void creerSession(HttpServletRequest request ) {}
    

    @Override
    public ArrayList<Utilisateur> lister() {
    	ArrayList<Utilisateur> utilisateurs = new ArrayList<Utilisateur>();
        Connection connexion = null;
        Statement statement = null;
        ResultSet resultat = null;

        try {
            connexion = daoFactory.getConnection();
            statement = connexion.createStatement();
            resultat = statement.executeQuery("SELECT idUser,nom, prenom FROM user;");

            while (resultat.next()) {
                String nom = resultat.getString("nom");
                String prenom = resultat.getString("prenom");
                int idUser= resultat.getInt("idUser");
                Utilisateur utilisateur = new Utilisateur();
                utilisateur.setNom(nom);
                utilisateur.setPrenom(prenom);
                utilisateur.setId(idUser);  
                utilisateur.setAlbums(albumDao.lister(utilisateur.getId()));

                utilisateurs.add(utilisateur);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return utilisateurs;
    }
    
}