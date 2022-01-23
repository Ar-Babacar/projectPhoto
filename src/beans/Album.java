package beans;

import java.util.ArrayList;
  
import beans.Image;

public class Album {
	private int id;
	private String nom, theme, description, dateCreation, dateMaj;
	private boolean isPrivate = false;
	private ArrayList<Image> images;
	private int idUser;
	private int count;

	public Album() {

	}

	public Album(int id, String nom, String theme, boolean isPrivate, ArrayList<Image> images, int idUser, int count,
			String dateCreation, String dateMaj, String description) {
		this.id = id;
		this.nom = nom;
		this.theme = theme;
		this.isPrivate = isPrivate;
		this.setImages(images);
		this.idUser = idUser;
		this.setDateCreation(dateCreation);
		this.setDateMaj(dateMaj);
		this.setCount(count);
		this.setDescription(description);
	}

	public Album(String nom, String theme, ArrayList<Image> images, int idUser, int count, String dateCreation,
			String dateMaj, String description) {
		this(0, nom, theme, false, images, idUser, count, dateCreation, dateMaj, description);
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

	public String getTheme() {
		return theme;
	}

	public void setTheme(String theme) {
		this.theme = theme;
	}

	public boolean isPrivate() {
		return isPrivate;
	}

	public void setPrivate(boolean isPrivate) {
		this.isPrivate = isPrivate;
	}

	public void setUserId(int idUser) {
		this.idUser = idUser;

	}

	public int getUserID() {

		return idUser;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(String dateCreation) {
		this.dateCreation = dateCreation;
	}

	public String getDateMaj() {
		return dateMaj;
	}

	public void setDateMaj(String dateMaj) {
		this.dateMaj = dateMaj;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public ArrayList<Image> getImages() {
		return images;
	}

	public void setImages(ArrayList<Image> images) {
		this.images = images;
	}

}
