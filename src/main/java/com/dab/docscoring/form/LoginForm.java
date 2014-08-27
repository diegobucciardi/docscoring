package com.dab.docscoring.form;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;


public class LoginForm {
	
	@NotNull(message="Debe seleccionar una empresa")
	private Integer company;
	
	@NotBlank(message="Debe ingresar su password")
	@Length(min=4, max=8, message="Su contraseña debe tener entre 4 y 8 caracteres")
	private String userPassword;

	@NotBlank(message="Debe ingresar su nombre de usuario")
	private String userName;
	
	public Integer getCompany() {
		return company;
	}
	public void setCompany(Integer company) {
		this.company = company;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}	
}