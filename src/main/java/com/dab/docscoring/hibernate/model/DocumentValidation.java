package com.dab.docscoring.hibernate.model;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class DocumentValidation implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;
	private String description;
	private Integer percentage;
	
	public DocumentValidation() {
	}

	public DocumentValidation(String description) {
		this.description = description;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "ID", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "DESCRIPTION", nullable = false, length = 100)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	@Column(name = "PERCENTAGE", nullable = false)
	public Integer getPercentage() {
		return percentage;
	}

	public void setPercentage(Integer percentage) {
		this.percentage = percentage;
	}

	@Override
	public String toString() {
		return "DocumentValidation [id=" + id + ", description=" + description
				+ ", percentage=" + percentage + "]";
	}
}