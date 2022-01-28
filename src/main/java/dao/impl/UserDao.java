package dao.impl;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Base64;

import dao.Connect;
import model.User;

public class UserDao {
	Connection connect = Connect.getConnection();

	public boolean create(User object) {
		boolean msg = false;
		try {
			PreparedStatement req = connect.prepareStatement("INSERT INTO user (firstname, name, email, password)"
					+ " VALUES (?,?,?,?)");
			req.setString(1, object.getFirstname());
			req.setString(2, object.getName());
			req.setString(3, object.getEmail());
			req.setString(4, encode(object.getPassword()));
			
			req.executeUpdate();
			System.out.println("Insertion réussie");
			msg = true;
			
		} catch (Exception e) {
			System.out.println("Insertion KO");
		}
		return msg;
	}
	
	public boolean mailExist(String email) {
        Boolean msg = false;
        try {
            PreparedStatement sql = connect.prepareStatement("SELECT * FROM user WHERE email = ?");

            sql.setString(1, email);

            ResultSet rs = sql.executeQuery();

            if(!rs.next()) {
                msg = true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return msg;
    }
	
	
	// Cryptage du Password
	
	public static String encode(String value) throws NoSuchAlgorithmException {

		MessageDigest mdp = MessageDigest.getInstance("SHA-256");
		byte[] hash = mdp.digest(value.getBytes(StandardCharsets.UTF_8));
		String encoded = Base64.getEncoder().encodeToString(hash);
	
		return encoded;

	}
	
	public User login(String email, String password) {
        //boolean msg = false;
        try {
            PreparedStatement sql = connect.prepareStatement("SELECT * FROM user WHERE email=? AND password=?");
            sql.setString(1, email);
            try {
                sql.setString(2, encode(password));
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
            ResultSet rs = sql.executeQuery();
            
            if(rs.next()) {
                //msg = true;
            	return new User(rs.getString("firstname"), rs.getString("name"),rs.getString("email"));
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
