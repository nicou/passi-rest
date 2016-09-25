package fi.softala.ttl.model;

import java.io.Serializable;

public class Instructor implements Serializable {

	private static final long serialVersionUID = 1L;

	private String username;
	private String firstanme;
	private String lastname;
	private String email;
	private String school;
	
	public Instructor() {
		super();
		this.username = "";
		this.firstanme = "";
		this.lastname = "";
		this.email = "";
		this.school = "";
	}

	public Instructor(String username, String firstanme, String lastname, String email, String school) {
		super();
		this.username = username;
		this.firstanme = firstanme;
		this.lastname = lastname;
		this.email = email;
		this.school = school;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFirstanme() {
		return firstanme;
	}

	public void setFirstanme(String firstanme) {
		this.firstanme = firstanme;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}
}
