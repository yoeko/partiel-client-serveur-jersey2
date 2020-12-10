package servlets;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;


import domaine.Etudiant;
import domaine.User;
import service.StudentServiceClient;


/**
 * Servlet implementation class SupprimerEtudiantServlet
 */
public class SupprimerEtudiantServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private StudentServiceClient studentService;
//	private CoursService courseService;
	private RequestDispatcher dispatcher = null;
	private User user = null;
//	private IEtudiantDao etudiantDao = new EtudiantDao();

	/**
	 * Default constructor.
	 */
	public SupprimerEtudiantServlet() {
		studentService = new StudentServiceClient();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		methode(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void methode(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		String object = request.getParameter("id");
		int id = Integer.valueOf(object);
		
		
//		session.setAttribute("courses", getAllCours());
		session.setAttribute("student", null);
		
		studentService.deleteStudent(id);
		
		
		session.setAttribute("message", "Suppression effectuée avec succès !!! ");
		session.setAttribute("students", studentService.getListStudent());
		dispatcher = request.getRequestDispatcher("etudiant.jsp");
		dispatcher.forward(request, response);
	}


//
//	private List<Cours> getAllCours() {
//
//		List<Cours> courses = Collections.emptyList();
//		try {
//
//			courses = courseService.getAllCours();
//		} catch (Exception e) {
//
//		}
//		return courses;
//	}

}
