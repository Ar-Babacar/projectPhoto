package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import beans.Album;
import beans.Image;

import javax.servlet.http.Part;

public class ImageDaoImpl implements ImageDao {
	private DaoFactory daoFactory;

	ImageDaoImpl(DaoFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public void ajouter(Image image, Part file, Album album) {
		Connection connexion = null;
		PreparedStatement preparedStatement = null;
		System.out.println(album.getId());
		try {
			connexion = daoFactory.getConnection();

			String query = "Insert into image(Url,Titre, Album_idAlbum) values(?,?,?);";
			preparedStatement = connexion.prepareStatement(query);
			preparedStatement.setString(1, image.getUrl());
			preparedStatement.setString(2, image.getTitre());
			preparedStatement.setInt(3, album.getId());
			int row = preparedStatement.executeUpdate(); // nbr de row affectes a la base

			if (row > 0) {
				//album.setImages(image);
				System.out.println("ajout effectue avec succes");
			} else {
				System.out.println("ajout echoue");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public ArrayList<Image> lister() {
		ArrayList<Image> images = new ArrayList<Image>();
		Connection connexion = null;
		Statement statement = null;
		ResultSet resultat = null;

		try {
			connexion = daoFactory.getConnection();
			statement = connexion.createStatement();
			resultat = statement.executeQuery("SELECT Titre,Url FROM Image;");

			while (resultat.next()) {
				String titre = resultat.getString("Titre");
				String url = resultat.getString("Url");

				Image image = new Image();
				image.setTitre(titre);
				image.setUrl(url);

				images.add(image);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return images;

	}
	public ArrayList<Image> lister(int idAlbum) {
		ArrayList<Image> images = new ArrayList<Image>();
		Connection connexion = null;
        PreparedStatement preparedStatement = null;
        

        try {
            connexion = daoFactory.getConnection();
            preparedStatement=connexion.prepareStatement("SELECT * FROM Image where Album_idAlbum= ?;"); //sql select query
            preparedStatement.setInt(1,idAlbum); 
            ResultSet resultat=preparedStatement.executeQuery();
		
			while (resultat.next()) {
				String titre = resultat.getString("Titre");
				String url = resultat.getString("Url");
				int idImg = resultat.getInt("idImage");
				Image image = new Image();
				image.setTitre(titre);
				image.setUrl(url);
				image.setId(idImg);

				images.add(image);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return images;

	}
}