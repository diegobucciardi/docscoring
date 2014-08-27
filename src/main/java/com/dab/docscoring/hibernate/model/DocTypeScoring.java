package com.dab.docscoring.hibernate.model;

// Generated 17/04/2014 20:13:14 by Hibernate Tools 4.0.0

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * DocTypeScoring generated by hbm2java
 */
@Entity
@Table(name = "doc_type_scoring", catalog = "documentscoring")
public class DocTypeScoring implements java.io.Serializable {

	private Integer id;
	private DocumentType documentTypes;
	private Company companies;
	private int porcentage;

	public DocTypeScoring() {
	}

	public DocTypeScoring(DocumentType documentTypes, Company companies,
			int porcentage) {
		this.documentTypes = documentTypes;
		this.companies = companies;
		this.porcentage = porcentage;
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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_doc_type", nullable = false)
	public DocumentType getDocumentTypes() {
		return this.documentTypes;
	}

	public void setDocumentTypes(DocumentType documentTypes) {
		this.documentTypes = documentTypes;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_company", nullable = false)
	public Company getCompanies() {
		return this.companies;
	}

	public void setCompanies(Company companies) {
		this.companies = companies;
	}

	@Column(name = "porcentage", nullable = false)
	public int getPorcentage() {
		return this.porcentage;
	}

	public void setPorcentage(int porcentage) {
		this.porcentage = porcentage;
	}

}
