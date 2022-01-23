package beans;


public class Image {
	private int id;
	private String titre, url, drescription, largeur, longueur, dateCreation, dateMaj;
	private String[] motsClé;

	public Image() {

	}

	public Image(int id, String titre, String url, String drescription, String largeur, String longueur,
			String dateCreation, String dateMaj, String[] motsClé) {
		this.id = id;
		this.titre = titre;
		this.url = url;
		this.drescription = drescription;
		this.largeur = largeur;
		this.longueur = longueur;
		this.dateCreation = dateCreation;
		this.dateMaj = dateMaj;
		this.motsClé = motsClé;

	}

	public Image(String titre, String url, String description, String largeur, String longueur, String dateCreation,
			String dateMaj, String[] motsClé) {
		this(0, titre, url, description, largeur, longueur, dateCreation, dateMaj, motsClé);
	}

	public Image(String titre) {
		this.titre = titre;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getDrescription() {
		return drescription;
	}

	public void setDrescription(String drescription) {
		this.drescription = drescription;
	}

	public String getLargeur() {
		return largeur;
	}

	public void setLargeur(String largeur) {
		this.largeur = largeur;
	}

	public String getLongueur() {
		return longueur;
	}

	public void setLongueur(String longueur) {
		this.longueur = longueur;
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

	public String[] getMotsClé() {
		return motsClé;
	}

	public void setMotsClé(String[] motsClé) {
		this.motsClé = motsClé;
	}


}
