package com.dab.docscoring.hibernate.model;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

@Entity
@Table(name = "document_types", catalog = "documentscoring", uniqueConstraints = @UniqueConstraint(columnNames = "description"))
@NamedQueries(value={
		@NamedQuery(name="findAll", query="from DocumentType")
})
public class DocumentType implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String description;
	private boolean enabled;
	private String tipoPersona;
	
	public DocumentType() {
	}

	public DocumentType(String description, boolean enabled) {
		this.description = description;
		this.enabled = enabled;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "description", unique = true, nullable = false, length = 45)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "enabled", nullable = false)
	public boolean getEnabled() {
		return this.enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
	@Column(name = "tipo_persona", nullable = false, length = 10)
	public String getTipoPersona() {
		return tipoPersona;
	}

	public void setTipoPersona(String tipoPersona) {
		this.tipoPersona = tipoPersona;
	}
}