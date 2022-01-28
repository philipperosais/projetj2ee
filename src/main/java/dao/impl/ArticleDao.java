package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import dao.Connect;
import model.Article;

public class ArticleDao<T> {

	static Connection connect = Connect.getConnection();

//	public boolean create(Article object) {
//		boolean msg = false;
//		try {
//			PreparedStatement req = connect.prepareStatement(
//					"INSERT INTO article (name,photo,price,averageScore)" + " VALUES (?,?,?,?)");
//
//			req.setString(1, object.getName());
//			req.setString(2, object.getPhoto());
//			req.setDouble(3, object.getPrice());
//			req.setDouble(4, object.getAverageScore());
//
//			req.executeUpdate();
//
//			msg = true;
//
//		} catch (Exception e) {
//			System.out.println("Insertion KO");
//		}
//
//		return msg;
//	}

	public List<Article> read() {
		List<Article> listeArticle = new ArrayList<>();

		try {
			PreparedStatement req = connect.prepareStatement("SELECT * FROM article");

			ResultSet rs = req.executeQuery();

			while (rs.next()) {
				Article article = new Article();

				article.setIdArticle(rs.getInt("idArticle"));
				article.setName(rs.getString("name"));
				article.setBrand(rs.getString("brand"));
				article.setQuantity(rs.getInt("quantity"));
				article.setPhoto(rs.getString("photo"));
				article.setPrice(rs.getDouble("price"));
				article.setColor(rs.getString("color"));
				article.setDescription(rs.getString("description"));
				article.setPlaceProduction(rs.getString("placeProduction"));
				article.setSizes(rs.getString("sizes"));
				article.setAverageScore(rs.getDouble("averageScore"));
				article.setIsVisible(rs.getBoolean("isVisible"));
				
				listeArticle.add(article);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Liste KO - KO - KO");
		}
		return listeArticle;
	}
}
