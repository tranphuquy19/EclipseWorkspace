package Client;

import java.io.Serializable;

@SuppressWarnings("serial")
public class User implements Serializable{
	private String userName;
	private String userPassword;

	public User() {

	}

	public User(String userName, String userPassword) {
		this.userName = userName;
		this.userPassword = userPassword;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public User getUser(String userName, String userPassword) {
		User model = new User(userName, userPassword);
		return model;
	}
}
