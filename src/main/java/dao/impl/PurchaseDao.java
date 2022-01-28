package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import dao.Connect;
import model.Purchase;


public class PurchaseDao<T> {

	static Connection connect = Connect.getConnection();

	public List<Purchase> read() {
		List<Purchase> listPurchase = new ArrayList<>();

		try {
			PreparedStatement req = connect.prepareStatement("SELECT * FROM purchase");

			ResultSet rs = req.executeQuery();

			while (rs.next()) {
				Purchase purchase = new Purchase();

				purchase.setIdPurchase(rs.getInt("idPurchase"));
				purchase.setEmailUser(rs.getString("emailUser"));
				purchase.setPurchaseDate(rs.getDate("purchaseDate"));
				
				listPurchase.add(purchase);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Liste KO - KO - KO");
		}
		return listPurchase;
	}
}
