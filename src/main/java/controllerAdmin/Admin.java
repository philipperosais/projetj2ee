package controllerAdmin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.impl.ArticleDao;
import dao.impl.PurchaseDao;
import model.Article;

@WebServlet("/admin")
public class Admin extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	ArticleDao<Object> articleDao = new ArticleDao<Object>();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PurchaseDao<Object> purchaseDao = new PurchaseDao<Object>();
		request.setAttribute("purchases", purchaseDao.read());
		
		request.setAttribute("articles", articleDao.read());
		
		request.getRequestDispatcher("admin.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String brand = request.getParameter("brand");
		int quantity = Integer.valueOf(request.getParameter("quantity"));
		String photo = request.getParameter("photo");
		double price = Double.valueOf(request.getParameter("price"));
		String color = request.getParameter("color");
		String description = request.getParameter("description");
		String placeProduction = request.getParameter("placeProduction");
		String sizes = request.getParameter("sizes");
		Boolean isVisible = Boolean.valueOf(request.getParameter("isVisible"));
		
		Article article = new Article(name,brand,quantity,photo,price,color,description,placeProduction,sizes,isVisible);
		
		request.setAttribute("ajout", articleDao.create(article));
		
		request.setAttribute("articles", articleDao.read());
		
		request.getRequestDispatcher("admin.jsp").forward(request, response);
	}

}
