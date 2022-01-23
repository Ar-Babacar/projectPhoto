package dao;

import java.util.ArrayList;
import beans.Album;

public interface AlbumDao {
    public Album ajouter(Album album); 
	public ArrayList<Album> lister();
	public ArrayList<Album> lister(int idU);

}
