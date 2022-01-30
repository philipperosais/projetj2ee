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
	
	// CREATE

	public boolean create(Article object) {
		boolean articleCreated = false;
		try {
			PreparedStatement req = connect.prepareStatement("INSERT INTO article (name,brand,quantity,photo,price,color,description,placeProduction,sizes,isVisible)" + "VALUES(?,?,?,?,?,?,?,?,?,?)");

			req.setString(1, object.getName());
			req.setString(2, object.getBrand());
			req.setInt(3, object.getQuantity());
			req.setString(4, object.getPhoto());
			req.setDouble(5, object.getPrice());
			req.setString(6, object.getColor());
			req.setString(7, object.getDescription());
			req.setString(8, object.getPlaceProduction());
			req.setString(9, object.getSizes());
			req.setBoolean(10, object.getIsVisible());
			
			
			req.executeUpdate();

			articleCreated = true;
			System.out.println("INSERTION REUSSIE");
		} catch (Exception e) {
			System.out.println("Insertion KO");
		}

		return articleCreated;
	}

	// READ
	
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
	
	// UPDATE
		public boolean edit(Article object) {
			boolean msg = false;
			try {
				PreparedStatement req = connect.prepareStatement("UPDATE article SET name=?, brand=?" + "WHERE idArticle= ?");
				req.setString(1, object.getName());
				req.setString(2, object.getBrand());
				req.setInt(3, object.getIdArticle());
				
				req.executeUpdate();
				
				System.out.println( object.getName()+ "  " +object.getBrand() +" a été bien updaté en base");
				msg = true;
				
			} catch (Exception e) {
				System.out.println("Insertion KO");
			}
			return msg;
		}
		
		public Article findById(int idArticle)  {
			Article article = null;
			try {
				PreparedStatement req = connect.prepareStatement("SELECT * FROM article WHERE idArticle = ?");
				
				req.setInt(1, idArticle);
	         
	        ResultSet resultSet = req.executeQuery();
	         
		        if (resultSet.next()) {
		            String name = resultSet.getString("name");
		            String brand = resultSet.getString("brand");
		            int quantity = resultSet.getInt("quantity");
		            String photo = resultSet.getString("photo");
		            double price = resultSet.getDouble("price");
		            String color = resultSet.getString("color");
		            String description = resultSet.getString("description");
		            String placeProduction = resultSet.getString("placeProduction");
		            String sizes = resultSet.getString("sizes");
		            boolean isVisible = resultSet.getBoolean("isVisible");
		            article = new Article(name, brand, quantity, photo, price, color, description, placeProduction, sizes, isVisible);
		        }
	        } catch (Exception e) {
				System.out.println("find KO");
			}
	         
	        return article;
	    }
		
		// DELETE
		public boolean delete(Article object) {
			boolean msg = false;
			try {
				PreparedStatement req = connect.prepareStatement("DELETE FROM article" + "WHERE idArticle=?");
				
				req.setInt(1, object.getIdArticle());
				
				req.executeUpdate();
				
				msg = true;
				
			} catch (Exception e) {
				System.out.println("DELETE KO");
			}
			return msg;
		}
}
