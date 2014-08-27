package com.dab.docscoring.form;

import javax.validation.constraints.NotNull;


public class ScoringForm{
	
	@NotNull(message="Debe seleccionar un tipo de documento")
	private Integer selectedDocument;
	
	private String origFoto;
	
	private Validation[] validations;
	
	private Integer minimum;
	
	public Integer getSelectedDocument() {
		return selectedDocument;
	}

	public void setSelectedDocument(Integer selectedDocument) {
		this.selectedDocument = selectedDocument;
	}

	public String getOrigFoto() {
		return origFoto;
	}

	public void setOrigFoto(String origFoto) {
		this.origFoto = origFoto;
	}

	public Integer getMinimum() {
		return minimum;
	}

	public void setMinimum(Integer minimum) {
		this.minimum = minimum;
	}

	public Validation[] getValidations() {
		return validations;
	}

	public void setValidations(Validation[] validations) {
		this.validations = validations;
	}
}