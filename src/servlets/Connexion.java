package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Utilisateur;
import dao.DaoFactory;
import dao.UtilisateurDao;

/**
 * Servlet implementation class Connexion
 */
@WebServlet("/connexion")
public class Connexion extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UtilisateurDao utilisateurDao;

	public void init() throws ServletException {
		DaoFactory daoFactory = DaoFactory.getInstance();
		this.utilisateurDao = daoFactory.getUtilisateurDao();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher("/WEB-INF/Connexion.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Utilisateur utilisateur = new Utilisateur();
		if (request.getParameter("btn_login") != null) // check condition
		{
			utilisateur.setLogin(request.getParameter("login"));
			utilisateur.setPassword(request.getParameter("password"));

			Utilisateur utilisateurSession = utilisateurDao.connecter(utilisateur);

			if (utilisateurSession != null) {
				HttpSession session = request.getSession(true);
    			session.setAttribute("utilisateurSession", utilisateurSession);
				request.setAttribute("successMsg", "register successfully please login account");
				// register successfully message

				request.setAttribute("utilisateurs", utilisateurDao.lister());

				response.sendRedirect(request.getContextPath() + "/accueil");
			} else {

				request.setAttribute("errorMsg", "sorry email already exist");
				response.sendRedirect(request.getContextPath() + "/connexion"); // message for email already exist

			}

		}
	}
}
