package newbies.java16.crmapp.model;

public class User {
	private String email;
	private String name;
	private String phone;
	private int role;

	public User(String email, String password, String name, String address, String phone, int role) {
		this.email = email;
		this.name = name;
		this.phone = phone;
		this.role = role;
	}

	public User() {
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}

}
