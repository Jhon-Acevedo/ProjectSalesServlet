package model;

public class Client {

	private int id;
	private String name;
	private String lastName;
	private String phone;
	private String address;
	private String user;
	private String password;
	
	public Client(int id, String name, String lastName, String phone, String address, String user, String password) {
		super();
		this.id = id;
		this.name = name;
		this.lastName = lastName;
		this.phone = phone;
		this.address = address;
		this.user = user;
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	
	public String getLastName() {
		return lastName;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getUser() {
		return user;
	}

	public String getPassword() {
		return password;
	}
	
	public boolean verifyClient(String user, String password) {
		if(this.user.equals(user) && this.password.equals(password)) {
			return true;
		}
		return false;
	}
}
