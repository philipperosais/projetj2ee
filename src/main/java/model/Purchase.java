package model;

import java.sql.Date;

public class Purchase {
	private int idPurchase;
	private String emailUser;
	private Date purchaseDate;
	
	public Purchase(int idPurchase, String emailUser, Date purchaseDate) {
		this.idPurchase = idPurchase;
		this.emailUser = emailUser;
		this.purchaseDate = purchaseDate;
	}

	public Purchase() {
		super();
	}

	public int getIdPurchase() {
		return idPurchase;
	}

	public void setIdPurchase(int idPurchase) {
		this.idPurchase = idPurchase;
	}

	public String getEmailUser() {
		return emailUser;
	}

	public void setEmailUser(String emailUser) {
		this.emailUser = emailUser;
	}

	public Date getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

}
