package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import beans.Album;
import beans.Image;
import dao.DaoFactory;
import dao.ImageDao;



/**
 * Servlet implementation class AjouterImage
 */
@MultipartConfig
@WebServlet("/ajouter-image")
public class AjouterImage extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ImageDao imageDao;
	//private String URL ="file:///Users/babacar/M2/javaee/workspace/projetPhoto/WebContent/images";
	private String URL ="file:///Users/babacar/Downloads";

	public void init() throws ServletException {
		DaoFactory daoFactory = DaoFactory.getInstance();
		this.imageDao = daoFactory.getImageDao();
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//request.setAttribute("album",.lister());
	
		this.getServletContext().getRequestDispatcher("/WEB-INF/AjouterImage.jsp").forward(request, response);	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("le code marche jusque la");
		Image image = new Image();
		Album album = (Album) getServletContext().getAttribute("album");
		if(album==null) {
			System.out.println("fork2");
		}else {
			System.out.println("good2");
		}
		

		Part file = request.getPart("image");

		// Recuperation du nom de l'image
		String imageFileName = file.getSubmittedFileName();

		System.out.println("nom de l'image selectionne : " + imageFileName);

		String uploadPath = URL + "/" + imageFileName;
		System.out.println("chemin : " + uploadPath);

		image.setTitre(imageFileName);
		image.setUrl(uploadPath);
		imageDao.ajouter(image, file, album);
		getServletContext().getRequestDispatcher("/WEB-INF/Accueil.jsp").forward(request,response);
		
	}

}
