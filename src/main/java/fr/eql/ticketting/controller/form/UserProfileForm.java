package fr.eql.ticketting.controller.form;

public class UserProfileForm {
	
	private String pseudo;
	
	private String passwordCheck;
	
	private String password;
	
	private String passwordConfirmation;
	
	private String errorMessage;
	

	public UserProfileForm() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserProfileForm(String pseudo, String passwordCheck, String password, String passwordConfirmation,
			String errorMessage) {
		super();
		this.pseudo = pseudo;
		this.passwordCheck = passwordCheck;
		this.password = password;
		this.passwordConfirmation = passwordConfirmation;
		this.errorMessage = errorMessage;
	}



	public String getPseudo() {
		return pseudo;
	}

	public void setUser(String pseudo) {
		this.pseudo = pseudo;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPasswordConfirmation() {
		return passwordConfirmation;
	}

	public void setPasswordConfirmation(String passwordConfirmation) {
		this.passwordConfirmation = passwordConfirmation;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public String getPasswordCheck() {
		return passwordCheck;
	}
	public void setPasswordCheck(String passwordCheck) {
		this.passwordCheck = passwordCheck;
	}
	@Override
	public String toString() {
		return "UserProfileForm [pseudo=" + pseudo + ", passwordCheck=" + passwordCheck + ", password=" + password
				+ ", passwordConfirmation=" + passwordConfirmation + ", errorMessage=" + errorMessage + "]";
	}
	
	

}
