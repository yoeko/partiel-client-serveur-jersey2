package servlets;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;


import domaine.Etudiant;
import domaine.User;
import service.StudentServiceClient;

/**
 * Servlet implementation class AjoutEtudiantServlet
 */
//@WebServlet("/AjoutEtudiant")
public class AjoutEtudiantServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private StudentServiceClient studentService;
	private RequestDispatcher dispatcher = null;
//	private CoursService courseService;
	private User user = null;
//	private IEtudiantDao etudiantDao = new EtudiantDao();
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AjoutEtudiantServlet() {
		studentService = new StudentServiceClient();
//		courseService = new CoursService();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		dispatcher = request.getRequestDispatcher("etudiantAjout.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Etudiant student = new Etudiant(request.getParameter("firstName"), request.getParameter("lastName"),
				request.getParameter("mailAdresse"), request.getParameter("adress"),
				request.getParameter("numberPhone"), new Date());

		HttpSession session = request.getSession();
		session.setAttribute("student", null);
		user = (User) session.getAttribute("user");
		
		studentService.createStudent(student);
		
		session.setAttribute("students", studentService.getListStudent());
		//session.setAttribute("courses", getAllCourses());
		if(user.getProfil().equalsIgnoreCase("directeur")) {
			dispatcher = request.getRequestDispatcher("etudiant.jsp");
		}
		else {
			dispatcher = request.getRequestDispatcher("etudiantAjout.jsp");

		}
		
		
		
		dispatcher.forward(request, response);
	}
	
}
