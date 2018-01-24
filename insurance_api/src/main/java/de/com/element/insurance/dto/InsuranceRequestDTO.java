package de.com.element.insurance.dto;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import de.com.element.insurance.factory.InsuranceType;

/**
 * @author diegosanteri
 *
 */
public class InsuranceRequestDTO {
	@NotNull(message="Username is required") 
	@JsonProperty(value ="username") 
	private String username;
	@NotNull(message="Product value is required") 
	@JsonProperty(value ="productValue")
	private double productValue;
	@NotNull(message="Insurance type is required") 
	@JsonProperty(value ="insurance") 
	private InsuranceType insurance;
	
	public InsuranceRequestDTO() {
	
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public double getProductValue() {
		return productValue;
	}

	public void setProductValue(double productValue) {
		this.productValue = productValue;
	}

	public InsuranceType getInsurance() {
		return insurance;
	}

	public void setInsurance(InsuranceType insurance) {
		this.insurance = insurance;
	}
}
