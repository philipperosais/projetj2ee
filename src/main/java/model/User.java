package model;

public class User {

	// Les attributs
	
	private int id;
	private String firstname;
	private String name;
	private String email;
	private String password;

	// Les constructeurs
	
	public User(String firstname, String name, String email, String password) {
		this.firstname = firstname;
		this.name = name;
		this.email = email;
		this.password = password;
	}
	
	public User(String firstname, String name, String email) {
		this.firstname = firstname;
		this.name = name;
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return firstname + " " + name + " " + email + " " + password;
	}

}
