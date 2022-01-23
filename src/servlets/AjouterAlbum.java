package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Album;
import beans.Utilisateur;
import dao.AlbumDao;
import dao.DaoFactory;

/**
 * Servlet implementation class AjouterAlbum
 */
@MultipartConfig
@WebServlet("/ajouter-album")
public class AjouterAlbum extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private AlbumDao albumDao;
	// private String URL
	// ="file:///Users/babacar/M2/javaee/workspace/projetPhoto/WebContent/images";

	public void init() throws ServletException {
		DaoFactory daoFactory = DaoFactory.getInstance();
		this.albumDao = daoFactory.getAlbumDao();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// request.setAttribute("album",.lister());
		this.getServletContext().getRequestDispatcher("/WEB-INF/AjouterAlbum.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("le code marche jusque la");
		Album album = new Album();
		Utilisateur user = (Utilisateur) request.getSession(false).getAttribute("utilisateurSession");
		System.out.println("Session bien récupéré");

		album.setNom(request.getParameter("nom"));
		album.setTheme(request.getParameter("theme"));
		album.setDescription(request.getParameter("theme"));
		album.setUserId(user.getId());

		album = albumDao.ajouter(album);
		getServletContext().setAttribute("album", album);
		getServletContext().getRequestDispatcher("/WEB-INF/AjouterImage.jsp").forward(request, response);

	}

}
