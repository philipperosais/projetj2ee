package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.impl.UserDao;
import model.User;

@WebServlet("/register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public Register() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("register.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String firstname = request.getParameter("firstname");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		User user = new User(firstname, name, email,password);
		
		UserDao ud = new UserDao();
		
		boolean exist = false;
		
		if (ud.mailExist(email)) {

			ud.create(user);

			exist = false;
			request.setAttribute("exist", exist);
			request.getRequestDispatcher("login.jsp").forward(request, response);

		} else {
			exist = true;
			request.setAttribute("exist", exist);
			request.getRequestDispatcher("register.jsp").forward(request, response);
			// response.sendRedirect("register");
		}
	}
}
