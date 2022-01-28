package controllerAdmin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.impl.ArticleDao;
import dao.impl.PurchaseDao;

@WebServlet("/admin")
public class Admin extends HttpServlet {
	private static final long serialVersionUID = 1L;
                                  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PurchaseDao<Object> purchaseDao = new PurchaseDao<Object>();
		request.setAttribute("purchases", purchaseDao.read());
		
		ArticleDao<Object> articleDao = new ArticleDao<Object>();
		request.setAttribute("articles", articleDao.read());
		
		request.getRequestDispatcher("admin.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String name = request.getParameter("name");
//		String photo = request.getParameter("photo");
//		double price = Double.valueOf(request.getParameter("price"));
//		double averageScore = Double.valueOf(request.getParameter("averageScore"));
//		boolean isVisible = Boolean.valueOf(request.getParameter("isVisible"));
//		
//		Article article = new Article(name,photo,price,averageScore,isVisible);
//		ArticleDao<Object> articleDao = new ArticleDao<Object>();
//		
//		request.setAttribute("ajout", articleDao.create(article));
//		request.setAttribute("articles", articleDao.read());
//		request.getRequestDispatcher("admin.jsp").forward(request, response);
	}

}
