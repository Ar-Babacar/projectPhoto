package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import beans.Album;

public class AlbumDaoImpl implements AlbumDao {

	private DaoFactory daoFactory;
    private ImageDao imageDao;
	public AlbumDaoImpl(DaoFactory daoFactory) {
		this.daoFactory = daoFactory;
		this.imageDao = daoFactory.getImageDao();
	}
	  @Override
	    public Album ajouter(Album album) {
	    	  Connection connexion = null;
	          PreparedStatement preparedStatement = null;
	       
	   
	    		try {
	    			  connexion = daoFactory.getConnection();
	    			  
					String query="Insert into album(NomAlbum,statut,theme,User_idUser,description) values(?,?,?,?,?);";
	    			preparedStatement=connexion.prepareStatement(query);
	    			preparedStatement.setString(1,album.getNom());
	    			preparedStatement.setBoolean(2, album.isPrivate());
	    			preparedStatement.setString(3,album.getTheme());
	    			preparedStatement.setInt(4,album.getUserID());
	    			preparedStatement.setString(5,album.getDescription());
	    	
	    			int row =preparedStatement.executeUpdate(); //nbr de row affectes a la base

	    			if(row>0)
	    			{
	    				System.out.println("ajout effectue avec succes");
	    				Statement statement = connexion.createStatement();
	    
	    				ResultSet resultat = statement.executeQuery("Select idAlbum,dateCreation FROM album ORDER BY idAlbum DESC limit 1;");
	    				while (resultat.next()) {
	    					int idAlbum = resultat.getInt("idAlbum");
	    					String dateCreation= resultat.getString("dateCreation");
	    					album.setDateCreation(dateCreation);
	    					album.setId(idAlbum);
	    				}
	    				return album;
	    			}	
	    			else
	    			{
	    				System.out.println("ajout echoue");
	    			}
	    			}
	    		catch (SQLException e) {
	                e.printStackTrace();
	    		}
	    		return null;
	}


	@Override
	public ArrayList<Album> lister() {
		ArrayList<Album> albums = new ArrayList<Album>();
		Connection connexion = null;
		Statement statement = null;
		ResultSet resultat = null;
		try {
			connexion = daoFactory.getConnection();
			statement = connexion.createStatement();
			resultat = statement.executeQuery("SELECT idAlbum,NomAlbum,Statut,Theme,User_idUser,description,dateCreation FROM Album;");

			while (resultat.next()) {
				int idAlbum = resultat.getInt("idAlbum");
				String nom = resultat.getString("NomAlbum");
				boolean isPrivate = resultat.getBoolean("Statut");
				String theme = resultat.getString("theme");
				int idUser = resultat.getInt("User_idUser");
				String description = resultat.getString("description");
				Date dateC = resultat.getDate("dateCreation");
				//Date dateM = resultat.getDate("dateMaj");
				DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");  
				String dateCreation =dateFormat.format(dateC);
				//String dateMaj =dateFormat.format(dateM);
			
				Album album = new Album();
				album.setId(idAlbum);
				album.setNom(nom);
				album.setPrivate(isPrivate);
				album.setImages(imageDao.lister(idAlbum));
				album.setTheme(theme);
				album.setUserId(idUser);
				album.setDescription(description);
				album.setDateCreation(dateCreation);
				//album.setDateMaj(dateMaj);

				albums.add(album);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return albums;
	}

	
	public ArrayList<Album> lister(int idU) {
		ArrayList<Album> albums = new ArrayList<Album>();
		Connection connexion = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultat = null;
		try {
			 connexion = daoFactory.getConnection();
	            preparedStatement=connexion.prepareStatement("SELECT * FROM Album where User_idUser=?;"); //sql select query
	            preparedStatement.setInt(1,idU); 
	            resultat=preparedStatement.executeQuery();
			
			while (resultat.next()) {
				int idAlbum = resultat.getInt("idAlbum");
				String nom = resultat.getString("NomAlbum");
				boolean isPrivate = resultat.getBoolean("Statut");
				String theme = resultat.getString("theme");
				int idUser = resultat.getInt("User_idUser");
				String description = resultat.getString("description");
				Date dateC = resultat.getDate("dateCreation");
				//Date dateM = resultat.getDate("dateMaj");
				DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");  
				String dateCreation =dateFormat.format(dateC);
				//String dateMaj =dateFormat.format(dateM);
			
				Album album = new Album();
				album.setId(idAlbum);
				album.setNom(nom);
				album.setPrivate(isPrivate);
				album.setImages(imageDao.lister(idAlbum));
				album.setTheme(theme);
				album.setUserId(idUser);
				album.setDescription(description);
				album.setDateCreation(dateCreation);
				//album.setDateMaj(dateMaj);
				
				album.setCount(album.getImages().size());
				System.out.println(album.getImages().size());
				System.out.println(album.getImages().toString());
				albums.add(album);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return albums;
	}


}
