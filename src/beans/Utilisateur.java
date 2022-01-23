package beans;

import java.util.ArrayList;
import java.util.List;

public class Utilisateur {

	private int id=0;
	private String nom, prenom, login, password;
	private ArrayList<Album> albums;
	
	public Utilisateur( ) {
		
	}
	
	
	public Utilisateur(int id, String nom, String prenom, String login, String password) {

		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.login = login;
		this.password = password;
	}
	public Utilisateur( String nom, String prenom, String login, String password) {
		this(0, nom, prenom,login, password);
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
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public ArrayList<Album> getAlbums() {
		return albums;
	}


	public void setAlbums(ArrayList<Album> albums) {
		this.albums = albums;
	}


	@Override
	public String toString() {
		return "Utilisateur [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", login=" + login + ", password="
				+ password + "]";
	}


	
	
}
