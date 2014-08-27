package com.dab.docscoring.form;

public class Validation {
	
	private String description;
	private Integer percentage;
	private boolean passed;
	
	public Validation(String description, Integer percentage, boolean passed) {
		this.description = description;
		this.percentage = percentage;
		this.passed = passed;
	}

	public Integer getPercentage() {
		return percentage;
	}
	public void setPercentage(Integer percentage) {
		this.percentage = percentage;
	}
	public boolean isPassed() {
		return passed;
	}
	public void setPassed(boolean passed) {
		this.passed = passed;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}