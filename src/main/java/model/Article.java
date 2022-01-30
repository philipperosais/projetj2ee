package model;

public class Article {
	private int idArticle;
	private String name;
	private String brand;
	private int quantity;
	private String photo;
	private double price;
	private String color;
	private String description;
	private String placeProduction;
	private String sizes;
	private double averageScore;
	private boolean isVisible;
	
	public Article(int idArticle, String name, String brand, int quantity, String photo, double price, String color,
			String description, String placeProduction, String sizes, double averageScore, boolean isVisible) {
		this.idArticle = idArticle;
		this.name = name;
		this.brand = brand;
		this.quantity = quantity;
		this.photo = photo;
		this.price = price;
		this.color = color;
		this.description = description;
		this.placeProduction = placeProduction;
		this.sizes = sizes;
		this.averageScore = averageScore;
		this.isVisible = isVisible;
	}
	
	public Article(int idArticle, String name, String brand, int quantity, String photo, double price, String color,
			String description, String placeProduction, String sizes, boolean isVisible) {
		this.idArticle = idArticle;
		this.name = name;
		this.brand = brand;
		this.quantity = quantity;
		this.photo = photo;
		this.price = price;
		this.color = color;
		this.description = description;
		this.placeProduction = placeProduction;
		this.sizes = sizes;
		this.isVisible = isVisible;
	}
	
	public Article(String name, String brand, int quantity, String photo, double price, String color,
			String description, String placeProduction, String sizes, boolean isVisible) {
		this.name = name;
		this.brand = brand;
		this.quantity = quantity;
		this.photo = photo;
		this.price = price;
		this.color = color;
		this.description = description;
		this.placeProduction = placeProduction;
		this.sizes = sizes;
		this.isVisible = isVisible;
	}
	
	public Article(String name, String photo, double price, double averageScore, boolean isVisible) {
		this.name = name;
		this.photo = photo;
		this.price = price;
		this.averageScore = averageScore;
		this.isVisible = isVisible;
	}
	
	public Article() {
		super();
	}

	public int getIdArticle() {
		return idArticle;
	}

	public void setIdArticle(int idArticle) {
		this.idArticle = idArticle;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}
	
	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPlaceProduction() {
		return placeProduction;
	}

	public void setPlaceProduction(String placeProduction) {
		this.placeProduction = placeProduction;
	}

	public String getSizes() {
		return sizes;
	}

	public void setSizes(String sizes) {
		this.sizes = sizes;
	}

	public double getAverageScore() {
		return averageScore;
	}

	public void setAverageScore(double averageScore) {
		this.averageScore = averageScore;
	}
	
	public boolean getIsVisible() {
		return isVisible;
	}

	public void setIsVisible(boolean isVisible) {
		this.isVisible = isVisible;
	}
}