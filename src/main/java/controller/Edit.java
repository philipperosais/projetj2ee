package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.impl.ArticleDao;
import model.User;

@WebServlet("/edit")
public class Edit extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	ArticleDao articleDao = new ArticleDao();
	
    public Edit() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("idArticle"));
		
		request.setAttribute("showArticle", articleDao.findById(id));
		
		request.getRequestDispatcher("Article/admin.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Article editArticle = new Article(id, request.getParameter("name"),request.getParameter("brand"));
		
		request.setAttribute("showArticle", articleDao.edit(editArticle));
		
		//REDIRECTION VERS ARTICLE
		response.sendRedirect("article");
	}

}
