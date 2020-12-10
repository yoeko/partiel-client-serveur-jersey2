package servlets;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domaine.Cours;
import domaine.Etudiant;
import domaine.User;
import service.CoursServiceClient;
import service.ICoursServiceClient;
import service.IStudentServiceClient;

/**
 * Servlet implementation class AjoutCoursServlet
 */
public class AjoutCoursServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RequestDispatcher dispatcher = null;
	private ICoursServiceClient courseService;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjoutCoursServlet() {
        courseService = new CoursServiceClient();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		dispatcher = request.getRequestDispatcher("coursAjout.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int nbHeure = Integer.valueOf(request.getParameter("courseTime"));
		Cours cours = new Cours(request.getParameter("courseTheme"),nbHeure);		
		HttpSession session = request.getSession();
		//session.setAttribute("cours", null);
		//user = (User) session.getAttribute("user");
		
		System.out.println(cours.getNumberHours());
		
		courseService.createCours(cours);
		
		session.setAttribute("courses", courseService.getAllCours());
		
		dispatcher = request.getRequestDispatcher("cours.jsp");
		
		dispatcher.forward(request, response);

	}

}
