package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domaine.Cours;
import domaine.Etudiant;
import service.CoursServiceClient;
import service.ICoursServiceClient;
import service.IStudentServiceClient;
import service.StudentServiceClient;

/**
 * Servlet implementation class EtudiantCoursServlet
 */
public class EtudiantCoursServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IStudentServiceClient studentService;
	private ICoursServiceClient courseService;
	private RequestDispatcher dispatcher = null;
//	private IEtudiantDao etudiantDao = new EtudiantDao();

	/**
	 * Default constructor.
	 */
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EtudiantCoursServlet() {
        super();
        // TODO Auto-generated constructor stub
        studentService = new StudentServiceClient();
        courseService = new CoursServiceClient();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		methode(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String object = request.getParameter("id") ;
		Long id = Long.valueOf(object);
		
		String course = request.getParameter("listeCours");	
		Long idCourse = Long.valueOf(course);
		Etudiant student = studentService.getStudentById(id);
		HttpSession session = request.getSession();
		student.setCours(courseService.getCoursById(idCourse));
		
		System.out.println(course);
		
		studentService.updateStudent(id, student);
		dispatcher = request.getRequestDispatcher("etudiant.jsp");
		dispatcher.forward(request, response);
	}
	
	public void methode(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		String object = request.getParameter("id");
		Long id = Long.valueOf(object);
				
		Etudiant student = studentService.getStudentById(id);
		List<Cours> listCours=courseService.getAllCours();

		dispatcher = request.getRequestDispatcher("etudiantCours.jsp");
		session.setAttribute("student", student);
		session.setAttribute("courses", listCours);

		dispatcher.forward(request, response);
	}

}
