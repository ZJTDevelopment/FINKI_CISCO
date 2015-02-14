package models;

import java.io.Serializable;

public class UserDetails implements Serializable {
	private static final long serialVersionUID = -7384870513975520328L;

	private String email;
	private String password;
	private String name;
	private String surname;

	public UserDetails() {
		email = new String();
		password = new String();
		name = new String();
		surname = new String();
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

}
