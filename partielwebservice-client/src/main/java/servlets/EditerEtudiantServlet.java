package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;

import domaine.Etudiant;

/**
 * Servlet implementation class EditerEtudiantServlet
 */
public class EditerEtudiantServlet extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//	private EtudiantService studentService;
	private RequestDispatcher dispatcher = null;
//	private IEtudiantDao etudiantDao = new EtudiantDao();

	/**
	 * Default constructor.
	 */
	public EditerEtudiantServlet() {
//		studentService = new EtudiantService(etudiantDao);
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
				
//		Etudiant student = studentService.getEtudiant((long) id);
		
		
		dispatcher.forward(request, response);
	}

	
}
