package com.dab.docscoring.hibernate.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "users", catalog = "documentscoring", uniqueConstraints = @UniqueConstraint(columnNames = "name"))
@NamedQueries(value={
		@NamedQuery(name="User.findAll", query="from User"),
		@NamedQuery(name="User.findByName", query="from User u where u.name = :name")
})
public class User implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private Company company;
	private String name;
	private String password;
	private Boolean enabled;
	private String rol;

	public User() {
	}

	public User(Company companies, String name, String password) {
		this.company = companies;
		this.name = name;
		this.password = password;
	}

	public User(Company companies, String name, String password,
			Boolean enabled, String rol, Integer company) {
		this.company = companies;
		this.name = name;
		this.password = password;
		this.enabled = enabled;
		this.rol = rol;
	}

	@GenericGenerator(name = "generator", strategy = "foreign", parameters = @Parameter(name = "property", value = "companies"))
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@OneToOne(fetch = FetchType.EAGER)
	@PrimaryKeyJoinColumn
	public Company getCompany() {
		return this.company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	@Column(name = "name", unique = true, nullable = false, length = 45)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "password", nullable = false, length = 16)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "enabled")
	public Boolean getEnabled() {
		return this.enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	@Column(name = "rol", length = 20)
	public String getRol() {
		return this.rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", company=" + company + ", name=" + name
				+ ", password=" + password + ", enabled=" + enabled + ", rol="
				+ rol + "]";
	}
}