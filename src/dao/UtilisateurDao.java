package dao;

import java.util.ArrayList;

import beans.Utilisateur;

public interface UtilisateurDao {
    int inscrire( Utilisateur utilisateur );
    Utilisateur connecter( Utilisateur utilisateur );
    ArrayList<Utilisateur> lister();
}