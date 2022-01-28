package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.impl.ArticleDao;

@WebServlet("/shop")
public class Shop extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Shop() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArticleDao<Object> articleDao = new ArticleDao<Object>();
		request.setAttribute("articles", articleDao.read());
		request.getRequestDispatcher("shop.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}
}
