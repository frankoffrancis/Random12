package apollo.model;

import javax.validation.constraints.NotNull;
/*import javax.validation.constraints.Size;*/

import apollo.custom.annotations.EmailConstraint;
import apollo.custom.annotations.PasswordConstraint;
import apollo.custom.annotations.UserNameConstraint;
/*import apollo.custom.annotations.UserNameConstraint;*/

public class Customer {

	private Integer customerID;
	@NotNull
	@UserNameConstraint
	private String userName;
	@NotNull
	@PasswordConstraint
	private String password;
	@NotNull
	@EmailConstraint
	private String email;
	
	private String newPassword;
	
	
	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public Customer() {
		this.customerID =0;
		this.userName= "";
		this.password="";
		this.email="";
	}
	
	public Integer getCustomerID() {
		return customerID;
	}
	public void setCustomerID(Integer customerID) {
		this.customerID = customerID;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
