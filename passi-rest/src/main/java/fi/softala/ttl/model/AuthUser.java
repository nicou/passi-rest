/**
 * @author Mika Ropponen
 */
package fi.softala.ttl.model;

import java.io.Serializable;

public class AuthUser implements Serializable {

	private static final long serialVersionUID = 1L;

	private String username;
	private String password;
	private String passwordConfirm;
	private String firstname;
	private String lastname;
	private String email;
	private String phone;
	
	public AuthUser() {
		super();
	}

	public AuthUser(String username, String password, String passwordConfirm) {
		super();
		this.username = username;
		this.password = password;
		this.passwordConfirm = passwordConfirm;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPasswordConfirm() {
		return passwordConfirm;
	}

	public void setPasswordConfirm(String passwordConfirm) {
		this.passwordConfirm = passwordConfirm;
	}
	
	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

}
