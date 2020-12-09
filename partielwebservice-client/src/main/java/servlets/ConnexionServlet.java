package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domaine.User;
import service.UserServiceClient;


/**
 * Servlet implementation class ConnexionServlet
 */
@WebServlet("/Connexion")
public class ConnexionServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private UserServiceClient userService;
//	private EtudiantService studentService;
//	private CoursService courseService;
	private RequestDispatcher dispatcher = null;
//	private IEtudiantDao etudiantDao = new EtudiantDao();

	/**
	 * Default constructor.
	 */
	public ConnexionServlet() {
		userService = new UserServiceClient();
//		courseService = new CoursService();
//		studentService = new EtudiantService(etudiantDao);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		dispatcher = request.getRequestDispatcher("index.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		methode(request, response);
	}

	/**
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void methode(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		User user = new User();
		user.setLogin(request.getParameter("login"));
		user.setPassword(request.getParameter("password"));
		
		System.out.println(user.getLogin() + user.getPassword());
		
		User userRetour = userService.getUser();
		
		System.out.println("le user retour "+ userRetour.getFirst_name());

		
		if (userRetour != null && userRetour.getLogin().equalsIgnoreCase(request.getParameter("login"))
				&& userRetour.getPassword().equalsIgnoreCase(request.getParameter("password"))) {
			
			dispatcher = request.getRequestDispatcher("home.jsp");
			HttpSession session = request.getSession();
			session.setAttribute("user", userRetour);
			//session.setAttribute("students", lister());
//			session.setAttribute("courses", getAllCourses());

		} else {
			dispatcher = request.getRequestDispatcher("index.jsp");
		}
		dispatcher.forward(request, response);
		
	}

	/*
	 * public List<Etudiant> lister() {
	 * 
	 * DefaultClientConfig defaultClientConfig = new DefaultClientConfig();
	 * defaultClientConfig.getClasses().add(JacksonJsonProvider.class); Client
	 * client = Client.create(defaultClientConfig);
	 * 
	 * 
	 * WebResource webResource = client.resource(
	 * "http://localhost:8080/partielwebservice-webservice/rest/json/student/get");
	 * 
	 * ClientResponse response2 =
	 * webResource.accept("application/json").get(ClientResponse.class);
	 * 
	 * 
	 * return (List<Etudiant>) response2.getEntity(new
	 * GenericType<List<Etudiant>>(){});
	 * 
	 * }
	 */


}
