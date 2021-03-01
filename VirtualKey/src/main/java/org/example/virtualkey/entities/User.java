package org.example.virtualkey.entities;

public class User {
	
	private String firstName;
	private String lastName;
	private long id;
	private String email;
	
	public User() {}
	
	public User(String firstName, String lastName, long id, String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.id = id;
		this.email = email;
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public String toString() {
		return "Developer Details\nFirst Name : " + firstName + "\nLast Name : " + lastName + "\nID : " + id + "\nEmail : " + email;
	}
	
}
