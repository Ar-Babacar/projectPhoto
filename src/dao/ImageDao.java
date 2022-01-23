package dao;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.Part;

import beans.Album;
import beans.Image;

public interface ImageDao {
    void ajouter( Image image, Part file, Album album );
    ArrayList<Image> lister();
    ArrayList<Image> lister(int idAlbum);
}