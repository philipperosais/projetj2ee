package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import dao.impl.UserDao;

@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Login() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		UserDao ud = new UserDao();
		
		if (ud.login(email, password) != null) {

			HttpSession session = request.getSession();

			session.setAttribute("user",ud.login(email, password));

			response.sendRedirect("index");
		} else {
			// Echec de login !
			Boolean logged = false;
			request.setAttribute("logged", logged);
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}
}
